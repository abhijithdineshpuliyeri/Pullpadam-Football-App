package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCard2 = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)
private val PullpadamBorder = Color(0xFF303532)

@Composable
fun ProfileScreen(
    playerName: String,
    position: String,
    secondaryPosition: String,
    level: String,
    format: String,
    availability: String,
    location: String,
    recruitmentEnabled: Boolean,
    onEditProfile: () -> Unit,
    onRecruitment: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        // ---------------------------------------------------------
        // HEADER
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "PROFILE",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ---------------------------------------------------------
        // PROFILE HEADER CARD
        // ---------------------------------------------------------

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(PullpadamCard)
                .padding(20.dp)
        ) {

            Column {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Profile avatar
                    Box(
                        modifier = Modifier
                            .size(76.dp)
                            .clip(CircleShape)
                            .background(PullpadamGreen),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = getInitials(playerName),
                            color = Color.Black,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = playerName,
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "$position • $level",
                            color = PullpadamGreen,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "📍 $location",
                            color = PullpadamGray,
                            fontSize = 11.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Edit profile button
                Button(
                    onClick = onEditProfile,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PullpadamCard2,
                        contentColor = Color.White
                    )
                ) {

                    Text(
                        text = "EDIT PROFILE",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }

        // ---------------------------------------------------------
        // STATISTICS
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            StatCard(
                value = "24",
                label = "GAMES",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                value = "17",
                label = "WINS",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                value = "32",
                label = "GOALS",
                modifier = Modifier.weight(1f)
            )
        }

        // ---------------------------------------------------------
        // PLAYER PROFILE
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(28.dp))

        SectionTitle(text = "PLAYER PROFILE")

        Spacer(modifier = Modifier.height(12.dp))

        InfoCard {

            ProfileInfoRow(
                label = "Primary Position",
                value = position
            )

            Divider()

            ProfileInfoRow(
                label = "Secondary Position",
                value = secondaryPosition
            )

            Divider()

            ProfileInfoRow(
                label = "Playing Level",
                value = level
            )

            Divider()

            ProfileInfoRow(
                label = "Preferred Format",
                value = format
            )

            Divider()

            ProfileInfoRow(
                label = "Availability",
                value = availability
            )
        }

        // ---------------------------------------------------------
        // AI RECRUITMENT
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(28.dp))

        SectionTitle(text = "AI RECRUITMENT")

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aiRecruiterGlowingBorder(cornerRadius = 22.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(
                    if (recruitmentEnabled) {
                        PullpadamGreen
                    } else {
                        PullpadamCard
                    }
                )
                .clickable {
                    onRecruitment()
                }
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // AI icon
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(
                            if (recruitmentEnabled) {
                                Color.Black
                            } else {
                                PullpadamCard2
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "AI",
                        color = if (recruitmentEnabled) {
                            PullpadamGreen
                        } else {
                            Color.White
                        },
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = if (recruitmentEnabled) {
                            "AVAILABLE FOR RECRUITMENT"
                        } else {
                            "RECRUITMENT HIDDEN"
                        },
                        color = if (recruitmentEnabled) {
                            Color.Black
                        } else {
                            Color.White
                        },
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = if (recruitmentEnabled) {
                            "Teams can discover your profile."
                        } else {
                            "Your profile is hidden from teams."
                        },
                        color = if (recruitmentEnabled) {
                            Color(0xFF26301D)
                        } else {
                            PullpadamGray
                        },
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    )
                }

                Text(
                    text = "›",
                    color = if (recruitmentEnabled) {
                        Color.Black
                    } else {
                        PullpadamGreen
                    },
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }

        // ---------------------------------------------------------
        // QUICK ACTIONS
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(28.dp))

        SectionTitle(text = "QUICK ACTIONS")

        Spacer(modifier = Modifier.height(12.dp))

        QuickActionCard(
            icon = "⚽",
            title = "My Football Profile",
            subtitle = "Manage your playing information"
        )

        Spacer(modifier = Modifier.height(10.dp))

        QuickActionCard(
            icon = "🏆",
            title = "Match History",
            subtitle = "View your games and achievements"
        )

        Spacer(modifier = Modifier.height(10.dp))

        QuickActionCard(
            icon = "⚙",
            title = "Settings",
            subtitle = "Manage app preferences"
        )

        // ---------------------------------------------------------
        // FOOTER
        // ---------------------------------------------------------

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "PULLPADAM • WHERE THE GAME BEGINS",
            modifier = Modifier.fillMaxWidth(),
            color = PullpadamGray,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun SectionTitle(
    text: String
) {

    Text(
        text = text,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
        letterSpacing = 1.sp
    )
}


// =============================================================
// STAT CARD
// =============================================================

@Composable
private fun StatCard(
    value: String,
    label: String,
    modifier: Modifier
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(PullpadamCard)
            .padding(vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            color = PullpadamGreen,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color = PullpadamGray,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.8.sp
        )
    }
}


// =============================================================
// INFORMATION CARD
// =============================================================

@Composable
private fun InfoCard(
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PullpadamCard)
            .padding(
                horizontal = 18.dp,
                vertical = 8.dp
            ),
        content = content
    )
}


// =============================================================
// PROFILE INFORMATION ROW
// =============================================================

@Composable
private fun ProfileInfoRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            color = PullpadamGray,
            fontSize = 12.sp
        )

        Text(
            text = value,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// =============================================================
// DIVIDER
// =============================================================

@Composable
private fun Divider() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(PullpadamBorder)
    )
}


// =============================================================
// QUICK ACTION CARD
// =============================================================

@Composable
private fun QuickActionCard(
    icon: String,
    title: String,
    subtitle: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(PullpadamCard)
            .clickable {
                // Action can be connected later
            }
            .padding(17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Icon container
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(PullpadamCard2),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = icon,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                color = PullpadamGray,
                fontSize = 10.sp
            )
        }

        Text(
            text = "›",
            color = PullpadamGreen,
            fontSize = 24.sp
        )
    }
}


// =============================================================
// GET PROFILE INITIALS
// =============================================================

private fun getInitials(
    name: String
): String {

    val parts = name
        .trim()
        .split(" ")
        .filter {
            it.isNotEmpty()
        }

    return when {

        parts.isEmpty() -> {
            "P"
        }

        parts.size == 1 -> {
            parts[0]
                .take(2)
                .uppercase()
        }

        else -> {
            (
                    parts.first().first().toString() +
                            parts.last().first().toString()
                    ).uppercase()
        }
    }
}