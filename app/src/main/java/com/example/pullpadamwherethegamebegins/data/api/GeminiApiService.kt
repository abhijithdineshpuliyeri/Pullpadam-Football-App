package com.example.pullpadamwherethegamebegins.data.api

import com.example.pullpadamwherethegamebegins.data.model.GameMatch
import com.example.pullpadamwherethegamebegins.data.model.PlayerMatch
import com.example.pullpadamwherethegamebegins.data.model.TeamMatchResult
import com.example.pullpadamwherethegamebegins.data.model.TeamMergeInfo
import com.google.ai.client.generativeai.GenerativeModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Service that connects PULLPADAM to Google Gemini API for intelligent AI matchmaking
 * and AI chat assistant features.
 */
class GeminiApiService(
    private var apiKey: String = ""
) {

    private val gson = Gson()

    fun updateApiKey(newKey: String) {
        this.apiKey = newKey
    }

    fun hasApiKey(): Boolean {
        return apiKey.isNotBlank()
    }

    private fun getModel(): GenerativeModel {
        val modelName = "gemini-1.5-flash"
        return GenerativeModel(
            modelName = modelName,
            apiKey = apiKey
        )
    }

    /**
     * AI Game Matches API: Calls Gemini API to analyze format, time, budget, and distance,
     * returning top local game matches with dynamic AI compatibility scoring and explanations.
     */
    suspend fun getGameMatches(
        format: String,
        time: String,
        budget: String,
        distance: String
    ): List<GameMatch> = withContext(Dispatchers.IO) {
        if (!hasApiKey()) {
            return@withContext generateFallbackGameMatches(format, time, budget, distance)
        }

        try {
            val prompt = """
                You are PULLPADAM AI, a local football matchmaker assistant in Kerala, India.
                A player is looking for a football game with these preferences:
                - Format: $format
                - Preferred Time: $time
                - Budget: $budget
                - Max Distance: $distance
                
                Generate 3 realistic local football matches in JSON format. Return ONLY a valid JSON array of objects with these keys:
                - "teamName": String (e.g. "KANNUR UNITED", "MALABAR FC", "CALICUT STRIKERS")
                - "matchPercentage": String (e.g. "96%", "91%", "88%")
                - "playersNeeded": String (e.g. "1 MIDFIELDER", "2 PLAYERS")
                - "format": String (e.g. "$format")
                - "time": String (e.g. "$time")
                - "distance": String (e.g. "3.2 KM")
                - "price": String (e.g. "₹1,200 / game")
                - "reason": String (A concise 1-2 sentence AI rationale explaining why this match fits their format, budget, or distance)
                
                Return ONLY the JSON array without markdown formatting or backticks.
            """.trimIndent()

            val response = getModel().generateContent(prompt)
            val jsonText = cleanJsonResponse(response.text ?: "")

            val type = object : TypeToken<List<GameMatch>>() {}.type
            val matches: List<GameMatch>? = gson.fromJson(jsonText, type)

            if (!matches.isNullOrEmpty()) {
                matches
            } else {
                generateFallbackGameMatches(format, time, budget, distance)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            generateFallbackGameMatches(format, time, budget, distance)
        }
    }

    /**
     * AI Player Matches API: Calls Gemini API to find matching players for a team.
     */
    suspend fun getPlayerMatches(
        position: String,
        playersNeeded: Int,
        format: String,
        level: String,
        distance: String
    ): List<PlayerMatch> = withContext(Dispatchers.IO) {
        if (!hasApiKey()) {
            return@withContext generateFallbackPlayerMatches(position, playersNeeded, format, level, distance)
        }

        try {
            val prompt = """
                You are PULLPADAM AI. A team needs $playersNeeded $position(s) for a $format game.
                Preferences:
                - Skill Level: $level
                - Distance Radius: $distance
                
                Generate 3 realistic player profiles matching these requirements.
                Return ONLY a valid JSON array of objects with keys:
                - "playerName": String (e.g. "RAHUL K.", "SUBHASH M.", "ANAS V.")
                - "position": String (e.g. "$position")
                - "skillLevel": String (e.g. "$level")
                - "matchPercentage": String (e.g. "98%", "93%", "89%")
                - "preferredTime": String (e.g. "Evening / Night")
                - "distance": String (e.g. "2.5 KM")
                - "reason": String (Brief rationale of why this player fits the team position and skill level)
                
                Return ONLY raw JSON array without markdown formatting.
            """.trimIndent()

            val response = getModel().generateContent(prompt)
            val jsonText = cleanJsonResponse(response.text ?: "")

            val type = object : TypeToken<List<PlayerMatch>>() {}.type
            val matches: List<PlayerMatch>? = gson.fromJson(jsonText, type)

            if (!matches.isNullOrEmpty()) {
                matches
            } else {
                generateFallbackPlayerMatches(position, playersNeeded, format, level, distance)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            generateFallbackPlayerMatches(position, playersNeeded, format, level, distance)
        }
    }

    /**
     * AI Team Merge API: Calls Gemini API to merge partial teams into a full match.
     */
    suspend fun getTeamMatch(
        playerCount: Int,
        format: String,
        time: String,
        distance: String
    ): TeamMatchResult = withContext(Dispatchers.IO) {
        if (!hasApiKey()) {
            return@withContext generateFallbackTeamMatch(playerCount, format, time, distance)
        }

        try {
            val prompt = """
                You are PULLPADAM AI. A group of $playerCount players wants to play a $format game ($time, within $distance).
                Find other partial groups nearby to form a complete team and pitch match.
                
                Return ONLY a valid JSON object with keys:
                - "matchPercentage": String (e.g. "95%")
                - "format": String ("$format")
                - "time": String ("$time")
                - "distance": String ("$distance")
                - "teams": Array of objects [{"teamName": String, "playerCount": Int, "description": String}]
                - "reason": String (1-2 sentences on how combining these groups forms a full $format slot)
                
                Return ONLY raw JSON without markdown codeblocks.
            """.trimIndent()

            val response = getModel().generateContent(prompt)
            val jsonText = cleanJsonResponse(response.text ?: "")

            val result: TeamMatchResult? = gson.fromJson(jsonText, TeamMatchResult::class.java)
            result ?: generateFallbackTeamMatch(playerCount, format, time, distance)
        } catch (e: Exception) {
            e.printStackTrace()
            generateFallbackTeamMatch(playerCount, format, time, distance)
        }
    }

    /**
     * PULLPADAM AI Assistant Chat API: Multi-turn or single-prompt AI response generator.
     */
    suspend fun getChatResponse(
        userPrompt: String,
        history: String = ""
    ): String = withContext(Dispatchers.IO) {
        if (!hasApiKey()) {
            return@withContext generateFallbackChatResponse(userPrompt)
        }

        try {
            val systemInstruction = """
                You are PULLPADAM AI - the ultimate local football matchmaker and turf expert in Kerala.
                You help football enthusiasts find games, form teams, hire players, book turfs, and improve their game tactics.
                Be energetic, concise, supportive, and knowledgeable about local football culture in Kerala (7v7, 5v5 turf games).
            """.trimIndent()

            val fullPrompt = "$systemInstruction\n\nContext:\n$history\nUser: $userPrompt\nPullpadam AI:"
            val response = getModel().generateContent(fullPrompt)
            response.text ?: "I am PULLPADAM AI, ready to help you find your next match or turf!"
        } catch (e: Exception) {
            e.printStackTrace()
            generateFallbackChatResponse(userPrompt)
        }
    }

    private fun cleanJsonResponse(raw: String): String {
        return raw.trim()
            .removePrefix("```json")
            .removePrefix("```")
            .removeSuffix("```")
            .trim()
    }

    // =========================================================================
    // INTELLIGENT FALLBACK ENGINE (Used offline or when API key is not set)
    // =========================================================================

    private fun generateFallbackGameMatches(
        format: String,
        time: String,
        budget: String,
        distance: String
    ): List<GameMatch> {
        return listOf(
            GameMatch(
                teamName = "KANNUR UNITED",
                matchPercentage = "96%",
                playersNeeded = "1 MIDFIELDER",
                format = format.ifBlank { "7v7" },
                time = time.ifBlank { "Evening" },
                distance = "3.4 KM",
                price = "₹1,200 / game",
                reason = "They are looking for a midfielder matching your preferred $format format and $time slot."
            ),
            GameMatch(
                teamName = "GREEN WARRIORS",
                matchPercentage = "91%",
                playersNeeded = "1 PLAYER",
                format = format.ifBlank { "7v7" },
                time = time.ifBlank { "Evening" },
                distance = "4.8 KM",
                price = "₹1,100 / game",
                reason = "A nearby team has an open spot matching your $budget budget preferences."
            ),
            GameMatch(
                teamName = "MALABAR FC",
                matchPercentage = "87%",
                playersNeeded = "2 PLAYERS",
                format = format.ifBlank { "7v7" },
                time = time.ifBlank { "Evening" },
                distance = "5.0 KM",
                price = "₹1,000 / game",
                reason = "Good format and time match with a slightly longer distance."
            )
        )
    }

    private fun generateFallbackPlayerMatches(
        position: String,
        playersNeeded: Int,
        format: String,
        level: String,
        distance: String
    ): List<PlayerMatch> {
        return listOf(
            PlayerMatch(
                playerName = "RAHUL K.",
                position = position.ifBlank { "Defender" },
                skillLevel = level.ifBlank { "Intermediate" },
                matchPercentage = "95%",
                preferredTime = "Evening (6-9 PM)",
                distance = "2.3 KM",
                reason = "Experienced $position with high stamina, active in $format matches nearby."
            ),
            PlayerMatch(
                playerName = "SUBHASH M.",
                position = position.ifBlank { "Defender" },
                skillLevel = level.ifBlank { "Advanced" },
                matchPercentage = "91%",
                preferredTime = "Night (9-11 PM)",
                distance = "3.8 KM",
                reason = "Reliable $position available for evening turfs within $distance radius."
            ),
            PlayerMatch(
                playerName = "ANAS V.",
                position = position.ifBlank { "Defender" },
                skillLevel = level.ifBlank { "Casual" },
                matchPercentage = "86%",
                preferredTime = "Anytime",
                distance = "4.2 KM",
                reason = "Looking to join regular $format local games."
            )
        )
    }

    private fun generateFallbackTeamMatch(
        playerCount: Int,
        format: String,
        time: String,
        distance: String
    ): TeamMatchResult {
        return TeamMatchResult(
            matchPercentage = "94%",
            format = format.ifBlank { "7v7" },
            time = time.ifBlank { "Evening" },
            distance = distance.ifBlank { "5 KM" },
            teams = listOf(
                TeamMergeInfo("YOUR GROUP", playerCount, "Your starting squad"),
                TeamMergeInfo("NORTH COASTERS", 2, "2 players searching for a game"),
                TeamMergeInfo("STRIKER BOYS", 3, "3 players ready to join")
            ),
            reason = "Merging your $playerCount players with North Coasters and Striker Boys completes a full $format game!"
        )
    }

    private fun generateFallbackChatResponse(prompt: String): String {
        val lower = prompt.lowercase()
        return when {
            "game" in lower || "find" in lower -> "PULLPADAM AI matched 3 active local games matching your preferred time and pitch format! Check out the 'Find Game' tab to view Kannur United and Green Warriors."
            "turf" in lower || "book" in lower -> "Looking for the best turf? I recommend Metro Turf or Arena 7 in Kannur. High quality synthetic grass with night floodlights!"
            "player" in lower -> "We have over 50 verified players nearby looking for open games. You can use 'Find Player' to recruit defenders, strikers, or goalkeepers."
            else -> "Welcome to PULLPADAM AI! How can I assist with your football matchmaking, turf bookings, or squad recruitment today?"
        }
    }
}
