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
import androidx.compose.foundation.layout.width
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
import com.example.pullpadamwherethegamebegins.data.model.GameMatch
import com.example.pullpadamwherethegamebegins.data.model.UiState
import com.example.pullpadamwherethegamebegins.viewmodel.AIMatchViewModel

// =============================================================
// COLORS
// =============================================================

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCardLight = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)

// =============================================================
// GAME MATCHES SCREEN
// =============================================================

@Composable
fun AIGameMatchesScreen(
    format: String,
    time: String,
    budget: String,
    distance: String,
    onJoinGame: (String) -> Unit,
    viewModel: AIMatchViewModel = viewModel()
) {
    val matchesState by viewModel.gameMatchesState.collectAsState()

    LaunchedEffect(format, time, budget, distance) {
        viewModel.loadGameMatches(format, time, budget, distance)
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

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "YOUR GAME MATCHES",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "AI evaluated local pitches and teams matching your profile.",
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
                    text = "YOUR SEARCH CRITERIA",
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
                    if (format.isNotBlank()) SearchTag(text = format)
                    if (time.isNotBlank()) SearchTag(text = time)
                    if (distance.isNotBlank()) SearchTag(text = distance)
                }

                if (budget.isNotBlank()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Budget: $budget",
                        color = PullpadamGray,
                        fontSize = 10.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // MATCHES CONTENT BASED ON API UI STATE
        when (val state = matchesState) {
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
                            text = "PULLPADAM AI evaluating local matches...",
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
                            text = "Unable to fetch AI matches",
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
                            onClick = { viewModel.loadGameMatches(format, time, budget, distance) },
                            colors = ButtonDefaults.buttonColors(containerColor = PullpadamGreen)
                        ) {
                            Text("RETRY", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            is UiState.Success -> {
                val matches = state.data
                if (matches.isEmpty()) {
                    Text(
                        text = "No game matches found for your criteria.",
                        color = PullpadamGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                } else {
                    matches.forEach { match ->
                        GameMatchCard(
                            match = match,
                            onJoin = { onJoinGame(match.teamName) }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "MATCHES ARE RANKED IN REAL-TIME USING YOUR PROFILE, GAME FORMAT, TIME, DISTANCE AND AVAILABILITY.",
            modifier = Modifier.fillMaxWidth(),
            color = PullpadamGray,
            fontSize = 9.sp,
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )

        Spacer(modifier = Modifier.height(25.dp))
    }
}

// =============================================================
// GAME MATCH CARD
// =============================================================

@Composable
private fun GameMatchCard(
    match: GameMatch,
    onJoin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(PullpadamCard)
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = "AI MATCH",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = match.teamName,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF24321B))
                    .padding(horizontal = 11.dp, vertical = 8.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = match.matchPercentage,
                        color = PullpadamGreen,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "MATCH",
                        color = PullpadamGray,
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(PullpadamCardLight)
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "⚽", fontSize = 21.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "PLAYER NEEDED",
                        color = PullpadamGray,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = match.playersNeeded,
                        color = PullpadamGreen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            MatchInfoTag(text = match.format)
            MatchInfoTag(text = match.time)
            MatchInfoTag(text = match.distance)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = match.price,
            color = PullpadamGreen,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "WHY THIS MATCH",
            color = PullpadamGreen,
            fontSize = 9.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.8.sp
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = match.reason,
            color = PullpadamGray,
            fontSize = 10.sp,
            lineHeight = 15.sp
        )

        Spacer(modifier = Modifier.height(17.dp))

        Button(
            onClick = onJoin,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PullpadamGreen,
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "JOIN THIS GAME  →",
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.8.sp
            )
        }
    }
}

@Composable
private fun SearchTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF202521))
            .padding(horizontal = 9.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun MatchInfoTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF202521))
            .padding(horizontal = 9.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = PullpadamGray,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
