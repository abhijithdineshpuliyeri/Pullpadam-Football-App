package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pullpadamwherethegamebegins.data.model.UiState
import com.example.pullpadamwherethegamebegins.viewmodel.AIMatchViewModel

// =============================================================
// COLORS
// =============================================================

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCardLight = Color(0xFF1B201D)
private val PullpadamSelected = Color(0xFF24321B)
private val PullpadamGray = Color(0xFF9A9F9C)

// =============================================================
// TEAM MATCHES SCREEN
// =============================================================

@Composable
fun AITeamMatchesScreen(
    playerCount: Int,
    format: String,
    time: String,
    distance: String,
    onMergeTeams: () -> Unit,
    viewModel: AIMatchViewModel = viewModel()
) {
    val teamMatchState by viewModel.teamMatchState.collectAsState()

    LaunchedEffect(playerCount, format, time, distance) {
        viewModel.loadTeamMatches(playerCount, format, time, distance)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(25.dp))

        // HEADER
        Text(
            text = "PULLPADAM AI",
            color = PullpadamGreen,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = "TEAM MATCHES",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "AI evaluated small groups nearby to complete your full match slot.",
            color = PullpadamGray,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // SEARCH SUMMARY
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(PullpadamCard)
                .padding(15.dp)
        ) {
            Column {
                Text(
                    text = "YOUR SQUAD CRITERIA",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    TeamInfoTag(text = "$playerCount PLAYERS")
                    if (format.isNotBlank()) TeamInfoTag(text = format)
                    if (time.isNotBlank()) TeamInfoTag(text = time)
                    if (distance.isNotBlank()) TeamInfoTag(text = distance)
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // DYNAMIC CONTENT BASED ON API UI STATE
        when (val state = teamMatchState) {
            is UiState.Idle, is UiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = PullpadamGreen)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "PULLPADAM AI matching group squads...",
                            color = PullpadamGray,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            is UiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(PullpadamCard)
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Unable to fetch team matches",
                            color = Color.Red,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = state.message,
                            color = PullpadamGray,
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            onClick = { viewModel.loadTeamMatches(playerCount, format, time, distance) },
                            colors = ButtonDefaults.buttonColors(containerColor = PullpadamGreen)
                        ) {
                            Text("RETRY", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            is UiState.Success -> {
                val result = state.data
                val totalPlayers = result.teams.sumOf { it.playerCount }

                // MATCH QUALITY
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(PullpadamSelected)
                        .padding(18.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "RECOMMENDED MATCH",
                                color = PullpadamGreen,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 0.8.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "COMPLETE ${result.format} GAME",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "$totalPlayers players total  •  1 full match",
                                color = PullpadamGray,
                                fontSize = 11.sp
                            )
                        }

                        Text(
                            text = result.matchPercentage,
                            color = PullpadamGreen,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // TEAMS COMBINED LIST
                result.teams.forEach { team ->
                    TeamCardItem(
                        teamName = team.teamName,
                        count = "${team.playerCount} PLAYERS",
                        description = team.description
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(15.dp))

                // RATIONALE
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(PullpadamCardLight)
                        .padding(15.dp)
                ) {
                    Column {
                        Text(
                            text = "WHY THIS MERGE WORKS",
                            color = PullpadamGreen,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 0.8.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = result.reason,
                            color = PullpadamGray,
                            fontSize = 11.sp,
                            lineHeight = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onMergeTeams,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PullpadamGreen,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "MERGE & BOOK GAME  →",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.8.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))
    }
}

@Composable
private fun TeamCardItem(
    teamName: String,
    count: String,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(PullpadamCard)
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = teamName,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = description,
                    color = PullpadamGray,
                    fontSize = 10.sp
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF202521))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = count,
                    color = PullpadamGreen,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun TeamInfoTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF202521))
            .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
