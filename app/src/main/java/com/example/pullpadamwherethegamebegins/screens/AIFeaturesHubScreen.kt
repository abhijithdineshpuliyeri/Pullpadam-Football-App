package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pullpadamwherethegamebegins.data.model.UiState
import com.example.pullpadamwherethegamebegins.viewmodel.AIMatchViewModel

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCardLight = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun AIFeaturesHubScreen(
    onNavigateBack: () -> Unit,
    viewModel: AIMatchViewModel = viewModel()
) {
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    val categories = listOf("Matchmaker", "Coach & Squad", "Smart Turf", "Predictor", "Tournaments & Media")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .padding(horizontal = 18.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "PULLPADAM AI ENGINE",
                    color = PullpadamGreen,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "20 AI FEATURES HUB",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(PullpadamCard)
                    .clickable { onNavigateBack() }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(text = "BACK", color = PullpadamGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // CATEGORY TAB STRIP
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEachIndexed { index, title ->
                val isSelected = selectedCategoryIndex == index
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) PullpadamGreen else PullpadamCard)
                        .clickable { selectedCategoryIndex = index }
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = title,
                        color = if (isSelected) Color.Black else PullpadamGray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // CATEGORY CONTENT SWITCHER
        when (selectedCategoryIndex) {
            0 -> MatchmakerTabContent(viewModel)
            1 -> CoachAndSquadTabContent(viewModel)
            2 -> SmartTurfTabContent(viewModel)
            3 -> PredictorTabContent(viewModel)
            4 -> TournamentsAndMediaTabContent(viewModel)
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

// =============================================================================
// TAB 1: MATCHMAKER (Features 1, 2, 3, 10)
// =============================================================================

@Composable
private fun MatchmakerTabContent(viewModel: AIMatchViewModel) {
    var replacementPlayer by remember { mutableStateOf("Rahul K.") }
    val replacement = viewModel.getMatchReplacement(replacementPlayer, "Midfielder")

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FeatureCardHeader("MATCHMAKING & REPLACEMENT SYSTEM", "Features 1, 2, 3 & 10")

        // Feature 10: Cancellation Replacement Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "MATCH CANCELLATION REPLACEMENT",
                    color = PullpadamGreen,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Original Player: ${replacement.originalPlayerName} (Cancelled)",
                    color = PullpadamGray,
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(PullpadamCardLight)
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Recommended Replacement: ${replacement.candidatePlayerName}",
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${replacement.position} • ${replacement.distance} • ${replacement.availabilityStatus}",
                            color = PullpadamGreen,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        text = replacement.matchPercentage,
                        color = PullpadamGreen,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    }
}

// =============================================================================
// TAB 2: COACH & SQUAD (Features 4, 5, 6, 7)
// =============================================================================

@Composable
private fun CoachAndSquadTabContent(viewModel: AIMatchViewModel) {
    val formation = viewModel.getTeamFormation(emptyList())
    val performance = viewModel.getPerformanceReport("Rahul K.")
    val coachProgram = viewModel.getTrainingProgram("Striker", "Intermediate")
    val positionAdvice = viewModel.getPositionRecommendation("Rahul K.")

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FeatureCardHeader("MY SQUAD ORGANISER & PERFORMANCE COACH", "Features 4, 5, 6 & 7")

        // Interactive Squad Organiser Widget
        MySquadOrganiserWidget(viewModel = viewModel)

        // Feature 4: 14-Player Team Auto-Balancer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("TEAM FORMATION ASSISTANT", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Text(formation.fairnessScore, color = PullpadamGreen, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(PullpadamCardLight)
                            .padding(10.dp)
                    ) {
                        Text(formation.teamA.name, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Text("Rating: ${formation.teamA.averageRating}", color = PullpadamGray, fontSize = 9.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        formation.teamA.players.forEach { p ->
                            Text("• $p", color = Color.White, fontSize = 10.sp)
                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(PullpadamCardLight)
                            .padding(10.dp)
                    ) {
                        Text(formation.teamB.name, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Text("Rating: ${formation.teamB.averageRating}", color = PullpadamGray, fontSize = 9.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        formation.teamB.players.forEach { p ->
                            Text("• $p", color = Color.White, fontSize = 10.sp)
                        }
                    }
                }
            }
        }

        // Feature 5: Performance Analytics
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("PLAYER PERFORMANCE REPORT", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Player: ${performance.playerName}  •  Win Rate: ${performance.winRate}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Goals: ${performance.goals}", color = PullpadamGray, fontSize = 11.sp)
                    Text("Assists: ${performance.assists}", color = PullpadamGray, fontSize = 11.sp)
                    Text("Passes: ${performance.passesCompleted}", color = PullpadamGray, fontSize = 11.sp)
                }
            }
        }

        // Feature 6: Skill Coach Drills
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("SKILL DEVELOPMENT COACH & POSITION ADVISOR", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("Recommended Position: ${positionAdvice.recommendedPosition} (${positionAdvice.suitabilityScore})", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text(positionAdvice.reason, color = PullpadamGray, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(coachProgram.title, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                coachProgram.drills.forEach { drill ->
                    Text("• ${drill.title} (${drill.duration}) - ${drill.focusArea}", color = PullpadamGray, fontSize = 10.sp)
                }
            }
        }
    }
}

// =============================================================================
// TAB 3: SMART TURF (Features 8, 9, 14)
// =============================================================================

@Composable
private fun SmartTurfTabContent(viewModel: AIMatchViewModel) {
    var naturalPrompt by remember { mutableStateOf("Find a 5-a-side turf near me for Saturday evening under ₹1500") }
    val smartBookingState by viewModel.smartBookingState.collectAsState()
    val schedule = viewModel.getScheduleOptimization()

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FeatureCardHeader("NATURAL LANGUAGE TURF SEARCH & SCHEDULES", "Features 8, 9 & 14")

        // Feature 9: Natural Language Booking Search
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("SMART BOOKING ASSISTANT", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = naturalPrompt,
                    onValueChange = { naturalPrompt = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PullpadamGreen,
                        unfocusedBorderColor = Color(0xFF303833),
                        focusedContainerColor = PullpadamCardLight,
                        unfocusedContainerColor = PullpadamCardLight,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { viewModel.sendSmartBookingSearch(naturalPrompt) })
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { viewModel.sendSmartBookingSearch(naturalPrompt) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = PullpadamGreen)
                ) {
                    Text("SEARCH TURFS WITH AI", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))

                when (val state = smartBookingState) {
                    is UiState.Success -> {
                        Text("Parsed Filters: ${state.data.parsedFormat} • ${state.data.parsedTime} • Max ${state.data.parsedMaxPrice}", color = PullpadamGreen, fontSize = 10.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        state.data.recommendedTurfs.forEach { turf ->
                            Text("• ${turf.turfName} (${turf.location}) - ${turf.price} [Match: ${turf.matchPercentage}]", color = Color.White, fontSize = 11.sp)
                        }
                    }
                    else -> {}
                }
            }
        }

        // Feature 14: Schedule Optimiser
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("MATCH SCHEDULE OPTIMISER", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("Optimal Slot: ${schedule.recommendedTimeSlot}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("${schedule.playerAvailabilityPercentage} • ${schedule.estimatedCostPerPlayer}", color = PullpadamGray, fontSize = 11.sp)
            }
        }
    }
}

// =============================================================================
// TAB 4: PREDICTOR (Features 11, 12, 19)
// =============================================================================

@Composable
private fun PredictorTabContent(viewModel: AIMatchViewModel) {
    val prediction = viewModel.getMatchPrediction("KANNUR UNITED", "GREEN WARRIORS")
    val compatibility = viewModel.getPlayerCompatibility("Arjun (Midfielder)", "Subhash (Striker)")
    val trustReport = viewModel.getAccountTrust("Rahul K.")

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FeatureCardHeader("PREDICTOR, SYNERGY & ACCOUNT SAFETY", "Features 11, 12 & 19")

        // Feature 11: Match Prediction
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("AI MATCH PREDICTION", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("${prediction.teamAName} vs ${prediction.teamBName}", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Win Probabilities: ${prediction.teamAName} (${prediction.teamAWinProbability}) | ${prediction.teamBName} (${prediction.teamBWinProbability})", color = PullpadamGreen, fontSize = 10.sp)
                Text(prediction.rationale, color = PullpadamGray, fontSize = 10.sp)
            }
        }

        // Feature 12: Player Chemistry
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("PLAYER COMPATIBILITY & SYNERGY", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("${compatibility.player1Name} + ${compatibility.player2Name}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("${compatibility.chemistryScore} • ${compatibility.tacticalSynergy}", color = PullpadamGreen, fontSize = 10.sp)
            }
        }

        // Feature 19: Fraud Detection Trust Score
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("ACCOUNT TRUST VERIFICATION", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("User: ${trustReport.userName}  •  ${trustReport.trustScore}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(trustReport.verificationNotes, color = PullpadamGray, fontSize = 10.sp)
            }
        }
    }
}

// =============================================================================
// TAB 5: TOURNAMENTS & MEDIA (Features 15, 16, 17, 18, 20)
// =============================================================================

@Composable
private fun TournamentsAndMediaTabContent(viewModel: AIMatchViewModel) {
    val video = viewModel.getVideoAnalysis("Weekend 7v7 Final")
    val tournament = viewModel.getTournamentData()
    val notifications = viewModel.getSmartNotifications()

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        FeatureCardHeader("COMMUNITY, MEDIA & TOURNAMENTS", "Features 15, 16, 17, 18 & 20")

        // Feature 17 & 18: Video Analysis & Highlights
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("VIDEO MATCH ANALYSIS & HIGHLIGHTS", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text(video.matchTitle, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("Possession: ${video.totalPossession}", color = PullpadamGray, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(6.dp))
                video.highlights.forEach { h ->
                    Text("• [${h.timeStamp}] ${h.eventType}: ${h.description}", color = PullpadamGreen, fontSize = 10.sp)
                }
            }
        }

        // Feature 20: Tournament Fixtures
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("TOURNAMENT & LEAGUE MANAGER", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("${tournament.name} (${tournament.format})", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                tournament.fixtures.forEach { f ->
                    Text("• ${f.round}: ${f.teamA} vs ${f.teamB} (${f.scheduledTime})", color = PullpadamGray, fontSize = 10.sp)
                }
            }
        }

        // Feature 15: Smart Notifications
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("SMART NOTIFICATIONS", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                notifications.forEach { n ->
                    Text("• [${n.category}] ${n.title} - ${n.body}", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun MySquadOrganiserWidget(viewModel: AIMatchViewModel) {
    val squad by viewModel.mySquad.collectAsState()
    var newName by remember { mutableStateOf("") }
    var newPosition by remember { mutableStateOf("Midfielder") }
    val lineup = viewModel.getArrangedLineup("7v7")
    val availableCount = squad.count { it.isAvailable }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(PullpadamCard)
            .padding(16.dp)
    ) {
        Column {
            Text("MY TEAM SQUAD ORGANISER", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Add team players & toggle player availability status:", color = PullpadamGray, fontSize = 11.sp)

            Spacer(modifier = Modifier.height(10.dp))

            // Add player input
            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = newName,
                    onValueChange = { newName = it },
                    placeholder = { Text("Player name...", color = PullpadamGray, fontSize = 11.sp) },
                    modifier = Modifier.weight(1f).height(48.dp),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PullpadamGreen,
                        unfocusedBorderColor = Color(0xFF303833),
                        focusedContainerColor = PullpadamCardLight,
                        unfocusedContainerColor = PullpadamCardLight,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.width(6.dp))

                Box(
                    modifier = Modifier
                        .height(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(PullpadamGreen)
                        .clickable {
                            if (newName.isNotBlank()) {
                                viewModel.addSquadMember(newName, newPosition)
                                newName = ""
                            }
                        }
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("ADD", color = Color.Black, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Position selection tags
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("Midfielder", "Striker", "Defender", "Goalkeeper", "Winger").forEach { pos ->
                    val isSel = newPosition == pos
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSel) PullpadamGreen else Color(0xFF202521))
                            .clickable { newPosition = pos }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(pos, color = if (isSel) Color.Black else PullpadamGray, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text("CURRENT SQUAD ($availableCount / ${squad.size} AVAILABLE NOW)", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            // Squad roster
            squad.forEach { member ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(PullpadamCardLight)
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(member.name, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text(member.position, color = PullpadamGreen, fontSize = 9.sp)
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (member.isAvailable) Color(0xFF24321B) else Color(0xFF332020))
                            .clickable { viewModel.togglePlayerAvailability(member.id) }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = if (member.isAvailable) "AVAILABLE" else "UNAVAILABLE",
                            color = if (member.isAvailable) PullpadamGreen else Color.Red,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Arranged Lineup
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(PullpadamCardLight)
                    .padding(12.dp)
            ) {
                Column {
                    Text("AI LINEUP ARRANGEMENT (${lineup.formationName})", color = PullpadamGreen, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(lineup.tacticalNote, color = Color.White, fontSize = 10.sp, lineHeight = 15.sp)

                    if (lineup.startingPlayers.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Starting Pitch Lineup:", color = PullpadamGray, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                        lineup.startingPlayers.forEach { s ->
                            Text("• ${s.name} (${s.position})", color = PullpadamGreen, fontSize = 10.sp)
                        }
                    }

                    if (lineup.substitutes.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Substitutes Bench:", color = PullpadamGray, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                        lineup.substitutes.forEach { sub ->
                            Text("• ${sub.name} (${sub.position})", color = Color.White, fontSize = 9.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FeatureCardHeader(title: String, subtitle: String) {
    Column {
        Text(text = subtitle.uppercase(), color = PullpadamGreen, fontSize = 9.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.sp)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
