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

private val PullpadamGray =
    Color(0xFF9A9F9C)


// =============================================================
// GAME MATCHES SCREEN
// =============================================================

@Composable
fun AIGameMatchesScreen(
    format: String,
    time: String,
    budget: String,
    distance: String,
    onJoinGame: (String) -> Unit
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
                Modifier.height(8.dp)
        )


        Text(
            text =
                "YOUR GAME",

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
                "We found games that match your profile.",

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
                        "YOUR SEARCH",

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

                    SearchTag(
                        text =
                            format
                    )

                    SearchTag(
                        text =
                            time
                    )

                    SearchTag(
                        text =
                            distance
                    )
                }


                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )


                Text(
                    text =
                        budget,

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
        // FIRST MATCH
        // =====================================================

        GameMatchCard(
            teamName =
                "KANNUR UNITED",

            match =
                "96%",

            playersNeeded =
                "1 MIDFIELDER",

            format =
                format,

            time =
                time,

            distance =
                "3.4 KM",

            price =
                "₹1,200 / game",

            reason =
                "They are looking for a midfielder " +
                        "and their game matches your preferences.",

            onJoin = {
                onJoinGame(
                    "KANNUR UNITED"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // SECOND MATCH
        // =====================================================

        GameMatchCard(
            teamName =
                "GREEN WARRIORS",

            match =
                "91%",

            playersNeeded =
                "1 PLAYER",

            format =
                format,

            time =
                time,

            distance =
                "4.8 KM",

            price =
                "₹1,100 / game",

            reason =
                "A nearby team has an open spot " +
                        "for a player joining their game.",

            onJoin = {
                onJoinGame(
                    "GREEN WARRIORS"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // THIRD MATCH
        // =====================================================

        GameMatchCard(
            teamName =
                "MALABAR FC",

            match =
                "87%",

            playersNeeded =
                "2 PLAYERS",

            format =
                format,

            time =
                time,

            distance =
                "5.0 KM",

            price =
                "₹1,000 / game",

            reason =
                "Good format and time match with " +
                        "a slightly longer distance.",

            onJoin = {
                onJoinGame(
                    "MALABAR FC"
                )
            }
        )


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        // =====================================================
        // AI NOTE
        // =====================================================

        Text(
            text =
                "MATCHES ARE RANKED USING YOUR PROFILE, " +
                        "GAME FORMAT, TIME, DISTANCE AND AVAILABILITY.",

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
// GAME MATCH CARD
// =============================================================

@Composable
private fun GameMatchCard(
    teamName: String,
    match: String,
    playersNeeded: String,
    format: String,
    time: String,
    distance: String,
    price: String,
    reason: String,
    onJoin: () -> Unit
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
        // TOP
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.Top
        ) {

            Column {

                Text(
                    text =
                        "AI MATCH",

                    color =
                        PullpadamGreen,

                    fontSize =
                        9.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        1.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(6.dp)
                )


                Text(
                    text =
                        teamName,

                    color =
                        Color.White,

                    fontSize =
                        20.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }


            // =================================================
            // MATCH %
            // =================================================

            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            12.dp
                        )
                    )
                    .background(
                        Color(0xFF24321B)
                    )
                    .padding(
                        horizontal = 11.dp,
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
        // PLAYER REQUIREMENT
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        12.dp
                    )
                )
                .background(
                    PullpadamCardLight
                )
                .padding(12.dp)
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text =
                        "⚽",

                    fontSize =
                        21.sp
                )


                Spacer(
                    modifier =
                        Modifier.width(10.dp)
                )


                Column {

                    Text(
                        text =
                            "PLAYER NEEDED",

                        color =
                            PullpadamGray,

                        fontSize =
                            8.sp,

                        fontWeight =
                            FontWeight.Bold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(3.dp)
                    )


                    Text(
                        text =
                            playersNeeded,

                        color =
                            PullpadamGreen,

                        fontSize =
                            12.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        // =====================================================
        // GAME INFORMATION
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(
                    7.dp
                )
        ) {

            MatchInfoTag(
                text =
                    format
            )

            MatchInfoTag(
                text =
                    time
            )

            MatchInfoTag(
                text =
                    distance
            )
        }


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Text(
            text =
                price,

            color =
                PullpadamGreen,

            fontSize =
                14.sp,

            fontWeight =
                FontWeight.ExtraBold
        )


        Spacer(
            modifier =
                Modifier.height(16.dp)
        )


        // =====================================================
        // WHY THIS MATCH
        // =====================================================

        Text(
            text =
                "WHY THIS MATCH",

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
        // JOIN BUTTON
        // =====================================================

        Button(
            onClick =
                onJoin,

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
                    "JOIN THIS GAME  →",

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
// SEARCH TAG
// =============================================================

@Composable
private fun SearchTag(
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
                horizontal = 9.dp,
                vertical = 6.dp
            )
    ) {

        Text(
            text =
                text,

            color =
                Color.White,

            fontSize =
                9.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// MATCH INFO TAG
// =============================================================

@Composable
private fun MatchInfoTag(
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
                horizontal = 9.dp,
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