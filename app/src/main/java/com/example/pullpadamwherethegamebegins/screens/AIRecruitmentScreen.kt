package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// =============================================================
// RECRUITER CARD ANIMATED GLOWING BORDER
// =============================================================

fun Modifier.aiRecruiterGlowingBorder(
    cornerRadius: Dp = 23.dp,
    borderWidth: Dp = 2.5.dp,
    durationMs: Int = 3000
): Modifier = composed {
    val infiniteTransition = rememberInfiniteTransition(label = "recruiterGlowTransition")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMs, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "recruiterGlowAngle"
    )

    this.drawWithCache {
        val cornerRadiusPx = cornerRadius.toPx()
        val borderWidthPx = borderWidth.toPx()

        val rect = Rect(
            left = borderWidthPx / 2f,
            top = borderWidthPx / 2f,
            right = size.width - borderWidthPx / 2f,
            bottom = size.height - borderWidthPx / 2f
        )

        val borderPath = Path().apply {
            addRoundRect(RoundRect(rect, CornerRadius(cornerRadiusPx, cornerRadiusPx)))
        }

        val glowBrush = Brush.sweepGradient(
            colors = listOf(
                Color(0x1AB6FF3B),
                Color(0x40B6FF3B),
                Color(0xFFE2FF82),
                Color(0xFFB6FF3B),
                Color(0x30B6FF3B),
                Color(0x05B6FF3B)
            ),
            center = Offset(size.width / 2f, size.height / 2f)
        )

        onDrawWithContent {
            drawContent()
            rotate(degrees = angle, pivot = Offset(size.width / 2f, size.height / 2f)) {
                drawPath(
                    path = borderPath,
                    brush = glowBrush,
                    style = Stroke(width = borderWidthPx, cap = StrokeCap.Round)
                )
            }
        }
    }
}


// =============================================================
// PULLPADAM COLORS
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
// AI RECRUITMENT SCREEN
// =============================================================

@Composable
fun AIRecruitmentScreen(
    initiallyEnabled: Boolean = true,
    onSave: (Boolean) -> Unit,
    onBack: () -> Unit
) {

    var recruitmentEnabled by remember {
        mutableStateOf(initiallyEnabled)
    }


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
                    .clip(
                        RoundedCornerShape(11.dp)
                    )
                    .background(
                        PullpadamCard
                    )
                    .clickable {
                        onBack()
                    }
                    .padding(
                        horizontal = 13.dp,
                        vertical = 10.dp
                    ),

                contentAlignment =
                    Alignment.Center
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
                    text = "PULLPADAM AI",
                    color = PullpadamGreen,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )

                Spacer(
                    modifier = Modifier.height(3.dp)
                )

                Text(
                    text = "AI RECRUITMENT",
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
        // MAIN STATUS CARD (WITH ANIMATED GLOWING BORDER)
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aiRecruiterGlowingBorder(cornerRadius = 23.dp)
                .clip(
                    RoundedCornerShape(23.dp)
                )
                .background(
                    if (recruitmentEnabled)
                        PullpadamSelected
                    else
                        PullpadamCard
                )
                .padding(20.dp)
        ) {

            Column {

                Text(
                    text = "YOUR RECRUITMENT STATUS",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.9.sp
                )


                Spacer(
                    modifier = Modifier.height(15.dp)
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween,
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Column(
                        modifier =
                            Modifier.weight(1f)
                    ) {

                        Text(
                            text =
                                if (recruitmentEnabled)
                                    "AVAILABLE"
                                else
                                    "HIDDEN",

                            color = Color.White,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.ExtraBold
                        )


                        Spacer(
                            modifier =
                                Modifier.height(5.dp)
                        )


                        Text(
                            text =
                                if (recruitmentEnabled)
                                    "Teams can discover your profile."
                                else
                                    "Teams cannot discover you.",

                            color = PullpadamGray,
                            fontSize = 10.sp,
                            lineHeight = 15.sp
                        )
                    }


                    Box(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(13.dp)
                            )
                            .background(
                                if (recruitmentEnabled)
                                    PullpadamGreen
                                else
                                    Color(0xFF303532)
                            )
                            .padding(
                                horizontal = 13.dp,
                                vertical = 9.dp
                            ),

                        contentAlignment =
                            Alignment.Center
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

                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }


                Spacer(
                    modifier =
                        Modifier.height(18.dp)
                )


                // =================================================
                // TOGGLE
                // =================================================

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(
                            RoundedCornerShape(14.dp)
                        )
                        .background(
                            if (recruitmentEnabled)
                                PullpadamGreen
                            else
                                Color(0xFF252A27)
                        )
                        .clickable {

                            recruitmentEnabled =
                                !recruitmentEnabled
                        },

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text =
                            if (recruitmentEnabled)
                                "TURN OFF RECRUITMENT"
                            else
                                "TURN ON RECRUITMENT",

                        color =
                            if (recruitmentEnabled)
                                Color.Black
                            else
                                Color.White,

                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.7.sp
                    )
                }
            }
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // HOW IT WORKS
        // =====================================================

        Text(
            text = "HOW IT WORKS",
            color = PullpadamGreen,
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.8.sp
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        RecruitmentStep(
            number = "01",
            title = "Turn recruitment ON",
            description =
                "Your profile becomes eligible for AI recruitment."
        )


        Spacer(
            modifier =
                Modifier.height(9.dp)
        )


        RecruitmentStep(
            number = "02",
            title = "AI finds matching teams",
            description =
                "Pullpadam AI compares your profile with team requirements."
        )


        Spacer(
            modifier =
                Modifier.height(9.dp)
        )


        RecruitmentStep(
            number = "03",
            title = "Teams can invite you",
            description =
                "A suitable team can send you a recruitment invitation."
        )


        Spacer(
            modifier =
                Modifier.height(9.dp)
        )


        RecruitmentStep(
            number = "04",
            title = "You decide",
            description =
                "Your profile is never automatically added to a team."
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // PRIVACY CARD
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(
                    PullpadamCard
                )
                .padding(17.dp)
        ) {

            Column {

                Text(
                    text = "YOUR PRIVACY",
                    color = PullpadamGreen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.8.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )


                Text(
                    text =
                        "Only players who enable AI recruitment " +
                                "can appear in Find a Player results. " +
                                "You remain in control of accepting or " +
                                "rejecting invitations.",

                    color = PullpadamGray,
                    fontSize = 10.sp,
                    lineHeight = 16.sp
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )


        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button(
            onClick = {

                onSave(
                    recruitmentEnabled
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp),

            shape =
                RoundedCornerShape(17.dp),

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
                    "SAVE RECRUITMENT SETTINGS",

                fontSize =
                    11.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    0.7.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(15.dp)
        )


        Text(
            text =
                "You can change this setting at any time.",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                9.sp
        )


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )
    }
}


// =============================================================
// RECRUITMENT STEP
// =============================================================

@Composable
private fun RecruitmentStep(
    number: String,
    title: String,
    description: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(
                PullpadamCard
            )
            .padding(15.dp),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(
                    PullpadamSelected
                )
                .padding(
                    horizontal = 10.dp,
                    vertical = 8.dp
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                text = number,
                color = PullpadamGreen,
                fontSize = 9.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }


        Spacer(
            modifier =
                Modifier.width(12.dp)
        )


        Column {

            Text(
                text = title,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(3.dp)
            )


            Text(
                text = description,
                color = PullpadamGray,
                fontSize = 9.sp,
                lineHeight = 14.sp
            )
        }
    }
}