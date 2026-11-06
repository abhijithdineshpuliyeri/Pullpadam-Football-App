package com.example.pullpadamwherethegamebegins.data.model

import com.google.gson.annotations.SerializedName

// 1. AI Game Matches (Feature 3)
data class GameMatch(
    @SerializedName("teamName") val teamName: String,
    @SerializedName("matchPercentage") val matchPercentage: String,
    @SerializedName("playersNeeded") val playersNeeded: String,
    @SerializedName("format") val format: String,
    @SerializedName("time") val time: String,
    @SerializedName("distance") val distance: String,
    @SerializedName("price") val price: String,
    @SerializedName("reason") val reason: String
)

// 2. AI Player Matches (Feature 1)
data class PlayerMatch(
    @SerializedName("playerName") val playerName: String,
    @SerializedName("position") val position: String,
    @SerializedName("skillLevel") val skillLevel: String,
    @SerializedName("matchPercentage") val matchPercentage: String,
    @SerializedName("preferredTime") val preferredTime: String,
    @SerializedName("distance") val distance: String,
    @SerializedName("reason") val reason: String
)

// 3. AI Team Matches & Merges (Feature 2)
data class TeamMergeInfo(
    @SerializedName("teamName") val teamName: String,
    @SerializedName("playerCount") val playerCount: Int,
    @SerializedName("description") val description: String
)

data class TeamMatchResult(
    @SerializedName("matchPercentage") val matchPercentage: String,
    @SerializedName("format") val format: String,
    @SerializedName("time") val time: String,
    @SerializedName("distance") val distance: String,
    @SerializedName("teams") val teams: List<TeamMergeInfo>,
    @SerializedName("reason") val reason: String
)

// 4. AI Team Formation Assistant (Feature 4)
data class BalancedTeam(
    val name: String,
    val players: List<String>,
    val averageRating: String
)

data class TeamFormationResult(
    val teamA: BalancedTeam,
    val teamB: BalancedTeam,
    val fairnessScore: String,
    val tacticalBalanceReason: String
)

// My Squad & Roster Organiser Data Models
data class TeamMember(
    val id: String = java.util.UUID.randomUUID().toString(),
    val name: String,
    val position: String,
    val skillLevel: String = "Intermediate",
    val isAvailable: Boolean = true
)

data class SquadLineupResult(
    val startingPlayers: List<TeamMember>,
    val substitutes: List<TeamMember>,
    val formationName: String,
    val tacticalNote: String
)

// 5. AI Player Performance Analysis (Feature 5)
data class PlayerPerformanceReport(
    val playerName: String,
    val appearances: Int,
    val goals: Int,
    val assists: Int,
    val passesCompleted: Int,
    val tacklesWon: Int,
    val saves: Int,
    val winRate: String,
    val topStrengths: List<String>,
    val areasToImprove: List<String>
)

// 6. AI Football Skill Development Coach (Feature 6)
data class DrillItem(
    val title: String,
    val duration: String,
    val description: String,
    val focusArea: String
)

data class TrainingProgram(
    val position: String,
    val level: String,
    val title: String,
    val drills: List<DrillItem>
)

// 7. AI Position Recommendation (Feature 7)
data class PositionRecommendation(
    val recommendedPosition: String,
    val secondaryPosition: String,
    val suitabilityScore: String,
    val physicalAttributeMatch: String,
    val keyStrengths: List<String>,
    val reason: String
)

// 8. AI Turf Recommendation (Feature 8)
data class TurfRecommendation(
    val turfName: String,
    val location: String,
    val price: String,
    val rating: String,
    val format: String,
    val facilities: List<String>,
    val matchPercentage: String,
    val reason: String
)

// 9. AI Smart Booking Assistant (Feature 9)
data class SmartBookingQuery(
    val originalPrompt: String,
    val parsedFormat: String,
    val parsedTime: String,
    val parsedMaxPrice: String,
    val recommendedTurfs: List<TurfRecommendation>
)

// 10. AI Match Cancellation Replacement (Feature 10)
data class MatchReplacement(
    val originalPlayerName: String,
    val candidatePlayerName: String,
    val position: String,
    val matchPercentage: String,
    val distance: String,
    val availabilityStatus: String,
    val reason: String
)

// 11. AI Match Prediction (Feature 11)
data class MatchPrediction(
    val teamAName: String,
    val teamBName: String,
    val teamAWinProbability: String,
    val teamBWinProbability: String,
    val drawProbability: String,
    val predictedKeyBattle: String,
    val rationale: String
)

// 12. AI Player Compatibility Analysis (Feature 12)
data class PlayerCompatibility(
    val player1Name: String,
    val player2Name: String,
    val chemistryScore: String,
    val tacticalSynergy: String,
    val rationale: String
)

// 13. AI Football Chatbot (Feature 13)
data class AIChatMessage(
    val id: String = java.util.UUID.randomUUID().toString(),
    val sender: String,
    val text: String,
    val isUser: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

// 14. AI Match Schedule Optimisation (Feature 14)
data class MatchScheduleOptimization(
    val recommendedTimeSlot: String,
    val turfName: String,
    val playerAvailabilityPercentage: String,
    val estimatedCostPerPlayer: String,
    val rationale: String
)

// 15. AI Smart Notifications (Feature 15)
data class SmartNotification(
    val id: String,
    val title: String,
    val body: String,
    val category: String, // "Match Need", "Player Alert", "Turf Deal"
    val timestamp: String
)

// 16. AI Football Community Recommendations (Feature 16)
data class CommunityRecommendation(
    val name: String,
    val membersCount: Int,
    val location: String,
    val activityLevel: String,
    val description: String
)

// 17 & 18. AI Video-Based Analysis & Goal Highlight Detection (Features 17 & 18)
data class HighlightMoment(
    val timeStamp: String,
    val eventType: String, // "Goal", "Save", "Tackle"
    val description: String
)

data class VideoAnalysisReport(
    val matchTitle: String,
    val totalPossession: String,
    val totalShotsOnTarget: Int,
    val heatmapSummary: String,
    val highlights: List<HighlightMoment>
)

// 19. AI Fraud and Fake Profile Detection (Feature 19)
data class AccountTrustReport(
    val userName: String,
    val trustScore: String,
    val isVerified: Boolean,
    val verificationNotes: String
)

// 20. AI Tournament and League Management (Feature 20)
data class TournamentFixture(
    val round: String,
    val teamA: String,
    val teamB: String,
    val scheduledTime: String,
    val status: String
)

data class TournamentData(
    val name: String,
    val teamsCount: Int,
    val format: String,
    val fixtures: List<TournamentFixture>,
    val standingsPreview: List<Pair<String, Int>> // Team to Points
)

// Generic UI State Wrapper
sealed class UiState<out T> {
    object Idle : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
