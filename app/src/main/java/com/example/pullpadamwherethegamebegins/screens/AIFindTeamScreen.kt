package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

private val PullpadamSelected =
    Color(0xFF24321B)

private val PullpadamGray =
    Color(0xFF9A9F9C)


// =============================================================
// FIND A TEAM
// =============================================================

@Composable
fun AIFindTeamScreen(
    onFindTeams: (
        Int,
        String,
        String,
        String
    ) -> Unit
) {

    // =========================================================
    // SELECTIONS
    // =========================================================

    var playerCount by remember {
        mutableStateOf(3)
    }

    var selectedFormat by remember {
        mutableStateOf("7v7")
    }

    var selectedTime by remember {
        mutableStateOf("Evening")
    }

    var selectedDistance by remember {
        mutableStateOf("5 KM")
    }


    // =========================================================
    // SCREEN
    // =========================================================

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
                "FIND A TEAM",

            color =
                PullpadamGreen,

            fontSize =
                26.sp,

            fontWeight =
                FontWeight.ExtraBold
        )


        Spacer(
            modifier =
                Modifier.height(7.dp)
        )


        Text(
            text =
                "Not enough players? Find other teams " +
                        "and build one game together.",

            color =
                PullpadamGray,

            fontSize =
                12.sp,

            lineHeight =
                18.sp
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // EXPLANATION CARD
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
                .padding(17.dp)
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text =
                        "🤝",

                    fontSize =
                        30.sp
                )

                Spacer(
                    modifier =
                        Modifier.width(13.dp)
                )

                Column {

                    Text(
                        text =
                            "TEAM MERGE",

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
                            Modifier.height(4.dp)
                    )

                    Text(
                        text =
                            "Up to 4 teams can join one game.",

                        color =
                            Color.White,

                        fontSize =
                            13.sp,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(3.dp)
                    )

                    Text(
                        text =
                            "Positions don't matter here. " +
                                    "Player count, format and availability do.",

                        color =
                            PullpadamGray,

                        fontSize =
                            9.sp,

                        lineHeight =
                            14.sp
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // PLAYER COUNT
        // =====================================================

        FindTeamSectionTitle(
            number = "01",
            title = "How many players do you have?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Text(
            text =
                "$playerCount PLAYERS",

            color =
                PullpadamGreen,

            fontSize =
                24.sp,

            fontWeight =
                FontWeight.ExtraBold,

            modifier =
                Modifier.fillMaxWidth(),

            textAlign =
                TextAlign.Center
        )


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            PlayerCountButton(
                text =
                    "2",

                selected =
                    playerCount == 2,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playerCount = 2
                }
            )

            PlayerCountButton(
                text =
                    "3",

                selected =
                    playerCount == 3,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playerCount = 3
                }
            )

            PlayerCountButton(
                text =
                    "4",

                selected =
                    playerCount == 4,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playerCount = 4
                }
            )

            PlayerCountButton(
                text =
                    "5",

                selected =
                    playerCount == 5,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playerCount = 5
                }
            )
        }


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // FORMAT
        // =====================================================

        FindTeamSectionTitle(
            number = "02",
            title = "What format do you want?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(10.dp)
        ) {

            TeamSelectionButton(
                text =
                    "5v5",

                selected =
                    selectedFormat == "5v5",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedFormat = "5v5"
                }
            )

            TeamSelectionButton(
                text =
                    "7v7",

                selected =
                    selectedFormat == "7v7",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedFormat = "7v7"
                }
            )
        }


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // TIME
        // =====================================================

        FindTeamSectionTitle(
            number = "03",
            title = "When do you want to play?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            TeamSelectionButton(
                text =
                    "Morning",

                selected =
                    selectedTime == "Morning",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedTime = "Morning"
                }
            )

            TeamSelectionButton(
                text =
                    "Evening",

                selected =
                    selectedTime == "Evening",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedTime = "Evening"
                }
            )

            TeamSelectionButton(
                text =
                    "Night",

                selected =
                    selectedTime == "Night",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedTime = "Night"
                }
            )
        }


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // DISTANCE
        // =====================================================

        FindTeamSectionTitle(
            number = "04",
            title = "How far can you travel?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            TeamSelectionButton(
                text =
                    "2 KM",

                selected =
                    selectedDistance == "2 KM",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedDistance = "2 KM"
                }
            )

            TeamSelectionButton(
                text =
                    "5 KM",

                selected =
                    selectedDistance == "5 KM",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedDistance = "5 KM"
                }
            )

            TeamSelectionButton(
                text =
                    "ANY",

                selected =
                    selectedDistance == "ANY",

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    selectedDistance = "ANY"
                }
            )
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        // =====================================================
        // MERGE EXPLANATION
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
                    PullpadamSelected
                )
                .padding(14.dp)
        ) {

            Column {

                Text(
                    text =
                        "HOW AI WILL MATCH YOU",

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
                        Modifier.height(7.dp)
                )

                Text(
                    text =
                        "AI will look for up to 3 other incomplete " +
                                "teams that match your format, time and " +
                                "location. Player positions are not used " +
                                "for team merging.",

                    color =
                        PullpadamGray,

                    fontSize =
                        10.sp,

                    lineHeight =
                        15.sp
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // FIND TEAMS
        // =====================================================

        Button(
            onClick = {

                onFindTeams(
                    playerCount,
                    selectedFormat,
                    selectedTime,
                    selectedDistance
                )
            },

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
                    "FIND TEAMS  →",

                fontSize =
                    13.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    0.9.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun FindTeamSectionTitle(
    number: String,
    title: String
) {

    Row(
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text =
                number,

            color =
                PullpadamGreen,

            fontSize =
                11.sp,

            fontWeight =
                FontWeight.ExtraBold
        )

        Spacer(
            modifier =
                Modifier.width(10.dp)
        )

        Text(
            text =
                title,

            color =
                Color.White,

            fontSize =
                15.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// PLAYER COUNT BUTTON
// =============================================================

@Composable
private fun PlayerCountButton(
    text: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .height(50.dp)
            .clip(
                RoundedCornerShape(
                    14.dp
                )
            )
            .background(
                if (selected)
                    PullpadamGreen
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            },

        contentAlignment =
            Alignment.Center
    ) {

        Text(
            text =
                text,

            color =
                if (selected)
                    Color.Black
                else
                    Color.White,

            fontSize =
                14.sp,

            fontWeight =
                FontWeight.ExtraBold
        )
    }
}


// =============================================================
// TEAM SELECTION BUTTON
// =============================================================

@Composable
private fun TeamSelectionButton(
    text: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .height(50.dp)
            .clip(
                RoundedCornerShape(
                    14.dp
                )
            )
            .background(
                if (selected)
                    PullpadamGreen
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            },

        contentAlignment =
            Alignment.Center
    ) {

        Text(
            text =
                text,

            color =
                if (selected)
                    Color.Black
                else
                    Color.White,

            fontSize =
                10.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}