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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pullpadamwherethegamebegins.data.model.AIChatMessage
import com.example.pullpadamwherethegamebegins.data.model.UiState
import com.example.pullpadamwherethegamebegins.viewmodel.AIMatchViewModel

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCardLight = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun PullpadamAIScreen(
    onFindGame: () -> Unit,
    onFindTeam: () -> Unit,
    onFindPlayer: () -> Unit,
    onOpenAiHub: () -> Unit = {},
    viewModel: AIMatchViewModel = viewModel()
) {
    val messages by viewModel.chatMessages.collectAsState()
    val isChatLoading by viewModel.isChatLoading.collectAsState()
    var inputText by remember { mutableStateOf("") }
    var smartSearchText by remember { mutableStateOf("Find a 5-a-side turf near me for Saturday evening under ₹1500") }
    val smartBookingState by viewModel.smartBookingState.collectAsState()

    // Data for 20 AI Features
    val replacement = viewModel.getMatchReplacement("Rahul K.", "Midfielder")
    val formation = viewModel.getTeamFormation(emptyList())
    val performance = viewModel.getPerformanceReport("Rahul K.")
    val coachProgram = viewModel.getTrainingProgram("Striker", "Intermediate")
    val positionAdvice = viewModel.getPositionRecommendation("Rahul K.")
    val schedule = viewModel.getScheduleOptimization()
    val prediction = viewModel.getMatchPrediction("KANNUR UNITED", "GREEN WARRIORS")
    val compatibility = viewModel.getPlayerCompatibility("Arjun (CM)", "Subhash (ST)")
    val trustReport = viewModel.getAccountTrust("Rahul K.")
    val video = viewModel.getVideoAnalysis("Weekend 7v7 Final")
    val tournament = viewModel.getTournamentData()
    val notifications = viewModel.getSmartNotifications()
    val communities = viewModel.getCommunityRecommendations()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp)
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        // HEADER & SUITE BADGE
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "PULLPADAM AI ENGINE",
                    color = PullpadamGreen,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Complete AI Football Matchmaking Ecosystem",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF24321B))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "20 AI SUITE",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // HUB EXPLORER BANNER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF24321B))
                .clickable { onOpenAiHub() }
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "FULL 20 AI FEATURES INTERACTIVE HUB",
                        color = PullpadamGreen,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Open complete AI suite control center",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "OPEN HUB",
                    color = PullpadamGreen,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 1: MATCHMAKING TRIPLE (Features 1, 2, 3)
        SectionHeader(title = "CORE MATCHMAKING ENGINE", subtitle = "Features 1, 2 & 3")

        AIFeatureCard(
            title = "FIND A GAME (Feature 3)",
            description = "Discover existing football games and teams looking for players.",
            buttonText = "FIND MY GAME",
            onClick = onFindGame
        )

        Spacer(modifier = Modifier.height(12.dp))

        AIFeatureCard(
            title = "FIND A TEAM (Feature 2)",
            description = "Merge incomplete squads into a complete match team.",
            buttonText = "FIND A TEAM",
            onClick = onFindTeam
        )

        Spacer(modifier = Modifier.height(12.dp))

        AIFeatureCard(
            title = "FIND A PLAYER (Feature 1)",
            description = "Recruit players matching your position & skill criteria.",
            buttonText = "FIND PLAYER",
            onClick = onFindPlayer
        )

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 2: CANCELLATION REPLACEMENT RADAR (Feature 10)
        SectionHeader(title = "CANCELLATION REPLACEMENT RADAR", subtitle = "Feature 10")
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
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Cancelled: ${replacement.originalPlayerName} (${replacement.position})",
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
                            fontSize = 12.sp,
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

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 3: SQUAD FORMATION & PERFORMANCE (Features 4, 5, 6, 7)
        SectionHeader(title = "MY TEAM SQUAD ORGANISER & COACH", subtitle = "Features 4, 5, 6 & 7")

        // Interactive My Squad Organiser Widget
        MySquadOrganiserWidget(viewModel = viewModel)

        Spacer(modifier = Modifier.height(12.dp))

        // Feature 4: Team Formation Assistant
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
                    Text("TEAM FORMATION BALANCER (Feature 4)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Text(formation.fairnessScore, color = PullpadamGreen, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text("Divided 14 players into 2 balanced teams of seven:", color = PullpadamGray, fontSize = 11.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TeamColumnWidget(title = formation.teamA.name, rating = formation.teamA.averageRating, players = formation.teamA.players, modifier = Modifier.weight(1f))
                    TeamColumnWidget(title = formation.teamB.name, rating = formation.teamB.averageRating, players = formation.teamB.players, modifier = Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Feature 5, 6, 7: Performance, Drills & Position
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("PERFORMANCE & POSITION ADVISOR (Features 5 & 7)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))
                Text("Player: ${performance.playerName} • Win Rate: ${performance.winRate}", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("Goals: ${performance.goals} • Assists: ${performance.assists} • Passes: ${performance.passesCompleted}", color = PullpadamGray, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Recommended Position: ${positionAdvice.recommendedPosition} (${positionAdvice.suitabilityScore})", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text(positionAdvice.reason, color = PullpadamGray, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("SKILL DEVELOPMENT COACH (Feature 6)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(coachProgram.title, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                coachProgram.drills.forEach { drill ->
                    Text("• ${drill.title} (${drill.duration})", color = PullpadamGray, fontSize = 10.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 4: SMART NATURAL LANGUAGE TURF BOOKING (Features 8, 9, 14)
        SectionHeader(title = "NATURAL LANGUAGE SMART BOOKING", subtitle = "Features 8, 9 & 14")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("SMART NATURAL LANGUAGE BOOKING ASSISTANT (Feature 9)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = smartSearchText,
                    onValueChange = { smartSearchText = it },
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
                    keyboardActions = KeyboardActions(onSearch = { viewModel.sendSmartBookingSearch(smartSearchText) })
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { viewModel.sendSmartBookingSearch(smartSearchText) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = PullpadamGreen)
                ) {
                    Text("PARSE & FIND TURFS WITH AI", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }

                when (val state = smartBookingState) {
                    is UiState.Success -> {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("Parsed Filters: ${state.data.parsedFormat} • ${state.data.parsedTime} • Max ${state.data.parsedMaxPrice}", color = PullpadamGreen, fontSize = 10.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        state.data.recommendedTurfs.forEach { turf ->
                            Text("• ${turf.turfName} (${turf.location}) - ${turf.price}", color = Color.White, fontSize = 11.sp)
                        }
                    }
                    else -> {}
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text("SCHEDULE OPTIMISER (Feature 14): ${schedule.recommendedTimeSlot} (${schedule.playerAvailabilityPercentage})", color = PullpadamGray, fontSize = 10.sp)
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 5: PREDICTOR, SYNERGY & TRUST SAFETY (Features 11, 12, 19)
        SectionHeader(title = "MATCH PREDICTOR & ACCOUNT SAFETY", subtitle = "Features 11, 12 & 19")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("MATCH OUTCOME PREDICTOR (Feature 11)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("${prediction.teamAName} (${prediction.teamAWinProbability}) vs ${prediction.teamBName} (${prediction.teamBWinProbability})", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(prediction.rationale, color = PullpadamGray, fontSize = 10.sp)

                Spacer(modifier = Modifier.height(10.dp))
                Text("PLAYER CHEMISTRY & SYNERGY (Feature 12)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text("${compatibility.player1Name} + ${compatibility.player2Name}: ${compatibility.chemistryScore}", color = Color.White, fontSize = 11.sp)

                Spacer(modifier = Modifier.height(10.dp))
                Text("ACCOUNT TRUST VERIFICATION (Feature 19)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text("Account: ${trustReport.userName} • ${trustReport.trustScore} (Verified)", color = Color.White, fontSize = 11.sp)
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // SECTION 6: MEDIA, TOURNAMENTS & NOTIFICATIONS (Features 15, 16, 17, 18, 20)
        SectionHeader(title = "MEDIA, TOURNAMENTS & COMMUNITY", subtitle = "Features 15, 16, 17, 18 & 20")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {
            Column {
                Text("VIDEO HIGHLIGHTS & HEATMAP (Features 17 & 18)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text("Match: ${video.matchTitle} • ${video.totalPossession}", color = Color.White, fontSize = 11.sp)
                video.highlights.forEach { h ->
                    Text("• [${h.timeStamp}] ${h.eventType}: ${h.description}", color = PullpadamGray, fontSize = 10.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text("TOURNAMENT & LEAGUE MANAGER (Feature 20)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text("${tournament.name} (${tournament.teamsCount} Teams)", color = Color.White, fontSize = 11.sp)

                Spacer(modifier = Modifier.height(10.dp))
                Text("FOOTBALL COMMUNITY RADAR (Feature 16)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                communities.take(2).forEach { c ->
                    Text("• ${c.name} (${c.location}) - ${c.membersCount} Members", color = Color.White, fontSize = 10.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text("SMART NOTIFICATIONS (Feature 15)", color = PullpadamGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                notifications.take(2).forEach { n ->
                    Text("• ${n.title}: ${n.body}", color = PullpadamGray, fontSize = 10.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // SECTION 7: LIVE FOOTBALL CHATBOT ASSISTANT (Feature 13)
        SectionHeader(title = "LIVE AI ASSISTANT CHATBOT", subtitle = "Feature 13")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(22.dp))
                .background(PullpadamCard)
                .padding(18.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "AI FOOTBALL ASSISTANT",
                            color = PullpadamGreen,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Ask Pullpadam AI Anything",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF24321B))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(text = "LIVE ENGINE", color = PullpadamGreen, fontSize = 8.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(PullpadamCardLight)
                        .padding(12.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    messages.forEach { msg ->
                        ChatMessageBubble(message = msg)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    if (isChatLoading) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            CircularProgressIndicator(modifier = Modifier.height(16.dp).width(16.dp), color = PullpadamGreen, strokeWidth = 2.dp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Pullpadam AI is typing...", color = PullpadamGray, fontSize = 11.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        placeholder = { Text("Ask about turfs, drills, or tactics...", color = PullpadamGray, fontSize = 11.sp) },
                        modifier = Modifier.weight(1f).height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PullpadamGreen,
                            unfocusedBorderColor = Color(0xFF303833),
                            focusedContainerColor = PullpadamCardLight,
                            unfocusedContainerColor = PullpadamCardLight,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                        keyboardActions = KeyboardActions(onSend = {
                            if (inputText.isNotBlank()) {
                                viewModel.sendChatMessage(inputText)
                                inputText = ""
                            }
                        })
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(PullpadamGreen)
                            .clickable {
                                if (inputText.isNotBlank()) {
                                    viewModel.sendChatMessage(inputText)
                                    inputText = ""
                                }
                            }
                            .padding(horizontal = 14.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("SEND", color = Color.Black, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "PULLPADAM AI FOOTBALL ENGINE • ALL 20 AI SUITE ACTIVE",
            modifier = Modifier.fillMaxWidth(),
            color = PullpadamGray,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 1.5.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun SectionHeader(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Text(text = subtitle.uppercase(), color = PullpadamGreen, fontSize = 9.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 1.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
private fun TeamColumnWidget(title: String, rating: String, players: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(PullpadamCardLight)
            .padding(10.dp)
    ) {
        Text(title, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Text("Rating: $rating", color = PullpadamGray, fontSize = 9.sp)
        Spacer(modifier = Modifier.height(4.dp))
        players.forEach { p ->
            Text("• $p", color = Color.White, fontSize = 10.sp)
        }
    }
}

@Composable
private fun ChatMessageBubble(message: AIChatMessage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.isUser) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = if (message.isUser) 12.dp else 2.dp,
                        bottomEnd = if (message.isUser) 2.dp else 12.dp
                    )
                )
                .background(if (message.isUser) PullpadamGreen else Color(0xFF28302A))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = message.text,
                color = if (message.isUser) Color.Black else Color.White,
                fontSize = 11.sp,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
private fun AIFeatureCard(
    title: String,
    description: String,
    buttonText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(PullpadamCard)
            .clickable { onClick() }
            .padding(18.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.4.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = description,
            color = PullpadamGray,
            fontSize = 11.sp,
            lineHeight = 17.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(PullpadamGreen),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonText,
                color = Color.Black,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.8.sp
            )
        }
    }
}
