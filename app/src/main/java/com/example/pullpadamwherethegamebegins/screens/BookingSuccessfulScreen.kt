package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pullpadamwherethegamebegins.R
import kotlinx.coroutines.delay

private val Background = Color(0xFF0B0D0C)
private val Green = Color(0xFFB6FF3B)
private val Card = Color(0xFF151917)
private val Gray = Color(0xFF9A9F9C)

@Composable
fun BookingSuccessfulScreen(
    turfName: String,
    date: String,
    time: String,
    price: String,
    onGoHome: () -> Unit
) {

    var animationFinished by remember {
        mutableStateOf(false)
    }

    var showDetails by remember {
        mutableStateOf(false)
    }

    /*
     * ONE animation value controls EVERYTHING.
     *
     * 0f = beginning
     * 1f = end
     */
    var progress by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(Unit) {

        val frameTime = 16L
        val totalDuration = 1650L

        val startTime = System.currentTimeMillis()

        while (true) {

            val elapsed =
                System.currentTimeMillis() - startTime

            val raw =
                (elapsed.toFloat() /
                        totalDuration.toFloat())
                    .coerceIn(0f, 1f)

            progress = raw

            if (raw >= 1f) {
                break
            }

            delay(frameTime)
        }

        animationFinished = true

        delay(120)

        showDetails = true
    }


    /*
     * ---------------------------------------------------------
     * POSITION
     * ---------------------------------------------------------
     *
     * Start:
     * bottom-right
     *
     * End of travel:
     * centre
     */

    val xPosition: Float

    val yPosition: Float

    if (progress < 0.43f) {

        /*
         * 0 → 43%
         *
         * Bottom-right → centre
         */

        val p =
            progress / 0.43f

        val smooth =
            FastOutSlowInEasing
                .transform(p)

        xPosition =
            0.78f * (1f - smooth)

        yPosition =
            0.72f * (1f - smooth)

    } else {

        /*
         * After reaching centre,
         * stay centred.
         */

        xPosition = 0f
        yPosition = 0f
    }


    /*
     * ---------------------------------------------------------
     * SCALE
     * ---------------------------------------------------------
     */

    val ballScale: Float

    if (progress < 0.43f) {

        /*
         * During travel:
         * small gradual size increase.
         */

        val p =
            progress / 0.43f

        val smooth =
            FastOutSlowInEasing
                .transform(p)

        ballScale =
            0.50f +
                    (0.62f * smooth)

    } else if (progress < 0.85f) {

        /*
         * Centre → viewer
         */

        val p =
            (progress - 0.43f) /
                    (0.85f - 0.43f)

        val smooth =
            FastOutSlowInEasing
                .transform(p)

        ballScale =
            1.12f +
                    (3.8f * smooth)

    } else {

        /*
         * Final impact.
         */

        val p =
            (progress - 0.85f) /
                    (1f - 0.85f)

        val smooth =
            FastOutSlowInEasing
                .transform(p)

        ballScale =
            4.92f +
                    (5.5f * smooth)
    }


    /*
     * ---------------------------------------------------------
     * ROTATION
     * ---------------------------------------------------------
     *
     * Continuous and steady.
     */

    val rotation =
        progress * 2160f


    /*
     * ---------------------------------------------------------
     * ALPHA
     * ---------------------------------------------------------
     */

    val ballAlpha =
        if (progress < 0.94f) {

            1f

        } else {

            val p =
                (progress - 0.94f) /
                        0.06f

            1f - p
        }


    // =========================================================
    // SCREEN
    // =========================================================

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {


        // =====================================================
        // FOOTBALL
        // =====================================================

        if (!animationFinished) {

            Image(

                painter =
                    painterResource(
                        id =
                            R.drawable.pullpadam_football
                    ),

                contentDescription =
                    "Football",

                contentScale =
                    ContentScale.Fit,

                modifier =
                    Modifier
                        .size(180.dp)

                        .graphicsLayer {

                            /*
                             * Position
                             */

                            translationX =
                                xPosition *
                                        220.dp
                                            .toPx()

                            translationY =
                                yPosition *
                                        400.dp
                                            .toPx()

                            /*
                             * Scale
                             */

                            scaleX =
                                ballScale

                            scaleY =
                                ballScale

                            /*
                             * Rotation
                             */

                            rotationZ =
                                rotation

                            /*
                             * Fade
                             */

                            alpha =
                                ballAlpha
                        }

                        .align(
                            Alignment.Center
                        )
            )
        }


        // =====================================================
        // SUCCESS SCREEN
        // =====================================================

        AnimatedVisibility(

            visible =
                animationFinished,

            enter =
                fadeIn(
                    animationSpec =
                        tween(
                            durationMillis =
                                450
                        )
                ),

            modifier =
                Modifier.fillMaxSize()
        ) {

            Column(

                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(
                            Background
                        )
                        .padding(
                            horizontal = 22.dp
                        ),

                horizontalAlignment =
                    Alignment.CenterHorizontally,

                verticalArrangement =
                    Arrangement.Center
            ) {


                // =================================================
                // CHECK
                // =================================================

                Box(

                    modifier =
                        Modifier
                            .size(78.dp)
                            .clip(
                                CircleShape
                            )
                            .background(
                                Green
                            ),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(

                        text =
                            "✓",

                        color =
                            Color.Black,

                        fontSize =
                            43.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )
                }


                Spacer(
                    modifier =
                        Modifier.height(24.dp)
                )


                // =================================================
                // TITLE
                // =================================================

                Text(

                    text =
                        "BOOKING",

                    color =
                        Color.White,

                    fontSize =
                        28.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        2.sp
                )


                Text(

                    text =
                        "SUCCESSFUL!",

                    color =
                        Green,

                    fontSize =
                        28.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        1.5.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(9.dp)
                )


                Text(

                    text =
                        "Your game is confirmed.",

                    color =
                        Gray,

                    fontSize =
                        13.sp
                )


                Spacer(
                    modifier =
                        Modifier.height(28.dp)
                )


                // =================================================
                // BOOKING DETAILS
                // =================================================

                AnimatedVisibility(

                    visible =
                        showDetails,

                    enter =
                        fadeIn(
                            animationSpec =
                                tween(
                                    durationMillis =
                                        400
                                )
                        )
                ) {

                    Column(

                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        20.dp
                                    )
                                )
                                .background(
                                    Card
                                )
                                .padding(
                                    20.dp
                                )
                    ) {

                        Text(

                            text =
                                turfName,

                            color =
                                Color.White,

                            fontSize =
                                19.sp,

                            fontWeight =
                                FontWeight.Bold
                        )


                        Spacer(
                            modifier =
                                Modifier.height(15.dp)
                        )


                        BookingInfoRow(
                            label =
                                "DATE",

                            value =
                                date
                        )


                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )


                        BookingInfoRow(
                            label =
                                "TIME",

                            value =
                                time
                        )


                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )


                        BookingInfoRow(
                            label =
                                "PRICE",

                            value =
                                price,

                            highlight =
                                true
                        )
                    }
                }


                Spacer(
                    modifier =
                        Modifier.height(25.dp)
                )


                // =================================================
                // HOME
                // =================================================

                Button(

                    onClick =
                        onGoHome,

                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(54.dp),

                    shape =
                        RoundedCornerShape(
                            16.dp
                        ),

                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor =
                                Green,

                            contentColor =
                                Color.Black
                        )
                ) {

                    Text(

                        text =
                            "BACK TO HOME",

                        fontSize =
                            13.sp,

                        fontWeight =
                            FontWeight.ExtraBold,

                        letterSpacing =
                            1.sp
                    )
                }


                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )


                // =================================================
                // VIEW BOOKINGS
                // =================================================

                Box(

                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                            .clip(
                                RoundedCornerShape(
                                    16.dp
                                )
                            )
                            .clickable {
                                onGoHome()
                            },

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(

                        text =
                            "VIEW MY BOOKINGS",

                        color =
                            Green,

                        fontSize =
                            13.sp,

                        fontWeight =
                            FontWeight.Bold,

                        textAlign =
                            TextAlign.Center
                    )
                }
            }
        }
    }
}


// =============================================================
// BOOKING INFO ROW
// =============================================================

@Composable
private fun BookingInfoRow(
    label: String,
    value: String,
    highlight: Boolean = false
) {

    Row(

        modifier =
            Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.SpaceBetween,

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Text(

            text =
                label,

            color =
                Gray,

            fontSize =
                10.sp,

            fontWeight =
                FontWeight.Bold,

            letterSpacing =
                1.sp
        )


        Text(

            text =
                value,

            color =
                if (highlight)
                    Green
                else
                    Color.White,

            fontSize =
                12.sp,

            fontWeight =
                FontWeight.SemiBold
        )
    }
}