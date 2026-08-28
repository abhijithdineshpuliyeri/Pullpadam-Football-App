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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamSelected = Color(0xFF24321B)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun EditProfileScreen(
    currentName: String = "Abhijith",
    currentPosition: String = "Forward",
    currentSecondaryPosition: String = "Left Wing",
    currentLevel: String = "Competitive",
    currentFormat: String = "5v5 • 7v7",
    currentAvailability: String = "Evening",
    currentLocation: String = "Kannur",
    onSave: (
        String,
        String,
        String,
        String,
        String,
        String,
        String
    ) -> Unit,
    onBack: () -> Unit
) {

    var name by remember {
        mutableStateOf(currentName)
    }

    var position by remember {
        mutableStateOf(currentPosition)
    }

    var secondaryPosition by remember {
        mutableStateOf(currentSecondaryPosition)
    }

    var level by remember {
        mutableStateOf(currentLevel)
    }

    var format by remember {
        mutableStateOf(currentFormat)
    }

    var availability by remember {
        mutableStateOf(currentAvailability)
    }

    var location by remember {
        mutableStateOf(currentLocation)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // HEADER
        // =====================================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(11.dp))
                    .background(PullpadamCard)
                    .clickable {
                        onBack()
                    }
                    .padding(
                        horizontal = 13.dp,
                        vertical = 10.dp
                    )
            ) {

                Text(
                    text = "←",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.width(13.dp)
            )

            Column {

                Text(
                    text = "PROFILE",
                    color = PullpadamGreen,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "EDIT PROFILE",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Spacer(
            modifier = Modifier.height(28.dp)
        )

        // =====================================================
        // BASIC INFORMATION
        // =====================================================

        EditSectionTitle(
            title = "BASIC INFORMATION"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "PLAYER NAME",
            color = PullpadamGray,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PullpadamGreen,
                unfocusedBorderColor = Color(0xFF303532),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = PullpadamGreen
            )
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // PRIMARY POSITION
        // =====================================================

        EditSectionTitle(
            title = "PRIMARY POSITION"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        PositionOption(
            text = "Forward",
            selected = position == "Forward",
            onClick = {
                position = "Forward"
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        PositionOption(
            text = "Midfielder",
            selected = position == "Midfielder",
            onClick = {
                position = "Midfielder"
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        PositionOption(
            text = "Defender",
            selected = position == "Defender",
            onClick = {
                position = "Defender"
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        PositionOption(
            text = "Goalkeeper",
            selected = position == "Goalkeeper",
            onClick = {
                position = "Goalkeeper"
            }
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // SECONDARY POSITION
        // =====================================================

        EditSectionTitle(
            title = "SECONDARY POSITION"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            SmallOption(
                text = "Left Wing",
                selected = secondaryPosition == "Left Wing",
                modifier = Modifier.weight(1f),
                onClick = {
                    secondaryPosition = "Left Wing"
                }
            )

            SmallOption(
                text = "Right Wing",
                selected = secondaryPosition == "Right Wing",
                modifier = Modifier.weight(1f),
                onClick = {
                    secondaryPosition = "Right Wing"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            SmallOption(
                text = "Midfield",
                selected = secondaryPosition == "Midfield",
                modifier = Modifier.weight(1f),
                onClick = {
                    secondaryPosition = "Midfield"
                }
            )

            SmallOption(
                text = "None",
                selected = secondaryPosition == "None",
                modifier = Modifier.weight(1f),
                onClick = {
                    secondaryPosition = "None"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // PLAYING LEVEL
        // =====================================================

        EditSectionTitle(
            title = "PLAYING LEVEL"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        LevelOption(
            title = "Casual",
            description = "Playing for fun",
            selected = level == "Casual",
            onClick = {
                level = "Casual"
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        LevelOption(
            title = "Competitive",
            description = "Regular competitive games",
            selected = level == "Competitive",
            onClick = {
                level = "Competitive"
            }
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        LevelOption(
            title = "Professional",
            description = "Experienced / professional",
            selected = level == "Professional",
            onClick = {
                level = "Professional"
            }
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // GAME FORMAT
        // =====================================================

        EditSectionTitle(
            title = "PREFERRED FORMAT"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            SmallOption(
                text = "5v5",
                selected = format == "5v5",
                modifier = Modifier.weight(1f),
                onClick = {
                    format = "5v5"
                }
            )

            SmallOption(
                text = "7v7",
                selected = format == "7v7",
                modifier = Modifier.weight(1f),
                onClick = {
                    format = "7v7"
                }
            )

            SmallOption(
                text = "Both",
                selected = format == "5v5 • 7v7",
                modifier = Modifier.weight(1f),
                onClick = {
                    format = "5v5 • 7v7"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // AVAILABILITY
        // =====================================================

        EditSectionTitle(
            title = "PREFERRED PLAYING TIME"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            SmallOption(
                text = "Morning",
                selected = availability == "Morning",
                modifier = Modifier.weight(1f),
                onClick = {
                    availability = "Morning"
                }
            )

            SmallOption(
                text = "Evening",
                selected = availability == "Evening",
                modifier = Modifier.weight(1f),
                onClick = {
                    availability = "Evening"
                }
            )

            SmallOption(
                text = "Night",
                selected = availability == "Night",
                modifier = Modifier.weight(1f),
                onClick = {
                    availability = "Night"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // LOCATION
        // =====================================================

        EditSectionTitle(
            title = "LOCATION"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PullpadamGreen,
                unfocusedBorderColor = Color(0xFF303532),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = PullpadamGreen
            )
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button(
            onClick = {

                onSave(
                    name,
                    position,
                    secondaryPosition,
                    level,
                    format,
                    availability,
                    location
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp),

            shape = RoundedCornerShape(17.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = PullpadamGreen,
                contentColor = Color.Black
            )
        ) {

            Text(
                text = "SAVE PROFILE",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.9.sp
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text =
                "Your profile information will be used by " +
                        "Pullpadam AI for player matching.",

            modifier = Modifier.fillMaxWidth(),

            color = PullpadamGray,
            fontSize = 9.sp,
            lineHeight = 14.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun EditSectionTitle(
    title: String
) {

    Text(
        text = title,
        color = PullpadamGreen,
        fontSize = 10.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 0.8.sp
    )
}


// =============================================================
// POSITION OPTION
// =============================================================

@Composable
private fun PositionOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(
                if (selected)
                    PullpadamSelected
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            }
            .padding(horizontal = 15.dp),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(
            text = text,
            color =
                if (selected)
                    PullpadamGreen
                else
                    Color.White,
            fontSize = 12.sp,
            fontWeight =
                if (selected)
                    FontWeight.Bold
                else
                    FontWeight.Normal
        )

        if (selected) {

            Text(
                text = "✓",
                color = PullpadamGreen,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}


// =============================================================
// SMALL OPTION
// =============================================================

@Composable
private fun SmallOption(
    text: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .height(50.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(
                if (selected)
                    PullpadamGreen
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            },

        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            color =
                if (selected)
                    Color.Black
                else
                    Color.White,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// =============================================================
// LEVEL OPTION
// =============================================================

@Composable
private fun LevelOption(
    title: String,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                if (selected)
                    PullpadamSelected
                else
                    PullpadamCard
            )
            .clickable {
                onClick()
            }
            .padding(horizontal = 15.dp),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text = title,
                color =
                    if (selected)
                        PullpadamGreen
                    else
                        Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = description,
                color = PullpadamGray,
                fontSize = 9.sp
            )
        }

        if (selected) {

            Text(
                text = "✓",
                color = PullpadamGreen,
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}