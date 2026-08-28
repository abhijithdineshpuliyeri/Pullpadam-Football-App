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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
private val PullpadamCardLight = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun ProfileScreen(
    playerName: String = "Abhijith",
    position: String = "Forward",
    secondaryPosition: String = "Left Wing",
    level: String = "Competitive",
    format: String = "5v5 • 7v7",
    availability: String = "Evening",
    location: String = "Kannur",
    recruitmentEnabled: Boolean = true,
    onEditProfile: () -> Unit = {},
    onRecruitment: () -> Unit = {}
) {

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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = "MY PROFILE",
                    color = PullpadamGreen,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "PLAYER PROFILE",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(PullpadamCard)
                    .clickable {
                        onEditProfile()
                    }
                    .padding(
                        horizontal = 13.dp,
                        vertical = 10.dp
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "EDIT",
                    color = PullpadamGreen,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // PLAYER HEADER CARD
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(22.dp))
                .background(PullpadamCard)
                .padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(PullpadamGreen)
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = playerName
                            .firstOrNull()
                            ?.uppercase()
                            ?: "P",

                        color = Color.Black,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(
                    modifier = Modifier.width(15.dp)
                )

                Column {

                    Text(
                        text = playerName,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )

                    Text(
                        text = position,
                        color = PullpadamGreen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "$level player",
                        color = PullpadamGray,
                        fontSize = 10.sp
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // PLAYING INFORMATION
        // =====================================================

        ProfileSectionTitle(
            title = "PLAYING INFORMATION"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        ProfileInfoCard(
            title = "PRIMARY POSITION",
            value = position
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        ProfileInfoCard(
            title = "SECONDARY POSITION",
            value = secondaryPosition
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        ProfileInfoCard(
            title = "PLAYING LEVEL",
            value = level
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        ProfileInfoCard(
            title = "PREFERRED FORMAT",
            value = format
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // AVAILABILITY
        // =====================================================

        ProfileSectionTitle(
            title = "AVAILABILITY"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        ProfileInfoCard(
            title = "PREFERRED PLAYING TIME",
            value = availability
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        ProfileInfoCard(
            title = "PLAYING LOCATION",
            value = location
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // AI RECRUITMENT
        // =====================================================

        ProfileSectionTitle(
            title = "PULLPADAM AI"
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(
                    if (recruitmentEnabled)
                        PullpadamCardLight
                    else
                        PullpadamCard
                )
                .clickable {
                    onRecruitment()
                }
                .padding(18.dp)
        ) {

            Column {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween,
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "AI RECRUITMENT",
                            color = PullpadamGreen,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 0.8.sp
                        )

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text =
                                if (recruitmentEnabled)
                                    "Available for recruitment"
                                else
                                    "Not available for recruitment",

                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(
                                if (recruitmentEnabled)
                                    PullpadamGreen
                                else
                                    Color(0xFF303532)
                            )
                            .padding(
                                horizontal = 11.dp,
                                vertical = 7.dp
                            )
                    ) {

                        Text(
                            text =
                                if (recruitmentEnabled)
                                    "ON"
                                else
                                    "OFF",

                            color =
                                if (recruitmentEnabled)
                                    Color.Black
                                else
                                    PullpadamGray,

                            fontSize = 9.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text =
                        "Allow Pullpadam AI to recommend you " +
                                "to teams looking for your position.",

                    color = PullpadamGray,
                    fontSize = 10.sp,
                    lineHeight = 15.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // AI PROFILE SUMMARY
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PullpadamCard)
                .padding(16.dp)
        ) {

            Column {

                Text(
                    text = "AI MATCHING PROFILE",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text =
                        "$position • $level • $format",

                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text =
                        "$availability • $location",

                    color = PullpadamGray,
                    fontSize = 10.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun ProfileSectionTitle(
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
// INFORMATION CARD
// =============================================================

@Composable
private fun ProfileInfoCard(
    title: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(PullpadamCard)
            .padding(
                horizontal = 15.dp,
                vertical = 13.dp
            ),
        horizontalArrangement =
            Arrangement.SpaceBetween,
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(
            text = title,
            color = PullpadamGray,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = value,
            color = Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}