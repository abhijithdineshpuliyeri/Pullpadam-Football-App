package com.example.pullpadamwherethegamebegins.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pullpadamwherethegamebegins.data.model.*
import com.example.pullpadamwherethegamebegins.data.repository.AIMatchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel managing all 20 PULLPADAM AI features.
 */
class AIMatchViewModel(
    private val repository: AIMatchRepository = AIMatchRepository()
) : ViewModel() {

    private val _gameMatchesState = MutableStateFlow<UiState<List<GameMatch>>>(UiState.Idle)
    val gameMatchesState: StateFlow<UiState<List<GameMatch>>> = _gameMatchesState.asStateFlow()

    private val _playerMatchesState = MutableStateFlow<UiState<List<PlayerMatch>>>(UiState.Idle)
    val playerMatchesState: StateFlow<UiState<List<PlayerMatch>>> = _playerMatchesState.asStateFlow()

    private val _teamMatchState = MutableStateFlow<UiState<TeamMatchResult>>(UiState.Idle)
    val teamMatchState: StateFlow<UiState<TeamMatchResult>> = _teamMatchState.asStateFlow()

    private val _chatMessages = MutableStateFlow<List<AIChatMessage>>(
        listOf(
            AIChatMessage(
                sender = "Pullpadam AI",
                text = "Hello! I am PULLPADAM AI - your local football assistant. Tap an option below or ask me anything:",
                isUser = false
            )
        )
    )
    val chatMessages: StateFlow<List<AIChatMessage>> = _chatMessages.asStateFlow()

    private val _isChatLoading = MutableStateFlow(false)
    val isChatLoading: StateFlow<Boolean> = _isChatLoading.asStateFlow()

    // Guided Chat Flow State & Chips
    private var guidedFlowStep = "MENU"
    private var tempTurfArea = ""
    private var tempPlayerPos = ""
    private var tempPlayerArea = ""

    private val _chatChips = MutableStateFlow(
        listOf("🏟️ Turf & Slots", "🏃 Find Players", "👥 My Team Squad", "👟 Training Drills")
    )
    val chatChips: StateFlow<List<String>> = _chatChips.asStateFlow()

    fun handleGuidedChoice(choice: String) {
        val userMsg = AIChatMessage(sender = "You", text = choice, isUser = true)
        _chatMessages.value = _chatMessages.value + userMsg

        when {
            choice.contains("Turf") -> {
                guidedFlowStep = "TURF_AREA"
                _chatChips.value = listOf("Kannur", "Thana", "Valapattanam", "South Bazar")
                addAiMessage("Great! Which area are you looking for turfs in?")
            }
            guidedFlowStep == "TURF_AREA" -> {
                tempTurfArea = choice
                guidedFlowStep = "TURF_BUDGET"
                _chatChips.value = listOf("1000-1500", "1500-2000", "2000-2500")
                addAiMessage("Got it ($tempTurfArea). What is your budget range per hour?")
            }
            guidedFlowStep == "TURF_BUDGET" -> {
                val budget = choice
                guidedFlowStep = "MENU"
                _chatChips.value = listOf("🏟️ Turf & Slots", "🏃 Find Players", "👥 My Team Squad", "👟 Training Drills")
                sendChatMessage("FILTER_TURF:$tempTurfArea|$budget")
            }

            choice.contains("Player") -> {
                guidedFlowStep = "PLAYER_POSITION"
                _chatChips.value = listOf("Midfielder", "Striker", "Defender", "Goalkeeper", "Winger")
                addAiMessage("Awesome! Which position are you looking for?")
            }
            guidedFlowStep == "PLAYER_POSITION" -> {
                tempPlayerPos = choice
                guidedFlowStep = "PLAYER_AREA"
                _chatChips.value = listOf("Kannur", "Thana", "Valapattanam")
                addAiMessage("Got it ($tempPlayerPos). Which area should the player be located in?")
            }
            guidedFlowStep == "PLAYER_AREA" -> {
                tempPlayerArea = choice
                guidedFlowStep = "PLAYER_STYLE"
                _chatChips.value = listOf("Box-to-Box", "Counter-Attacker", "Playmaker", "High Compatibility (90%+)")
                addAiMessage("Preferred playing style or compatibility level?")
            }
            guidedFlowStep == "PLAYER_STYLE" -> {
                val style = choice
                guidedFlowStep = "MENU"
                _chatChips.value = listOf("🏟️ Turf & Slots", "🏃 Find Players", "👥 My Team Squad", "👟 Training Drills")
                sendChatMessage("FILTER_PLAYER:$tempPlayerPos|$tempPlayerArea|$style")
            }

            else -> {
                guidedFlowStep = "MENU"
                _chatChips.value = listOf("🏟️ Turf & Slots", "🏃 Find Players", "👥 My Team Squad", "👟 Training Drills")
                sendChatMessage(choice)
            }
        }
    }

    private fun addAiMessage(text: String) {
        val aiMsg = AIChatMessage(sender = "Pullpadam AI", text = text, isUser = false)
        _chatMessages.value = _chatMessages.value + aiMsg
    }

    // Smart Booking Query State
    private val _smartBookingState = MutableStateFlow<UiState<SmartBookingQuery>>(UiState.Idle)
    val smartBookingState: StateFlow<UiState<SmartBookingQuery>> = _smartBookingState.asStateFlow()

    // My Team Squad Roster State
    private val _mySquad = MutableStateFlow<List<TeamMember>>(
        listOf(
            TeamMember(name = "Rahul K.", position = "Midfielder", skillLevel = "Advanced", isAvailable = true),
            TeamMember(name = "Arjun M.", position = "Defender", skillLevel = "Intermediate", isAvailable = true),
            TeamMember(name = "Anas V.", position = "Goalkeeper", skillLevel = "Advanced", isAvailable = true),
            TeamMember(name = "Subhash T.", position = "Striker", skillLevel = "Intermediate", isAvailable = true),
            TeamMember(name = "Vishnu P.", position = "Winger", skillLevel = "Casual", isAvailable = true),
            TeamMember(name = "Fahad S.", position = "Midfielder", skillLevel = "Intermediate", isAvailable = false),
            TeamMember(name = "Nihal R.", position = "Defender", skillLevel = "Casual", isAvailable = true)
        )
    )
    val mySquad: StateFlow<List<TeamMember>> = _mySquad.asStateFlow()

    fun addSquadMember(name: String, position: String) {
        if (name.isBlank()) return
        val pos = position.ifBlank { "Midfielder" }
        val newMember = TeamMember(name = name.trim(), position = pos, isAvailable = true)
        _mySquad.value = _mySquad.value + newMember
    }

    fun togglePlayerAvailability(memberId: String) {
        _mySquad.value = _mySquad.value.map {
            if (it.id == memberId) it.copy(isAvailable = !it.isAvailable) else it
        }
    }

    fun getArrangedLineup(format: String = "7v7"): SquadLineupResult {
        return repository.arrangeSquadLineup(_mySquad.value, format)
    }

    fun updateApiKey(apiKey: String) {
        repository.setApiKey(apiKey)
    }

    fun loadGameMatches(format: String, time: String, budget: String, distance: String) {
        viewModelScope.launch {
            _gameMatchesState.value = UiState.Loading
            try {
                val matches = repository.fetchGameMatches(format, time, budget, distance)
                _gameMatchesState.value = UiState.Success(matches)
            } catch (e: Exception) {
                _gameMatchesState.value = UiState.Error(e.message ?: "Failed to load game matches")
            }
        }
    }

    fun loadPlayerMatches(position: String, playersNeeded: Int, format: String, level: String, distance: String) {
        viewModelScope.launch {
            _playerMatchesState.value = UiState.Loading
            try {
                val matches = repository.fetchPlayerMatches(position, playersNeeded, format, level, distance)
                _playerMatchesState.value = UiState.Success(matches)
            } catch (e: Exception) {
                _playerMatchesState.value = UiState.Error(e.message ?: "Failed to load player matches")
            }
        }
    }

    fun loadTeamMatches(playerCount: Int, format: String, time: String, distance: String) {
        viewModelScope.launch {
            _teamMatchState.value = UiState.Loading
            try {
                val result = repository.fetchTeamMatch(playerCount, format, time, distance)
                _teamMatchState.value = UiState.Success(result)
            } catch (e: Exception) {
                _teamMatchState.value = UiState.Error(e.message ?: "Failed to load team matches")
            }
        }
    }

    fun sendSmartBookingSearch(prompt: String) {
        viewModelScope.launch {
            _smartBookingState.value = UiState.Loading
            val query = repository.parseSmartBooking(prompt)
            _smartBookingState.value = UiState.Success(query)
        }
    }

    fun sendChatMessage(userText: String) {
        if (userText.isBlank()) return

        val userMsg = AIChatMessage(sender = "You", text = userText, isUser = true)
        val updatedList = _chatMessages.value + userMsg
        _chatMessages.value = updatedList
        _isChatLoading.value = true

        viewModelScope.launch {
            try {
                val contextHistory = updatedList.takeLast(6).joinToString("\n") { "${if (it.isUser) "User" else "AI"}: ${it.text}" }
                val aiResponse = repository.sendChatMessage(userText, contextHistory, _mySquad.value)
                val aiMsg = AIChatMessage(sender = "Pullpadam AI", text = aiResponse, isUser = false)
                _chatMessages.value = _chatMessages.value + aiMsg
            } catch (e: Exception) {
                val errorMsg = AIChatMessage(sender = "Pullpadam AI", text = "Sorry, I had trouble connecting. Please try again!", isUser = false)
                _chatMessages.value = _chatMessages.value + errorMsg
            } finally {
                _isChatLoading.value = false
            }
        }
    }

    // Direct Accessors for Features 4-20
    fun getTeamFormation(players: List<String>) = repository.getTeamFormation(players)
    fun getPerformanceReport(name: String) = repository.getPerformanceReport(name)
    fun getTrainingProgram(pos: String, level: String) = repository.getTrainingProgram(pos, level)
    fun getPositionRecommendation(name: String) = repository.getPositionRecommendation(name)
    fun getMatchReplacement(playerName: String, pos: String) = repository.getMatchReplacement(playerName, pos)
    fun getMatchPrediction(teamA: String, teamB: String) = repository.getMatchPrediction(teamA, teamB)
    fun getPlayerCompatibility(p1: String, p2: String) = repository.getPlayerCompatibility(p1, p2)
    fun getScheduleOptimization() = repository.getScheduleOptimization()
    fun getSmartNotifications() = repository.getSmartNotifications()
    fun getCommunityRecommendations() = repository.getCommunityRecommendations()
    fun getVideoAnalysis(title: String) = repository.getVideoAnalysis(title)
    fun getAccountTrust(userName: String) = repository.getAccountTrust(userName)
    fun getTournamentData() = repository.getTournamentData()
}
