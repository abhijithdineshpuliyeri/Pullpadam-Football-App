package com.example.pullpadamwherethegamebegins.data.repository

import com.example.pullpadamwherethegamebegins.data.api.GeminiApiService
import com.example.pullpadamwherethegamebegins.data.api.LocalMatchEngine
import com.example.pullpadamwherethegamebegins.data.model.*

/**
 * Repository to interface between ViewModels and the PULLPADAM AI Engine covering all 20 AI features.
 */
class AIMatchRepository(
    private val localEngine: LocalMatchEngine = LocalMatchEngine(),
    private val apiService: GeminiApiService = GeminiApiService()
) {

    fun setApiKey(apiKey: String) {
        apiService.updateApiKey(apiKey)
    }

    suspend fun fetchGameMatches(
        format: String,
        time: String,
        budget: String,
        distance: String
    ): List<GameMatch> {
        return if (apiService.hasApiKey()) {
            apiService.getGameMatches(format, time, budget, distance)
        } else {
            localEngine.findGameMatches(format, time, budget, distance)
        }
    }

    suspend fun fetchPlayerMatches(
        position: String,
        playersNeeded: Int,
        format: String,
        level: String,
        distance: String
    ): List<PlayerMatch> {
        return if (apiService.hasApiKey()) {
            apiService.getPlayerMatches(position, playersNeeded, format, level, distance)
        } else {
            localEngine.findPlayerMatches(position, playersNeeded, format, level, distance)
        }
    }

    suspend fun fetchTeamMatch(
        playerCount: Int,
        format: String,
        time: String,
        distance: String
    ): TeamMatchResult {
        return if (apiService.hasApiKey()) {
            apiService.getTeamMatch(playerCount, format, time, distance)
        } else {
            localEngine.findTeamMergeMatches(playerCount, format, time, distance)
        }
    }

    suspend fun sendChatMessage(userMessage: String, history: String = "", mySquad: List<TeamMember> = emptyList()): String {
        return if (apiService.hasApiKey()) {
            apiService.getChatResponse(userMessage, history)
        } else {
            localEngine.generateChatResponse(userMessage, mySquad)
        }
    }

    // Features 4-20
    fun getTeamFormation(players: List<String>): TeamFormationResult = localEngine.divideIntoBalancedTeams(players)
    fun arrangeSquadLineup(squad: List<TeamMember>, format: String): SquadLineupResult = localEngine.arrangeSquadLineup(squad, format)
    fun getPerformanceReport(name: String): PlayerPerformanceReport = localEngine.generatePerformanceReport(name)
    fun getTrainingProgram(pos: String, level: String): TrainingProgram = localEngine.generateTrainingProgram(pos, level)
    fun getPositionRecommendation(name: String): PositionRecommendation = localEngine.recommendPosition(name)
    fun parseSmartBooking(prompt: String): SmartBookingQuery = localEngine.parseSmartBookingQuery(prompt)
    fun getMatchReplacement(playerName: String, pos: String): MatchReplacement = localEngine.findMatchReplacement(playerName, pos)
    fun getMatchPrediction(teamA: String, teamB: String): MatchPrediction = localEngine.predictMatchOutcome(teamA, teamB)
    fun getPlayerCompatibility(p1: String, p2: String): PlayerCompatibility = localEngine.analyzePlayerCompatibility(p1, p2)
    fun getScheduleOptimization(): MatchScheduleOptimization = localEngine.optimizeMatchSchedule()
    fun getSmartNotifications(): List<SmartNotification> = localEngine.fetchSmartNotifications()
    fun getCommunityRecommendations(): List<CommunityRecommendation> = localEngine.fetchCommunityRecommendations()
    fun getVideoAnalysis(title: String): VideoAnalysisReport = localEngine.generateVideoAnalysis(title)
    fun getAccountTrust(userName: String): AccountTrustReport = localEngine.evaluateAccountTrust(userName)
    fun getTournamentData(): TournamentData = localEngine.generateTournamentData()
    fun searchPlayersGuided(pos: String, area: String, style: String): String = localEngine.searchPlayersGuided(pos, area, style)
    fun searchTurfsGuided(area: String, budget: String, format: String): String = localEngine.searchTurfsGuided(area, budget, format)
}
