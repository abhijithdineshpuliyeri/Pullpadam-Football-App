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
// FIND A GAME
// SINGLE PLAYER
// =============================================================

@Composable
fun AIFindGameScreen(
    onFindGame: (
        String,
        String,
        String,
        String
    ) -> Unit
) {

    // =========================================================
    // SELECTIONS
    // =========================================================

    var selectedFormat by remember {
        mutableStateOf("7v7")
    }

    var selectedTime by remember {
        mutableStateOf("Evening")
    }

    var selectedBudget by remember {
        mutableStateOf("₹1000–₹1500")
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
                "FIND A GAME",

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
                "Playing alone? We'll find a game for you.",

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
        // PLAYER INFO CARD
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
                        "👤",

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
                            "YOUR PLAYER PROFILE",

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
                            "Forward  •  Competitive",

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
                            "Your position will come from your profile.",

                        color =
                            PullpadamGray,

                        fontSize =
                            9.sp
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(28.dp)
        )


        // =====================================================
        // FORMAT
        // =====================================================

        FindGameSectionTitle(
            number = "01",
            title = "What do you want to play?"
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

            SelectionButton(
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

            SelectionButton(
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
                Modifier.height(27.dp)
        )


        // =====================================================
        // TIME
        // =====================================================

        FindGameSectionTitle(
            number = "02",
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

            SelectionButton(
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

            SelectionButton(
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

            SelectionButton(
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
                Modifier.height(27.dp)
        )


        // =====================================================
        // BUDGET
        // =====================================================

        FindGameSectionTitle(
            number = "03",
            title = "What's your budget?"
        )

        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        BudgetOption(
            text =
                "Under ₹1000",

            selected =
                selectedBudget == "Under ₹1000",

            onClick = {
                selectedBudget = "Under ₹1000"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        BudgetOption(
            text =
                "₹1000–₹1500",

            selected =
                selectedBudget == "₹1000–₹1500",

            onClick = {
                selectedBudget = "₹1000–₹1500"
            }
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        BudgetOption(
            text =
                "₹1500+",

            selected =
                selectedBudget == "₹1500+",

            onClick = {
                selectedBudget = "₹1500+"
            }
        )


        Spacer(
            modifier =
                Modifier.height(27.dp)
        )


        // =====================================================
        // DISTANCE
        // =====================================================

        FindGameSectionTitle(
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

            SelectionButton(
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

            SelectionButton(
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

            SelectionButton(
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
        // FIND GAME BUTTON
        // =====================================================

        Button(
            onClick = {

                onFindGame(
                    selectedFormat,
                    selectedTime,
                    selectedBudget,
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
                    "FIND MY GAME  →",

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


        Text(
            text =
                "Pullpadam AI will match you with teams " +
                        "that need a player like you.",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                10.sp,

            textAlign =
                TextAlign.Center,

            lineHeight =
                15.sp
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun FindGameSectionTitle(
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
// SELECTION BUTTON
// =============================================================

@Composable
private fun SelectionButton(
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
                11.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// BUDGET OPTION
// =============================================================

@Composable
private fun BudgetOption(
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