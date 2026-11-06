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
// FIND PLAYER
// =============================================================

@Composable
fun AIFindPlayerScreen(
    onFindPlayers: (
        String,
        Int,
        String,
        String,
        String
    ) -> Unit
) {

    // =========================================================
    // SELECTIONS
    // =========================================================

    var selectedPosition by remember {
        mutableStateOf("Defender")
    }

    var playersNeeded by remember {
        mutableStateOf(1)
    }

    var selectedFormat by remember {
        mutableStateOf("7v7")
    }

    var selectedLevel by remember {
        mutableStateOf("Competitive")
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
                "FIND A PLAYER",

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
                "Need a specific player? Let AI find the right fit.",

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
        // PROFESSIONAL RECRUITMENT CARD (WITH ANIMATED GLOWING BORDER)
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aiRecruiterGlowingBorder(cornerRadius = 18.dp)
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
                        "⚡",

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
                            "TEAM RECRUITMENT",

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
                            "Find a player who fits your squad.",

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
                            "AI uses position, availability, format, " +
                                    "level and distance.",

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
        // POSITION
        // =====================================================

        FindPlayerSectionTitle(
            number = "01",
            title = "Which position do you need?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        PlayerPositionButton(
            text =
                "⚡  Forward",

            selected =
                selectedPosition == "Forward",

            onClick = {
                selectedPosition = "Forward"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        PlayerPositionButton(
            text =
                "🎯  Midfielder",

            selected =
                selectedPosition == "Midfielder",

            onClick = {
                selectedPosition = "Midfielder"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        PlayerPositionButton(
            text =
                "🛡  Defender",

            selected =
                selectedPosition == "Defender",

            onClick = {
                selectedPosition = "Defender"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        PlayerPositionButton(
            text =
                "🧤  Goalkeeper",

            selected =
                selectedPosition == "Goalkeeper",

            onClick = {
                selectedPosition = "Goalkeeper"
            }
        )


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // NUMBER OF PLAYERS
        // =====================================================

        FindPlayerSectionTitle(
            number = "02",
            title = "How many players do you need?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Text(
            text =
                "$playersNeeded PLAYER" +
                        if (playersNeeded > 1) "S" else "",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGreen,

            fontSize =
                23.sp,

            fontWeight =
                FontWeight.ExtraBold,

            textAlign =
                TextAlign.Center
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

            PlayerNumberButton(
                text =
                    "1",

                selected =
                    playersNeeded == 1,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playersNeeded = 1
                }
            )

            PlayerNumberButton(
                text =
                    "2",

                selected =
                    playersNeeded == 2,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playersNeeded = 2
                }
            )

            PlayerNumberButton(
                text =
                    "3",

                selected =
                    playersNeeded == 3,

                modifier =
                    Modifier.weight(1f),

                onClick = {
                    playersNeeded = 3
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

        FindPlayerSectionTitle(
            number = "03",
            title = "What format are you playing?"
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

            PlayerChoiceButton(
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

            PlayerChoiceButton(
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
        // PLAYING LEVEL
        // =====================================================

        FindPlayerSectionTitle(
            number = "04",
            title = "What level are you looking for?"
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        LevelButton(
            text =
                "Casual",

            description =
                "Just here to play",

            selected =
                selectedLevel == "Casual",

            onClick = {
                selectedLevel = "Casual"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        LevelButton(
            text =
                "Competitive",

            description =
                "Regular competitive player",

            selected =
                selectedLevel == "Competitive",

            onClick = {
                selectedLevel = "Competitive"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        LevelButton(
            text =
                "Professional",

            description =
                "Experienced / professional",

            selected =
                selectedLevel == "Professional",

            onClick = {
                selectedLevel = "Professional"
            }
        )


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // DISTANCE
        // =====================================================

        FindPlayerSectionTitle(
            number = "05",
            title = "How far can the player be?"
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

            PlayerChoiceButton(
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

            PlayerChoiceButton(
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

            PlayerChoiceButton(
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
                Modifier.height(28.dp)
        )


        // =====================================================
        // RECRUITMENT RULE
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
                        "SMART RECRUITMENT",

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
                        "AI will prioritize players whose profile " +
                                "matches the required position, format, " +
                                "playing level, availability and distance.",

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
        // FIND PLAYERS BUTTON
        // =====================================================

        Button(
            onClick = {

                onFindPlayers(
                    selectedPosition,
                    playersNeeded,
                    selectedFormat,
                    selectedLevel,
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
                    "FIND PLAYERS  →",

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
                Modifier.height(30.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun FindPlayerSectionTitle(
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
// POSITION BUTTON
// =============================================================

@Composable
private fun PlayerPositionButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(
                RoundedCornerShape(
                    13.dp
                )
            )
            .background(
                if (selected)
                    PullpadamSelected
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 15.dp
            ),

        verticalAlignment =
            Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(
            text =
                text,

            color =
                if (selected)
                    PullpadamGreen
                else
                    Color.White,

            fontSize =
                12.sp,

            fontWeight =
                if (selected)
                    FontWeight.Bold
                else
                    FontWeight.Normal
        )


        if (selected) {

            Text(
                text =
                    "✓",

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
// NUMBER BUTTON
// =============================================================

@Composable
private fun PlayerNumberButton(
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
// GENERAL CHOICE BUTTON
// =============================================================

@Composable
private fun PlayerChoiceButton(
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


// =============================================================
// LEVEL BUTTON
// =============================================================

@Composable
private fun LevelButton(
    text: String,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(
                RoundedCornerShape(
                    14.dp
                )
            )
            .background(
                if (selected)
                    PullpadamSelected
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 15.dp
            ),

        verticalAlignment =
            Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text =
                    text,

                color =
                    if (selected)
                        PullpadamGreen
                    else
                        Color.White,

                fontSize =
                    12.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(3.dp)
            )


            Text(
                text =
                    description,

                color =
                    PullpadamGray,

                fontSize =
                    9.sp
            )
        }


        if (selected) {

            Text(
                text =
                    "✓",

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