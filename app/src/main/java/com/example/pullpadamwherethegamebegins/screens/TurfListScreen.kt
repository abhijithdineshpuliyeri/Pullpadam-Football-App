package com.example.pullpadamwherethegamebegins.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pullpadamwherethegamebegins.R

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamCard2 = Color(0xFF1B201D)
private val PullpadamGray = Color(0xFF9A9F9C)
private val PullpadamDarkGray = Color(0xFF606562)


// =============================================================
// TURF MODEL
// =============================================================

data class Turf(
    val name: String,
    val rating: String,
    val distance: String,
    val price: String,
    val type: String,

    // NEW
    val image1: Int = R.drawable.turf1,
    val image2: Int = R.drawable.turf2,

    val location: String = "Kannur, Kerala",

    val address: String = "Kannur, Kerala",

    val facilities: List<String> =
        listOf(
            "Showers",
            "Parking",
            "Floodlights"
        )
)


// =============================================================
// TURF LIST SCREEN
// =============================================================

@Composable
fun TurfListScreen(
    onTurfSelected: (Turf) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    var selectedFilter by remember {
        mutableStateOf("ALL")
    }


    // =========================================================
    // TURF DATA
    // =========================================================

    val turfs = remember {

        listOf(

            Turf(
                name = "Green Arena",
                rating = "4.8",
                distance = "2.4 km",
                price = "₹1,200 / hour",
                type = "5v5 • 7v7",
                image1 = R.drawable.turf1,
                image2 = R.drawable.turf2,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            ),

            Turf(
                name = "KickZone Football",
                rating = "4.6",
                distance = "3.1 km",
                price = "₹1,000 / hour",
                type = "5v5",
                image1 = R.drawable.turf3,
                image2 = R.drawable.turf4,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            ),

            Turf(
                name = "Goal Masters",
                rating = "4.7",
                distance = "4.2 km",
                price = "₹1,500 / hour",
                type = "7v7 • 11v11",
                image1 = R.drawable.turf5,
                image2 = R.drawable.turf6,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            ),

            Turf(
                name = "Football Hub",
                rating = "4.5",
                distance = "5.0 km",
                price = "₹900 / hour",
                type = "5v5",
                image1 = R.drawable.turf7,
                image2 = R.drawable.turf8,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            ),

            Turf(
                name = "Pro Arena",
                rating = "4.9",
                distance = "5.8 km",
                price = "₹1,400 / hour",
                type = "5v5 • 7v7",
                image1 = R.drawable.turf9,
                image2 = R.drawable.turf10,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            ),

            Turf(
                name = "City Football",
                rating = "4.6",
                distance = "6.4 km",
                price = "₹1,100 / hour",
                type = "7v7",
                image1 = R.drawable.turf11,
                image2 = R.drawable.turf12,
                location = "Kannur, Kerala",
                address = "Kannur, Kerala"
            )
        )
    }


    // =========================================================
    // FILTER
    // =========================================================

    val filteredTurfs =
        turfs.filter { turf ->

            val matchesSearch =
                turf.name.contains(
                    searchText,
                    ignoreCase = true
                )

            val matchesFilter =
                when (selectedFilter) {

                    "5V5" ->
                        turf.type.contains(
                            "5v5",
                            ignoreCase = true
                        )

                    "7V7" ->
                        turf.type.contains(
                            "7v7",
                            ignoreCase = true
                        )

                    else ->
                        true
                }

            matchesSearch && matchesFilter
        }


    // =========================================================
    // SCREEN
    // =========================================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .padding(horizontal = 20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(18.dp)
        )


        Text(
            text = "FIND A TURF",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )


        Spacer(
            modifier = Modifier.height(5.dp)
        )


        Text(
            text =
                "Choose the perfect place for your next game.",
            color = PullpadamGray,
            fontSize = 12.sp
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // =====================================================
        // SEARCH
        // =====================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .background(PullpadamCard)
                .padding(horizontal = 15.dp),

            contentAlignment =
                Alignment.CenterStart
        ) {

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = "⌕",
                    color = PullpadamGray,
                    fontSize = 25.sp
                )

                Spacer(
                    modifier =
                        Modifier.width(10.dp)
                )

                BasicTextField(
                    value = searchText,

                    onValueChange = {
                        searchText = it
                    },

                    modifier =
                        Modifier.fillMaxWidth(),

                    singleLine = true,

                    textStyle =
                        TextStyle(
                            color = Color.White,
                            fontSize = 13.sp
                        ),

                    decorationBox = {
                            innerTextField ->

                        if (searchText.isEmpty()) {

                            Text(
                                text = "Search turfs...",
                                color = PullpadamDarkGray,
                                fontSize = 13.sp
                            )
                        }

                        innerTextField()
                    }
                )
            }
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // =====================================================
        // FILTER BUTTONS
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            FilterButton(
                text = "ALL",
                selected =
                    selectedFilter == "ALL",
                onClick = {
                    selectedFilter = "ALL"
                }
            )

            FilterButton(
                text = "5V5",
                selected =
                    selectedFilter == "5V5",
                onClick = {
                    selectedFilter = "5V5"
                }
            )

            FilterButton(
                text = "7V7",
                selected =
                    selectedFilter == "7V7",
                onClick = {
                    selectedFilter = "7V7"
                }
            )
        }


        Spacer(
            modifier = Modifier.height(18.dp)
        )


        Text(
            text =
                "${filteredTurfs.size} TURFS AVAILABLE",

            color =
                PullpadamGray,

            fontSize = 10.sp,

            fontWeight =
                FontWeight.Bold,

            letterSpacing = 0.8.sp
        )


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        // =====================================================
        // LIST
        // =====================================================

        if (filteredTurfs.isEmpty()) {

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(1f),

                contentAlignment =
                    Alignment.Center
            ) {

                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "⚽",
                        fontSize = 35.sp
                    )

                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )

                    Text(
                        text = "No turfs found",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(5.dp)
                    )

                    Text(
                        text =
                            "Try another search or filter.",
                        color = PullpadamGray,
                        fontSize = 12.sp
                    )
                }
            }

        } else {

            LazyColumn(
                modifier =
                    Modifier.weight(1f),

                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                items(
                    filteredTurfs
                ) { turf ->

                    TurfListCard(
                        turf = turf,

                        onClick = {
                            onTurfSelected(turf)
                        }
                    )
                }

                item {

                    Spacer(
                        modifier =
                            Modifier.height(20.dp)
                    )
                }
            }
        }
    }
}


// =============================================================
// FILTER BUTTON
// =============================================================

@Composable
private fun FilterButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier =
            Modifier
                .height(40.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(
                    if (selected)
                        PullpadamGreen
                    else
                        PullpadamCard
                )
                .clickable {
                    onClick()
                }
                .padding(
                    horizontal = 18.dp
                ),

        contentAlignment =
            Alignment.Center
    ) {

        Text(
            text = text,

            color =
                if (selected)
                    Color.Black
                else
                    PullpadamGray,

            fontSize = 11.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// TURF CARD
// =============================================================

@Composable
private fun TurfListCard(
    turf: Turf,
    onClick: () -> Unit
) {

    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(20.dp)
                )
                .background(
                    PullpadamCard
                )
                .clickable {
                    onClick()
                }
                .padding(15.dp)
    ) {

        // =====================================================
        // REAL TURF IMAGE
        // =====================================================

        Image(
            painter =
                painterResource(
                    id = turf.image1
                ),

            contentDescription =
                turf.name,

            contentScale =
                ContentScale.Crop,

            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(145.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
        )


        Spacer(
            modifier =
                Modifier.height(13.dp)
        )


        // =====================================================
        // NAME + RATING
        // =====================================================

        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text = turf.name,

                color =
                    Color.White,

                fontSize = 17.sp,

                fontWeight =
                    FontWeight.ExtraBold
            )


            Box(
                modifier =
                    Modifier
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                        .background(
                            Color(0xFF202521)
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 5.dp
                        )
            ) {

                Text(
                    text =
                        "★ ${turf.rating}",

                    color =
                        PullpadamGreen,

                    fontSize = 10.sp,

                    fontWeight =
                        FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        // =====================================================
        // LOCATION
        // =====================================================

        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                text =
                    "📍 ${turf.location}",

                color =
                    PullpadamGray,

                fontSize = 11.sp
            )

            Spacer(
                modifier =
                    Modifier.width(10.dp)
            )

            Text(
                text =
                    "• ${turf.distance}",

                color =
                    PullpadamGray,

                fontSize = 11.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(7.dp)
        )


        Text(
            text = turf.type,

            color =
                PullpadamGray,

            fontSize = 11.sp
        )


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        // =====================================================
        // PRICE + VIEW
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
                        "STARTING FROM",

                    color =
                        PullpadamDarkGray,

                    fontSize = 8.sp,

                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(3.dp)
                )

                Text(
                    text =
                        turf.price,

                    color =
                        PullpadamGreen,

                    fontSize = 13.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }


            Box(
                modifier =
                    Modifier
                        .clip(
                            RoundedCornerShape(11.dp)
                        )
                        .background(
                            PullpadamGreen
                        )
                        .clickable {
                            onClick()
                        }
                        .padding(
                            horizontal = 15.dp,
                            vertical = 9.dp
                        ),

                contentAlignment =
                    Alignment.Center
            ) {

                Text(
                    text =
                        "VIEW TURF  →",

                    color =
                        Color.Black,

                    fontSize = 9.sp,

                    fontWeight =
                        FontWeight.ExtraBold
                )
            }
        }
    }
}