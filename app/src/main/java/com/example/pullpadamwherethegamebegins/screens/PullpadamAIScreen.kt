package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
// PULLPADAM COLORS
// =============================================================

private val PullpadamBackground =
    Color(0xFF0B0D0C)

private val PullpadamGreen =
    Color(0xFFB6FF3B)

private val PullpadamCard =
    Color(0xFF151917)

private val PullpadamGray =
    Color(0xFF9A9F9C)


// =============================================================
// PULLPADAM AI HOME
// =============================================================

@Composable
fun PullpadamAIScreen(
    onFindGame: () -> Unit,
    onFindTeam: () -> Unit,
    onFindPlayer: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                PullpadamBackground
            )
            .padding(
                horizontal = 20.dp
            )
    ) {

        Spacer(
            modifier =
                Modifier.height(35.dp)
        )


        // =====================================================
        // HEADER
        // =====================================================

        Text(
            text = "PULLPADAM AI",

            color =
                PullpadamGreen,

            fontSize =
                26.sp,

            fontWeight =
                FontWeight.ExtraBold,

            letterSpacing =
                0.5.sp
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        Text(
            text =
                "Your football matchmaker.",

            color =
                Color.White,

            fontSize =
                17.sp,

            fontWeight =
                FontWeight.Bold
        )


        Spacer(
            modifier =
                Modifier.height(7.dp)
        )


        Text(
            text =
                "Find players, teams and games that fit you.",

            color =
                PullpadamGray,

            fontSize =
                12.sp,

            lineHeight =
                18.sp
        )


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        // =====================================================
        // FIND A GAME
        // =====================================================

        AIFeatureCard(
            icon = "⚽",

            title =
                "FIND A GAME",

            description =
                "Playing alone? Find a team that has space " +
                        "for a player like you.",

            buttonText =
                "FIND MY GAME  →",

            onClick =
                onFindGame
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // FIND A TEAM
        // =====================================================

        AIFeatureCard(
            icon = "🤝",

            title =
                "FIND A TEAM",

            description =
                "Not enough players? Connect with other " +
                        "incomplete teams and merge your squads.",

            buttonText =
                "FIND A TEAM  →",

            onClick =
                onFindTeam
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // FIND A PLAYER
        // =====================================================

        AIFeatureCard(
            icon = "🧤",

            title =
                "FIND A PLAYER",

            description =
                "Need a specific position? Find players " +
                        "who match your team's requirements.",

            buttonText =
                "FIND PLAYER  →",

            onClick =
                onFindPlayer
        )


        Spacer(
            modifier =
                Modifier.weight(1f)
        )


        // =====================================================
        // AI FOOTER
        // =====================================================

        Text(
            text =
                "PULLPADAM AI",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                9.sp,

            fontWeight =
                FontWeight.Bold,

            textAlign =
                TextAlign.Center,

            letterSpacing =
                2.sp
        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )
    }
}


// =============================================================
// AI FEATURE CARD
// =============================================================

@Composable
private fun AIFeatureCard(
    icon: String,
    title: String,
    description: String,
    buttonText: String,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    22.dp
                )
            )
            .background(
                PullpadamCard
            )
            .clickable {
                onClick()
            }
            .padding(20.dp)
    ) {


        // =====================================================
        // ICON
        // =====================================================

        Text(
            text =
                icon,

            fontSize =
                30.sp
        )


        Spacer(
            modifier =
                Modifier.height(13.dp)
        )


        // =====================================================
        // TITLE
        // =====================================================

        Text(
            text =
                title,

            color =
                Color.White,

            fontSize =
                20.sp,

            fontWeight =
                FontWeight.ExtraBold,

            letterSpacing =
                0.4.sp
        )


        Spacer(
            modifier =
                Modifier.height(7.dp)
        )


        // =====================================================
        // DESCRIPTION
        // =====================================================

        Text(
            text =
                description,

            color =
                PullpadamGray,

            fontSize =
                12.sp,

            lineHeight =
                18.sp
        )


        Spacer(
            modifier =
                Modifier.height(17.dp)
        )


        // =====================================================
        // ACTION
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .clip(
                    RoundedCornerShape(
                        13.dp
                    )
                )
                .background(
                    PullpadamGreen
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                text =
                    buttonText,

                color =
                    Color.Black,

                fontSize =
                    11.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    0.8.sp
            )
        }
    }
}