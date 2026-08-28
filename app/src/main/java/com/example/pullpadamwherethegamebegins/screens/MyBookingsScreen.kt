package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import java.text.SimpleDateFormat
import java.util.Locale

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamGray = Color(0xFF9A9F9C)
private val PullpadamRed = Color(0xFFFF5C5C)
private val PullpadamDarkGreen = Color(0xFF26351F)


// =============================================================
// BOOKING DATA
// =============================================================

data class Booking(
    val turfName: String,
    val format: String,
    val session: String,
    val date: String,
    val time: String,
    val price: String,
    val bookingTimeMillis: Long = 0L,
    var cancelled: Boolean = false
)


// =============================================================
// MY BOOKINGS SCREEN
// =============================================================

@Composable
fun MyBookingsScreen(
    bookings: List<Booking>,
    onBookingCancelled: (Booking) -> Unit
) {

    var selectedFormat by remember {
        mutableStateOf("5v5")
    }

    var showCancelDialog by remember {
        mutableStateOf<Booking?>(null)
    }

    val filteredBookings =
        bookings.filter {
            it.format == selectedFormat
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .padding(20.dp)
    ) {

        // =====================================================
        // TITLE
        // =====================================================

        Text(
            text = "MY BOOKINGS",
            color = Color.White,
            fontSize = 27.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Manage your turf bookings",
            color = PullpadamGray,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================================
        // 5v5 / 7v7 SELECTOR
        // =====================================================

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FormatButton(
                text = "5v5",
                selected = selectedFormat == "5v5",
                onClick = {
                    selectedFormat = "5v5"
                }
            )

            FormatButton(
                text = "7v7",
                selected = selectedFormat == "7v7",
                onClick = {
                    selectedFormat = "7v7"
                }
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =====================================================
        // BOOKINGS
        // =====================================================

        if (filteredBookings.isEmpty()) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "⚽",
                        fontSize = 50.sp
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    Text(
                        text = "No $selectedFormat bookings",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Your confirmed bookings will appear here.",
                        color = PullpadamGray,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement =
                    Arrangement.spacedBy(15.dp)
            ) {

                items(
                    items = filteredBookings
                ) { booking ->

                    BookingCard(
                        booking = booking,
                        onCancel = {
                            showCancelDialog = booking
                        }
                    )
                }
            }
        }
    }


    // =========================================================
    // CANCEL CONFIRMATION DIALOG
    // =========================================================

    showCancelDialog?.let { booking ->

        AlertDialog(

            onDismissRequest = {
                showCancelDialog = null
            },

            title = {

                Text(
                    text = "Cancel Booking?"
                )
            },

            text = {

                Text(
                    text =
                        "Are you sure you want to cancel your " +
                                "${booking.format} ${booking.session.lowercase()} " +
                                "booking at ${booking.turfName}?"
                )
            },

            confirmButton = {

                Button(

                    onClick = {

                        onBookingCancelled(booking)

                        showCancelDialog = null
                    },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = PullpadamRed,
                        contentColor = Color.White
                    )
                ) {

                    Text(
                        text = "CANCEL BOOKING"
                    )
                }
            },

            dismissButton = {

                Button(
                    onClick = {
                        showCancelDialog = null
                    }
                ) {

                    Text(
                        text = "KEEP BOOKING"
                    )
                }
            }
        )
    }
}


// =============================================================
// FORMAT BUTTON
// =============================================================

@Composable
private fun RowScope.FormatButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .weight(1f)
            .height(50.dp)
            .clip(
                RoundedCornerShape(14.dp)
            )
            .background(
                if (selected) {
                    PullpadamGreen
                } else {
                    PullpadamCard
                }
            )
            .clickable {
                onClick()
            },

        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,

            color =
                if (selected) {
                    Color.Black
                } else {
                    Color.White
                },

            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// =============================================================
// BOOKING CARD
// =============================================================

@Composable
private fun BookingCard(
    booking: Booking,
    onCancel: () -> Unit
) {

    // =========================================================
    // GET EXACT BOOKING DATE + TIME
    // =========================================================

    val bookingDateTime = remember(
        booking.date,
        booking.time
    ) {

        try {

            val formatter =
                SimpleDateFormat(
                    "dd MMM yyyy hh:mm a",
                    Locale.getDefault()
                )

            formatter.parse(
                "${booking.date} ${booking.time}"
            )?.time ?: 0L

        } catch (e: Exception) {

            0L
        }
    }


    // =========================================================
    // 24 HOUR CANCELLATION RULE
    // =========================================================

    val twentyFourHours =
        24L * 60L * 60L * 1000L

    val cancellationDeadline =
        bookingDateTime - twentyFourHours

    val currentTime =
        System.currentTimeMillis()

    /*
     * Cancellation is allowed ONLY while:
     *
     * current time < cancellation deadline
     *
     * Example:
     *
     * Booking:
     * 19 Aug 2026 08:00 PM
     *
     * Deadline:
     * 18 Aug 2026 08:00 PM
     *
     * 18 Aug 07:59 PM -> ALLOWED
     * 18 Aug 08:00 PM -> NOT ALLOWED
     */

    val canCancel =
        !booking.cancelled &&
                bookingDateTime > 0L &&
                currentTime < cancellationDeadline


    // =========================================================
    // CARD
    // =========================================================

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(PullpadamCard)
            .padding(18.dp)
    ) {

        // =====================================================
        // FORMAT
        // =====================================================

        Text(
            text = booking.format,
            color = PullpadamGreen,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        // =====================================================
        // SESSION
        // =====================================================

        Text(
            text =
                if (booking.session == "Morning") {
                    "🌅 Morning"
                } else {
                    "🌙 Night"
                },

            color = PullpadamGray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // =====================================================
        // TURF
        // =====================================================

        Text(
            text = booking.turfName,
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // =====================================================
        // DATE
        // =====================================================

        Text(
            text = "📅 ${booking.date}",
            color = PullpadamGray,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        // =====================================================
        // TIME
        // =====================================================

        Text(
            text = "🕐 ${booking.time}",
            color = PullpadamGray,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(7.dp)
        )

        // =====================================================
        // PRICE
        // =====================================================

        Text(
            text = "💰 ${booking.price}",
            color = PullpadamGreen,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // =====================================================
        // STATUS
        // =====================================================

        Text(
            text =
                if (booking.cancelled) {
                    "CANCELLED"
                } else {
                    "CONFIRMED ✓"
                },

            color =
                if (booking.cancelled) {
                    PullpadamRed
                } else {
                    PullpadamGreen
                },

            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold
        )


        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        if (!booking.cancelled) {

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            if (canCancel) {

                Button(

                    onClick = {
                        onCancel()
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),

                    shape = RoundedCornerShape(13.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = PullpadamRed,
                        contentColor = Color.White
                    )
                ) {

                    Text(
                        text = "CANCEL BOOKING",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Cancellation available until 24 hours before your slot.",
                    color = PullpadamGray,
                    fontSize = 10.sp,
                    lineHeight = 15.sp
                )

            } else {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(12.dp)
                        )
                        .background(
                            Color(0xFF211818)
                        )
                        .padding(12.dp)
                ) {

                    Text(
                        text =
                            "Cancellation unavailable within 24 hours of the booking.",

                        color = PullpadamGray,
                        fontSize = 11.sp,
                        lineHeight = 17.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}