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
// PLAYER MATCHES SCREEN
// =============================================================

@Composable
fun AIPlayerMatchesScreen(
    position: String,
    playersNeeded: Int,
    format: String,
    level: String,
    distance: String,
    onInvitePlayer: (String) -> Unit
) {

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
                "PLAYER MATCHES",

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
                "AI found players who fit your requirements.",

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
                        "YOUR REQUIREMENT",

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

                    PlayerInfoTag(
                        text =
                            position
                    )

                    PlayerInfoTag(
                        text =
                            "$playersNeeded NEEDED"
                    )

                    PlayerInfoTag(
                        text =
                            format
                    )
                }


                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )


                Text(
                    text =
                        "$level  •  Within $distance",

                    color =
                        PullpadamGray,

                    fontSize =
                        10.sp
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // RESULT COUNT
        // =====================================================

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
                        "MATCHES FOUND",

                    color =
                        PullpadamGray,

                    fontSize =
                        9.sp,

                    fontWeight =
                        FontWeight.Bold
                )


                Spacer(
                    modifier =
                        Modifier.height(3.dp)
                )


                Text(
                    text =
                        "3 PLAYERS",

                    color =
                        Color.White,

                    fontSize =
                        18.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }


            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            10.dp
                        )
                    )
                    .background(
                        PullpadamSelected
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 7.dp
                    )
            ) {

                Text(
                    text =
                        "PROFILE MATCHING",

                    color =
                        PullpadamGreen,

                    fontSize =
                        8.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // PLAYER 1
        // =====================================================

        PlayerMatchCard(
            name =
                "ARJUN",

            position =
                position,

            match =
                "96%",

            rating =
                "4.8",

            distance =
                "2.1 KM",

            format =
                format,

            level =
                level,

            availability =
                "Evening",

            reason =
                "Position, format and playing level " +
                        "match your requirement.",

            onInvite = {
                onInvitePlayer(
                    "ARJUN"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // PLAYER 2
        // =====================================================

        PlayerMatchCard(
            name =
                "RAHUL",

            position =
                position,

            match =
                "91%",

            rating =
                "4.6",

            distance =
                "3.8 KM",

            format =
                format,

            level =
                level,

            availability =
                "Evening",

            reason =
                "Strong position match with good " +
                        "distance and availability.",

            onInvite = {
                onInvitePlayer(
                    "RAHUL"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // PLAYER 3
        // =====================================================

        PlayerMatchCard(
            name =
                "VISHNU",

            position =
                position,

            match =
                "87%",

            rating =
                "4.5",

            distance =
                "4.6 KM",

            format =
                format,

            level =
                level,

            availability =
                "Evening",

            reason =
                "Good overall profile match and " +
                        "available for recruitment.",

            onInvite = {
                onInvitePlayer(
                    "VISHNU"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // AI EXPLANATION
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
                    PullpadamCardLight
                )
                .padding(15.dp)
        ) {

            Column {

                Text(
                    text =
                        "HOW AI MATCHED THESE PLAYERS",

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


                PlayerReason(
                    text =
                        "Required position matches."
                )


                PlayerReason(
                    text =
                        "Player has recruitment enabled."
                )


                PlayerReason(
                    text =
                        "Game format is compatible."
                )


                PlayerReason(
                    text =
                        "Playing level is suitable."
                )


                PlayerReason(
                    text =
                        "Player availability matches."
                )


                PlayerReason(
                    text =
                        "Player is within the selected distance."
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        Text(
            text =
                "PLAYER INFORMATION IS BASED ON " +
                        "THEIR PULLPADAM PROFILE AND RECRUITMENT SETTINGS.",

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
// PLAYER MATCH CARD
// =============================================================

@Composable
private fun PlayerMatchCard(
    name: String,
    position: String,
    match: String,
    rating: String,
    distance: String,
    format: String,
    level: String,
    availability: String,
    reason: String,
    onInvite: () -> Unit
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
            .padding(18.dp)
    ) {

        // =====================================================
        // PLAYER HEADER
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.Top
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
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

                    Text(
                        text =
                            "👤",

                        fontSize =
                            24.sp
                    )
                }


                Spacer(
                    modifier =
                        Modifier.width(12.dp)
                )


                Column {

                    Text(
                        text =
                            name,

                        color =
                            Color.White,

                        fontSize =
                            19.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )


                    Text(
                        text =
                            position,

                        color =
                            PullpadamGreen,

                        fontSize =
                            10.sp,

                        fontWeight =
                            FontWeight.Bold
                    )
                }
            }


            // =================================================
            // MATCH SCORE
            // =================================================

            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            11.dp
                        )
                    )
                    .background(
                        PullpadamSelected
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 8.dp
                    )
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text =
                            match,

                        color =
                            PullpadamGreen,

                        fontSize =
                            16.sp,

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
                Modifier.height(18.dp)
        )


        // =====================================================
        // PLAYER DETAILS
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(
                    7.dp
                )
        ) {

            PlayerDetailTag(
                text =
                    "★ $rating"
            )

            PlayerDetailTag(
                text =
                    format
            )

            PlayerDetailTag(
                text =
                    level
            )
        }


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(
                    7.dp
                )
        ) {

            PlayerDetailTag(
                text =
                    "📍 $distance"
            )

            PlayerDetailTag(
                text =
                    "Available: $availability"
            )
        }


        Spacer(
            modifier =
                Modifier.height(16.dp)
        )


        // =====================================================
        // WHY THIS PLAYER
        // =====================================================

        Text(
            text =
                "WHY THIS PLAYER",

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
                reason,

            color =
                PullpadamGray,

            fontSize =
                10.sp,

            lineHeight =
                15.sp
        )


        Spacer(
            modifier =
                Modifier.height(17.dp)
        )


        // =====================================================
        // INVITE BUTTON
        // =====================================================

        Button(
            onClick =
                onInvite,

            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),

            shape =
                RoundedCornerShape(
                    14.dp
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
                    "INVITE $name  →",

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


// =============================================================
// INFO TAG
// =============================================================

@Composable
private fun PlayerInfoTag(
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


// =============================================================
// PLAYER DETAIL TAG
// =============================================================

@Composable
private fun PlayerDetailTag(
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
                PullpadamGray,

            fontSize =
                8.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// AI REASON
// =============================================================

@Composable
private fun PlayerReason(
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
