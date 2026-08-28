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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun BookingConfirmationScreen(
    turfName: String,
    date: String,
    time: String,
    format: String,
    session: String,
    price: String,
    onConfirmBooking: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // =====================================================
        // TITLE
        // =====================================================

        Text(
            text = "BOOKING CONFIRMATION",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Review your booking details",
            color = PullpadamGray,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // =====================================================
        // BOOKING CARD
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = PullpadamCard,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {

            Column {

                // =================================================
                // TURF
                // =================================================

                Text(
                    text = "TURF",
                    color = PullpadamGray,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = turfName,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // =================================================
                // FORMAT
                // =================================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "FORMAT",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )

                    Text(
                        text = format,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                // =================================================
                // SESSION
                // =================================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "SESSION",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )

                    Text(
                        text = if (session == "Morning") {
                            "🌅 Morning"
                        } else {
                            "🌙 Night"
                        },
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                // =================================================
                // DATE
                // =================================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "DATE",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )

                    Text(
                        text = date,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                // =================================================
                // TIME
                // =================================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "TIME",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )

                    Text(
                        text = time,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                // =================================================
                // PRICE
                // =================================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "PRICE",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )

                    Text(
                        text = price,
                        color = PullpadamGreen,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // INFORMATION
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF26351F),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {

            Text(
                text = "Your turf will be reserved after you confirm this booking.",
                color = Color.White,
                fontSize = 13.sp,
                lineHeight = 19.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        // =====================================================
        // CONFIRM BUTTON
        // =====================================================

        Button(
            onClick = {
                onConfirmBooking()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),

            shape = RoundedCornerShape(17.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = PullpadamGreen,
                contentColor = Color.Black
            )
        ) {

            Text(
                text = "CONFIRM BOOKING",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.sp
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "You can review your booking before confirming.",
            color = PullpadamGray,
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}