package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


// =============================================================
// COLORS
// =============================================================

private val PullpadamBackground =
    Color(0xFF0B0D0C)

private val PullpadamGreen =
    Color(0xFFB6FF3B)

private val PullpadamCard =
    Color(0xFF151917)

private val PullpadamGray =
    Color(0xFF9A9F9C)

private val PullpadamBooked =
    Color(0xFF252A27)

private val PullpadamBookedText =
    Color(0xFFB6FF3B)


// =============================================================
// TURF DETAILS SCREEN
// =============================================================

@Composable
fun TurfDetailsScreen(
    turf: Turf,
    onBookNow: (
        date: String,
        time: String,
        format: String,
        session: String
    ) -> Unit
) {

    var selectedFormat by remember {
        mutableStateOf("")
    }

    var selectedDate by remember {
        mutableStateOf("")
    }

    var selectedSession by remember {
        mutableStateOf("")
    }

    var selectedTime by remember {
        mutableStateOf("")
    }

    var showBookedAlert by remember {
        mutableStateOf(false)
    }


    // =========================================================
    // TURF IMAGE DATA
    // =========================================================

    val turfImages = when (turf.name) {

        "Green Arena" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf1,
                com.example.pullpadamwherethegamebegins.R.drawable.turf2
            )

        "KickZone Football" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf3,
                com.example.pullpadamwherethegamebegins.R.drawable.turf4
            )

        "Goal Masters" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf5,
                com.example.pullpadamwherethegamebegins.R.drawable.turf6
            )

        "Football Hub" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf7,
                com.example.pullpadamwherethegamebegins.R.drawable.turf8
            )

        "Pro Arena" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf9,
                com.example.pullpadamwherethegamebegins.R.drawable.turf10
            )

        "City Football" ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf11,
                com.example.pullpadamwherethegamebegins.R.drawable.turf12
            )

        else ->
            listOf(
                com.example.pullpadamwherethegamebegins.R.drawable.turf1,
                com.example.pullpadamwherethegamebegins.R.drawable.turf2
            )
    }


    // =========================================================
    // LOCATION DATA
    // =========================================================

    val location = when (turf.name) {

        "Green Arena" ->
            "Talap, Kannur, Kerala"

        "KickZone Football" ->
            "Thavakkara, Kannur, Kerala"

        "Goal Masters" ->
            "Pallikunnu, Kannur, Kerala"

        "Football Hub" ->
            "Chalad, Kannur, Kerala"

        "Pro Arena" ->
            "Valapattanam, Kannur, Kerala"

        "City Football" ->
            "South Bazar, Kannur, Kerala"

        else ->
            "Kannur, Kerala"
    }


    val address = when (turf.name) {

        "Green Arena" ->
            "Near Talap Junction, Kannur"

        "KickZone Football" ->
            "Opposite Thavakkara Bus Stand"

        "Goal Masters" ->
            "Pallikunnu Main Road, Kannur"

        "Football Hub" ->
            "Chalad Football Ground Road"

        "Pro Arena" ->
            "Near Valapattanam Railway Station"

        "City Football" ->
            "South Bazar Sports Complex"

        else ->
            "Kannur, Kerala"
    }


    val description = when (turf.name) {

        "Green Arena" ->
            "A modern football turf with a high-quality playing surface. Perfect for evening matches, friendly games and regular football training."

        "KickZone Football" ->
            "A popular 5-a-side football venue offering a compact and energetic playing environment for friends and local teams."

        "Goal Masters" ->
            "A spacious football facility suitable for 7-a-side matches and larger competitive games with excellent floodlights."

        "Football Hub" ->
            "A convenient community football turf designed for quick matches, training sessions and weekend games."

        "Pro Arena" ->
            "A premium football venue with a professional-style playing surface, strong lighting and comfortable player facilities."

        "City Football" ->
            "A centrally located football turf that is ideal for regular matches, team practice and competitive football."

        else ->
            "A quality football turf designed for players who want a great game experience."
    }


    // =========================================================
    // FORMATS
    // =========================================================

    val availableFormats =
        getAvailableFormats(turf.type)


    // =========================================================
    // DATES
    // =========================================================

    val dates =
        remember {
            generateNextSevenDates()
        }


    // =========================================================
    // MORNING SLOTS
    // =========================================================

    val morningSlots =
        listOf(
            "06:00 AM",
            "07:00 AM",
            "08:00 AM",
            "09:00 AM",
            "10:00 AM",
            "11:00 AM"
        )


    // =========================================================
    // NIGHT SLOTS
    // =========================================================

    val nightSlots =
        listOf(
            "03:00 PM",
            "04:00 PM",
            "05:00 PM",
            "06:00 PM",
            "07:00 PM",
            "08:00 PM",
            "09:00 PM",
            "10:00 PM",
            "11:00 PM"
        )


    // =========================================================
    // MAIN SCREEN
    // =========================================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                PullpadamBackground
            )
            .verticalScroll(
                rememberScrollState()
            )
    ) {


        // =====================================================
        // IMAGE GALLERY
        // =====================================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                )
                .padding(
                    top = 10.dp,
                    start = 12.dp,
                    end = 12.dp
                ),

            horizontalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            turfImages.forEach { imageRes ->

                Image(

                    painter =
                        painterResource(
                            id = imageRes
                        ),

                    contentDescription =
                        "${turf.name} photo",

                    modifier = Modifier
                        .width(330.dp)
                        .height(220.dp)
                        .clip(
                            RoundedCornerShape(
                                22.dp
                            )
                        ),

                    contentScale =
                        ContentScale.Crop
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // TURF INFORMATION
        // =====================================================

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
        ) {


            // =================================================
            // TURF NAME
            // =================================================

            Text(
                text =
                    turf.name,

                color =
                    Color.White,

                fontSize =
                    27.sp,

                fontWeight =
                    FontWeight.ExtraBold
            )


            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )


            // =================================================
            // RATING + DISTANCE
            // =================================================

            Text(
                text =
                    "⭐ ${turf.rating}   •   ${turf.distance}",

                color =
                    PullpadamGray,

                fontSize =
                    13.sp
            )


            Spacer(
                modifier =
                    Modifier.height(8.dp)
            )


            // =================================================
            // PRICE
            // =================================================

            Text(
                text =
                    turf.price,

                color =
                    PullpadamGreen,

                fontSize =
                    18.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // PLAYING FORMAT
            // =================================================

            Text(
                text =
                    "PLAYING FORMAT",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                availableFormats.forEach { format ->

                    FormatChip(

                        text =
                            format,

                        selected =
                            selectedFormat == format,

                        onClick = {

                            selectedFormat =
                                format

                            selectedTime =
                                ""
                        }
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // FACILITIES
            // =================================================

            Text(
                text =
                    "FACILITIES",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )


            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                FacilityCard(
                    icon = "🚿",
                    text = "Showers"
                )

                FacilityCard(
                    icon = "🅿️",
                    text = "Parking"
                )

                FacilityCard(
                    icon = "💡",
                    text = "Floodlights"
                )
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // LOCATION
            // =================================================

            Text(
                text =
                    "LOCATION",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            18.dp
                        )
                    )
                    .background(
                        PullpadamCard
                    )
                    .padding(
                        18.dp
                    )
            ) {

                Column {

                    Text(
                        text =
                            "📍 $location",

                        color =
                            Color.White,

                        fontSize =
                            14.sp,

                        fontWeight =
                            FontWeight.Bold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(8.dp)
                    )


                    Text(
                        text =
                            address,

                        color =
                            PullpadamGray,

                        fontSize =
                            12.sp
                    )


                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )


                    Text(
                        text =
                            "Easy access • Parking available",

                        color =
                            PullpadamGreen,

                        fontSize =
                            11.sp,

                        fontWeight =
                            FontWeight.Bold
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // ABOUT THIS TURF
            // =================================================

            Text(
                text =
                    "ABOUT THIS TURF",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Text(
                text =
                    description,

                color =
                    PullpadamGray,

                fontSize =
                    13.sp,

                lineHeight =
                    21.sp
            )


            Spacer(
                modifier =
                    Modifier.height(30.dp)
            )


            // =================================================
            // SELECT DATE
            // =================================================

            Text(
                text =
                    "SELECT DATE",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(
                        rememberScrollState()
                    ),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                dates.forEach { dateInfo ->

                    DateCard(

                        day =
                            dateInfo.day,

                        date =
                            dateInfo.date,

                        month =
                            dateInfo.month,

                        selected =
                            selectedDate ==
                                    dateInfo.fullDate,

                        onClick = {

                            selectedDate =
                                dateInfo.fullDate

                            selectedTime =
                                ""
                        }
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // SELECT SESSION
            // =================================================

            Text(
                text =
                    "SELECT SESSION",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                SessionButton(
                    text =
                        "🌅 MORNING",

                    selected =
                        selectedSession ==
                                "Morning",

                    onClick = {

                        selectedSession =
                            "Morning"

                        selectedTime =
                            ""
                    }
                )


                SessionButton(
                    text =
                        "🌙 NIGHT",

                    selected =
                        selectedSession ==
                                "Night",

                    onClick = {

                        selectedSession =
                            "Night"

                        selectedTime =
                            ""
                    }
                )
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // SELECT TIME
            // =================================================

            Text(
                text =
                    "SELECT TIME",

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(10.dp)
            )


            if (
                selectedFormat.isEmpty() ||
                selectedDate.isEmpty() ||
                selectedSession.isEmpty()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(
                            RoundedCornerShape(
                                15.dp
                            )
                        )
                        .background(
                            PullpadamCard
                        ),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text =
                            "Select format, date and session first",

                        color =
                            PullpadamGray,

                        fontSize =
                            12.sp,

                        textAlign =
                            TextAlign.Center
                    )
                }

            } else {

                val slots =
                    if (
                        selectedSession ==
                        "Morning"
                    ) {
                        morningSlots
                    } else {
                        nightSlots
                    }


                Column(
                    modifier =
                        Modifier.fillMaxWidth(),

                    verticalArrangement =
                        Arrangement.spacedBy(10.dp)
                ) {

                    slots
                        .chunked(3)
                        .forEach { rowSlots ->

                            Row(
                                modifier =
                                    Modifier.fillMaxWidth(),

                                horizontalArrangement =
                                    Arrangement.spacedBy(8.dp)
                            ) {

                                rowSlots.forEach { time ->

                                    val isBooked =
                                        !BookingStore
                                            .isSlotAvailable(

                                                turfName =
                                                    turf.name,

                                                format =
                                                    selectedFormat,

                                                date =
                                                    selectedDate,

                                                time =
                                                    time
                                            )


                                    TimeSlot(

                                        time =
                                            time,

                                        selected =
                                            selectedTime ==
                                                    time,

                                        booked =
                                            isBooked,

                                        onClick = {

                                            if (isBooked) {

                                                showBookedAlert =
                                                    true

                                            } else {

                                                selectedTime =
                                                    time
                                            }
                                        }
                                    )
                                }


                                if (
                                    rowSlots.size < 3
                                ) {

                                    repeat(
                                        3 -
                                                rowSlots.size
                                    ) {

                                        Spacer(
                                            modifier =
                                                Modifier.width(
                                                    103.dp
                                                )
                                        )
                                    }
                                }
                            }
                        }
                }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // BOOK BUTTON
            // =================================================

            val canBook =
                selectedFormat.isNotEmpty() &&
                        selectedDate.isNotEmpty() &&
                        selectedSession.isNotEmpty() &&
                        selectedTime.isNotEmpty()


            Button(

                onClick = {

                    if (canBook) {

                        onBookNow(

                            selectedDate,

                            selectedTime,

                            selectedFormat,

                            selectedSession
                        )
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),

                shape =
                    RoundedCornerShape(
                        17.dp
                    ),

                colors =
                    ButtonDefaults.buttonColors(

                        containerColor =
                            if (canBook) {
                                PullpadamGreen
                            } else {
                                PullpadamCard
                            },

                        contentColor =
                            if (canBook) {
                                Color.Black
                            } else {
                                PullpadamGray
                            }
                    )
            ) {

                Text(

                    text =
                        if (canBook) {
                            "BOOK NOW"
                        } else {
                            "SELECT ALL OPTIONS"
                        },

                    fontSize =
                        14.sp,

                    fontWeight =
                        FontWeight.ExtraBold,

                    letterSpacing =
                        1.sp
                )
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )
        }
    }


    // =========================================================
    // BOOKED SLOT ALERT
    // =========================================================

    if (showBookedAlert) {

        AlertDialog(

            onDismissRequest = {

                showBookedAlert =
                    false
            },

            containerColor =
                Color.Black,

            title = {

                Text(

                    text =
                        "Slot Booked",

                    color =
                        PullpadamGreen,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            },

            text = {

                Text(

                    text =
                        "This slot is already booked. Try a different slot.",

                    color =
                        Color.White
                )
            },

            confirmButton = {

                TextButton(

                    onClick = {

                        showBookedAlert =
                            false
                    }
                ) {

                    Text(

                        text =
                            "OK",

                        color =
                            PullpadamGreen,

                        fontWeight =
                            FontWeight.Bold
                    )
                }
            }
        )
    }
}


// =============================================================
// TIME SLOT
// =============================================================

@Composable
private fun TimeSlot(
    time: String,
    selected: Boolean,
    booked: Boolean,
    onClick: () -> Unit
) {

    Box(

        modifier = Modifier
            .width(103.dp)
            .height(52.dp)
            .clip(
                RoundedCornerShape(
                    13.dp
                )
            )
            .background(

                when {

                    booked ->
                        PullpadamBooked

                    selected ->
                        PullpadamGreen

                    else ->
                        PullpadamCard
                }
            )
            .clickable {

                onClick()
            },

        contentAlignment =
            Alignment.Center
    ) {

        Column(

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(

                text =
                    time,

                color = when {

                    booked ->
                        PullpadamBookedText

                    selected ->
                        Color.Black

                    else ->
                        Color.White
                },

                fontSize =
                    11.sp,

                fontWeight =
                    FontWeight.Bold
            )


            if (booked) {

                Spacer(
                    modifier =
                        Modifier.height(2.dp)
                )

                Text(

                    text =
                        "BOOKED",

                    color =
                        PullpadamBookedText,

                    fontSize =
                        7.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }
        }
    }
}


// =============================================================
// FORMAT CHIP
// =============================================================

@Composable
private fun FormatChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(

        modifier = Modifier
            .width(140.dp)
            .height(45.dp)
            .clip(
                RoundedCornerShape(
                    13.dp
                )
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

        contentAlignment =
            Alignment.Center
    ) {

        Text(

            text =
                text,

            color =
                if (selected) {
                    Color.Black
                } else {
                    PullpadamGreen
                },

            fontSize =
                13.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// SESSION BUTTON
// =============================================================

@Composable
private fun SessionButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(

        modifier = Modifier
            .width(155.dp)
            .height(50.dp)
            .clip(
                RoundedCornerShape(
                    14.dp
                )
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

        contentAlignment =
            Alignment.Center
    ) {

        Text(

            text =
                text,

            color =
                if (selected) {
                    Color.Black
                } else {
                    Color.White
                },

            fontSize =
                11.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// DATE DATA
// =============================================================

private data class DateInfo(

    val day: String,

    val date: String,

    val month: String,

    val fullDate: String
)


// =============================================================
// GENERATE NEXT 7 DAYS
// =============================================================

private fun generateNextSevenDates():
        List<DateInfo> {

    val result =
        mutableListOf<DateInfo>()

    val calendar =
        Calendar.getInstance()


    val dayFormatter =
        SimpleDateFormat(
            "EEE",
            Locale.ENGLISH
        )

    val dateFormatter =
        SimpleDateFormat(
            "dd",
            Locale.ENGLISH
        )

    val monthFormatter =
        SimpleDateFormat(
            "MMM",
            Locale.ENGLISH
        )

    val fullDateFormatter =
        SimpleDateFormat(
            "dd MMM yyyy",
            Locale.ENGLISH
        )


    repeat(7) {

        result.add(

            DateInfo(

                day =
                    dayFormatter
                        .format(
                            calendar.time
                        )
                        .uppercase(),

                date =
                    dateFormatter.format(
                        calendar.time
                    ),

                month =
                    monthFormatter.format(
                        calendar.time
                    ),

                fullDate =
                    fullDateFormatter.format(
                        calendar.time
                    )
            )
        )


        calendar.add(
            Calendar.DAY_OF_MONTH,
            1
        )
    }


    return result
}


// =============================================================
// DATE CARD
// =============================================================

@Composable
private fun DateCard(

    day: String,

    date: String,

    month: String,

    selected: Boolean,

    onClick: () -> Unit
) {

    Column(

        modifier = Modifier
            .width(65.dp)
            .height(70.dp)
            .clip(
                RoundedCornerShape(
                    14.dp
                )
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
            }
            .padding(7.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(

            text =
                day,

            color =
                if (selected) {
                    Color.Black
                } else {
                    PullpadamGray
                },

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
                date,

            color =
                if (selected) {
                    Color.Black
                } else {
                    Color.White
                },

            fontSize =
                18.sp,

            fontWeight =
                FontWeight.ExtraBold
        )


        Text(

            text =
                month,

            color =
                if (selected) {
                    Color.Black
                } else {
                    PullpadamGray
                },

            fontSize =
                8.sp
        )
    }
}


// =============================================================
// FACILITY CARD
// =============================================================

@Composable
private fun FacilityCard(

    icon: String,

    text: String
) {

    Box(

        modifier = Modifier
            .width(105.dp)
            .height(80.dp)
            .clip(
                RoundedCornerShape(
                    15.dp
                )
            )
            .background(
                PullpadamCard
            ),

        contentAlignment =
            Alignment.Center
    ) {

        Column(

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(

                text =
                    icon,

                fontSize =
                    22.sp
            )


            Spacer(
                modifier =
                    Modifier.height(6.dp)
            )


            Text(

                text =
                    text,

                color =
                    PullpadamGray,

                fontSize =
                    10.sp
            )
        }
    }
}


// =============================================================
// GET AVAILABLE FORMATS
// =============================================================

private fun getAvailableFormats(
    type: String
): List<String> {

    val formats =
        mutableListOf<String>()


    if (
        type.contains(
            "5v5",
            ignoreCase = true
        )
    ) {

        formats.add(
            "5v5"
        )
    }


    if (
        type.contains(
            "7v7",
            ignoreCase = true
        )
    ) {

        formats.add(
            "7v7"
        )
    }


    return formats
}