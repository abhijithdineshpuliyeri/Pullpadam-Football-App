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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// =============================================================
// COLORS
// =============================================================

private val PullpadamBackground =
    Color(0xFF0B0D0C)

private val PullpadamGreen =
    Color(0xFFB6FF3B)

private val PullpadamCard =
    Color(0xFF151917)

private val PullpadamCardLight =
    Color(0xFF1B201D)

private val PullpadamSelected =
    Color(0xFF24321B)

private val PullpadamGray =
    Color(0xFF9A9F9C)


// =============================================================
// TEAM MATCHES SCREEN
// =============================================================

@Composable
fun AITeamMatchesScreen(
    playerCount: Int,
    format: String,
    time: String,
    distance: String,
    onMergeTeams: () -> Unit
) {

    // =========================================================
    // SAMPLE TEAM DATA
    //
    // Later this will come from the backend/database.
    // =========================================================

    val teamBPlayers = 2
    val teamCPlayers = 3
    val teamDPlayers = 2

    val totalPlayers =
        playerCount +
                teamBPlayers +
                teamCPlayers +
                teamDPlayers


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                PullpadamBackground
            )
            .verticalScroll(
                rememberScrollState()
            )
            .padding(
                horizontal = 20.dp
            )
    ) {

        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // HEADER
        // =====================================================

        Text(
            text =
                "PULLPADAM AI",

            color =
                PullpadamGreen,

            fontSize =
                14.sp,

            fontWeight =
                FontWeight.ExtraBold,

            letterSpacing =
                1.sp
        )


        Spacer(
            modifier =
                Modifier.height(7.dp)
        )


        Text(
            text =
                "TEAM MATCHES",

            color =
                Color.White,

            fontSize =
                26.sp,

            fontWeight =
                FontWeight.ExtraBold
        )


        Spacer(
            modifier =
                Modifier.height(6.dp)
        )


        Text(
            text =
                "We found teams that can join your game.",

            color =
                PullpadamGray,

            fontSize =
                12.sp
        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // SEARCH SUMMARY
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        16.dp
                    )
                )
                .background(
                    PullpadamCard
                )
                .padding(15.dp)
        ) {

            Column {

                Text(
                    text =
                        "YOUR GAME",

                    color =
                        PullpadamGreen,

                    fontSize =
                        9.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        0.8.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(10.dp)
                )


                Row(
                    modifier =
                        Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.spacedBy(
                            7.dp
                        )
                ) {

                    TeamInfoTag(
                        text =
                            "$playerCount PLAYERS"
                    )

                    TeamInfoTag(
                        text =
                            format
                    )

                    TeamInfoTag(
                        text =
                            time
                    )

                    TeamInfoTag(
                        text =
                            distance
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // MATCH QUALITY
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        20.dp
                    )
                )
                .background(
                    PullpadamSelected
                )
                .padding(18.dp)
        ) {

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text =
                            "AI RECOMMENDATION",

                        color =
                            PullpadamGreen,

                        fontSize =
                            9.sp,

                        fontWeight =
                            FontWeight.ExtraBold,

                        letterSpacing =
                            0.8.sp
                    )


                    Spacer(
                        modifier =
                            Modifier.height(5.dp)
                    )


                    Text(
                        text =
                            "4 teams can make one game",

                        color =
                            Color.White,

                        fontSize =
                            15.sp,

                        fontWeight =
                            FontWeight.Bold
                    )
                }


                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text =
                            "94%",

                        color =
                            PullpadamGreen,

                        fontSize =
                            25.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )


                    Text(
                        text =
                            "MATCH",

                        color =
                            PullpadamGray,

                        fontSize =
                            7.sp,

                        fontWeight =
                            FontWeight.Bold
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // TEAM A — YOUR TEAM
        // =====================================================

        TeamMergeCard(
            teamLabel =
                "YOUR TEAM",

            teamName =
                "YOUR SQUAD",

            players =
                playerCount,

            strength =
                "78",

            distance =
                "YOU",

            isYourTeam =
                true
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        // =====================================================
        // TEAM B
        // =====================================================

        TeamMergeCard(
            teamLabel =
                "TEAM B",

            teamName =
                "MALABAR KINGS",

            players =
                teamBPlayers,

            strength =
                "76",

            distance =
                "2.8 KM",

            isYourTeam =
                false
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        // =====================================================
        // PLUS
        // =====================================================

        MergePlus()


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        // =====================================================
        // TEAM C
        // =====================================================

        TeamMergeCard(
            teamLabel =
                "TEAM C",

            teamName =
                "KANNUR WARRIORS",

            players =
                teamCPlayers,

            strength =
                "74",

            distance =
                "3.4 KM",

            isYourTeam =
                false
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        MergePlus()


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        // =====================================================
        // TEAM D
        // =====================================================

        TeamMergeCard(
            teamLabel =
                "TEAM D",

            teamName =
                "GREEN FC",

            players =
                teamDPlayers,

            strength =
                "79",

            distance =
                "4.1 KM",

            isYourTeam =
                false
        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // TOTAL
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        18.dp
                    )
                )
                .background(
                    PullpadamCard
                )
                .padding(18.dp)
        ) {

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text =
                            "TOTAL PLAYERS",

                        color =
                            PullpadamGray,

                        fontSize =
                            9.sp,

                        fontWeight =
                            FontWeight.Bold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )


                    Text(
                        text =
                            "$totalPlayers PLAYERS",

                        color =
                            Color.White,

                        fontSize =
                            20.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )
                }


                Column(
                    horizontalAlignment =
                        Alignment.End
                ) {

                    Text(
                        text =
                            "TEAM STRENGTH",

                        color =
                            PullpadamGray,

                        fontSize =
                            9.sp,

                        fontWeight =
                            FontWeight.Bold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )


                    Text(
                        text =
                            "77 / 100",

                        color =
                            PullpadamGreen,

                        fontSize =
                            18.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        // =====================================================
        // WHY THIS MATCH
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        15.dp
                    )
                )
                .background(
                    PullpadamCardLight
                )
                .padding(14.dp)
        ) {

            Column {

                Text(
                    text =
                        "WHY AI CHOSE THIS COMBINATION",

                    color =
                        PullpadamGreen,

                    fontSize =
                        9.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        0.8.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )


                AIReason(
                    text =
                        "All teams are looking for players."
                )


                AIReason(
                    text =
                        "All teams match your game format."
                )


                AIReason(
                    text =
                        "Preferred playing time is similar."
                )


                AIReason(
                    text =
                        "All teams are within your distance."
                )


                AIReason(
                    text =
                        "Team strengths are reasonably balanced."
                )


                AIReason(
                    text =
                        "Maximum of 4 teams is respected."
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // MERGE BUTTON
        // =====================================================

        Button(
            onClick =
                onMergeTeams,

            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),

            shape =
                RoundedCornerShape(
                    17.dp
                ),

            colors =
                ButtonDefaults.buttonColors(
                    containerColor =
                        PullpadamGreen,

                    contentColor =
                        Color.Black
                )
        ) {

            Text(
                text =
                    "MERGE THESE TEAMS  →",

                fontSize =
                    12.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    0.8.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        Text(
            text =
                "All teams will be asked to confirm before the " +
                        "game is created.",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                9.sp,

            textAlign =
                TextAlign.Center,

            lineHeight =
                14.sp
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )
    }
}


// =============================================================
// TEAM MERGE CARD
// =============================================================

@Composable
private fun TeamMergeCard(
    teamLabel: String,
    teamName: String,
    players: Int,
    strength: String,
    distance: String,
    isYourTeam: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    18.dp
                )
            )
            .background(
                if (isYourTeam)
                    PullpadamSelected
                else
                    PullpadamCard
            )
            .padding(16.dp),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        // =====================================================
        // TEAM ICON
        // =====================================================

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        14.dp
                    )
                )
                .background(
                    if (isYourTeam)
                        PullpadamGreen
                    else
                        PullpadamCardLight
                )
                .padding(12.dp),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                text =
                    "⚽",

                fontSize =
                    20.sp
            )
        }


        Spacer(
            modifier =
                Modifier.width(13.dp)
        )


        // =====================================================
        // TEAM INFORMATION
        // =====================================================

        Column(
            modifier =
                Modifier.weight(1f)
        ) {

            Text(
                text =
                    teamLabel,

                color =
                    if (isYourTeam)
                        PullpadamGreen
                    else
                        PullpadamGray,

                fontSize =
                    8.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    0.8.sp
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    teamName,

                color =
                    Color.White,

                fontSize =
                    14.sp,

                fontWeight =
                    FontWeight.ExtraBold
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    "$players players  •  $distance",

                color =
                    PullpadamGray,

                fontSize =
                    9.sp
            )
        }


        // =====================================================
        // STRENGTH
        // =====================================================

        Column(
            horizontalAlignment =
                Alignment.End
        ) {

            Text(
                text =
                    "STRENGTH",

                color =
                    PullpadamGray,

                fontSize =
                    7.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(3.dp)
            )


            Text(
                text =
                    strength,

                color =
                    PullpadamGreen,

                fontSize =
                    17.sp,

                fontWeight =
                    FontWeight.ExtraBold
            )
        }
    }
}


// =============================================================
// PLUS BETWEEN TEAMS
// =============================================================

@Composable
private fun MergePlus() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp),

        contentAlignment =
            Alignment.Center
    ) {

        Text(
            text =
                "+",

            color =
                PullpadamGreen,

            fontSize =
                16.sp,

            fontWeight =
                FontWeight.ExtraBold
        )
    }
}


// =============================================================
// AI REASON
// =============================================================

@Composable
private fun AIReason(
    text: String
) {

    Row(
        modifier =
            Modifier.padding(
                vertical = 2.dp
            ),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text =
                "✓",

            color =
                PullpadamGreen,

            fontSize =
                11.sp,

            fontWeight =
                FontWeight.ExtraBold
        )


        Spacer(
            modifier =
                Modifier.width(7.dp)
        )


        Text(
            text =
                text,

            color =
                PullpadamGray,

            fontSize =
                9.sp
        )
    }
}


// =============================================================
// INFO TAG
// =============================================================

@Composable
private fun TeamInfoTag(
    text: String
) {

    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    8.dp
                )
            )
            .background(
                Color(0xFF202521)
            )
            .padding(
                horizontal = 8.dp,
                vertical = 6.dp
            )
    ) {

        Text(
            text =
                text,

            color =
                Color.White,

            fontSize =
                8.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}