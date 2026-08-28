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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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


// =============================================================
// COLORS
// =============================================================

private val PullpadamBackground =
    Color(0xFF0B0D0C)

private val PullpadamGreen =
    Color(0xFFB6FF3B)

private val PullpadamCard =
    Color(0xFF151917)

private val PullpadamCard2 =
    Color(0xFF191D1B)

private val PullpadamGray =
    Color(0xFF9A9F9C)

private val PullpadamDarkGray =
    Color(0xFF606562)


// =============================================================
// HOME SCREEN
// =============================================================

@Composable
fun HomeScreen(
    onAI: () -> Unit = {},
    onFindPlayers: () -> Unit = {},
    onBookTurf: () -> Unit = {},
    onMyBookings: () -> Unit = {},
    onTurfSelected: (Turf) -> Unit = {}
) {

    var searchText by remember {
        mutableStateOf("")
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
    // SEARCH FILTER
    // =========================================================

    val filteredTurfs =
        turfs.filter {

            it.name.contains(
                searchText,
                ignoreCase = true
            )
        }


    // =========================================================
    // MAIN SCREEN
    // =========================================================

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(
                    PullpadamBackground
                )
    ) {


        // =====================================================
        // SCROLLABLE CONTENT
        // =====================================================

        Column(
            modifier =
                Modifier
                    .weight(1f)
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(
                        horizontal = 20.dp
                    )
        ) {


            Spacer(
                modifier =
                    Modifier.height(18.dp)
            )


            // =================================================
            // HEADER
            // =================================================

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
                            "Hello, Player 👋",

                        color =
                            Color.White,

                        fontSize =
                            23.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(4.dp)
                    )

                    Text(
                        text =
                            "Ready for your next game?",

                        color =
                            PullpadamGray,

                        fontSize =
                            12.sp
                    )
                }


                // Notification

                Box(
                    modifier =
                        Modifier
                            .size(44.dp)
                            .clip(
                                RoundedCornerShape(
                                    14.dp
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
                            "🔔",

                        fontSize =
                            18.sp
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(20.dp)
            )


            // =================================================
            // LOCATION
            // =================================================

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text =
                        "📍",

                    fontSize =
                        16.sp
                )


                Spacer(
                    modifier =
                        Modifier.width(6.dp)
                )


                Column {

                    Text(
                        text =
                            "YOUR LOCATION",

                        color =
                            PullpadamGray,

                        fontSize =
                            8.sp,

                        fontWeight =
                            FontWeight.Bold,

                        letterSpacing =
                            0.8.sp
                    )


                    Text(
                        text =
                            "Kannur, Kerala",

                        color =
                            Color.White,

                        fontSize =
                            12.sp,

                        fontWeight =
                            FontWeight.SemiBold
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )


            // =================================================
            // SEARCH
            // =================================================

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(
                            RoundedCornerShape(
                                15.dp
                            )
                        )
                        .background(
                            PullpadamCard
                        )
                        .padding(
                            horizontal = 15.dp
                        ),

                contentAlignment =
                    Alignment.CenterStart
            ) {

                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Text(
                        text =
                            "⌕",

                        color =
                            PullpadamGray,

                        fontSize =
                            25.sp
                    )


                    Spacer(
                        modifier =
                            Modifier.width(10.dp)
                    )


                    BasicTextField(
                        value =
                            searchText,

                        onValueChange = {
                            searchText = it
                        },

                        modifier =
                            Modifier.fillMaxWidth(),

                        singleLine =
                            true,

                        textStyle =
                            TextStyle(
                                color =
                                    Color.White,

                                fontSize =
                                    13.sp
                            ),

                        decorationBox = {
                                innerTextField ->

                            if (
                                searchText.isEmpty()
                            ) {

                                Text(
                                    text =
                                        "Search turfs...",

                                    color =
                                        PullpadamDarkGray,

                                    fontSize =
                                        13.sp
                                )
                            }

                            innerTextField()
                        }
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(22.dp)
            )


            // =================================================
            // AI CARD
            // =================================================

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                22.dp
                            )
                        )
                        .background(
                            PullpadamGreen
                        )
                        .clickable {
                            onAI()
                        }
                        .padding(20.dp)
            ) {

                Column {

                    Row(
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Box(
                            modifier =
                                Modifier
                                    .size(38.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            12.dp
                                        )
                                    )
                                    .background(
                                        Color(0xFF9FE42F)
                                    ),

                            contentAlignment =
                                Alignment.Center
                        ) {

                            Text(
                                text =
                                    "✦",

                                color =
                                    Color.Black,

                                fontSize =
                                    21.sp,

                                fontWeight =
                                    FontWeight.Bold
                            )
                        }


                        Spacer(
                            modifier =
                                Modifier.width(10.dp)
                        )


                        Text(
                            text =
                                "PULLPADAM AI",

                            color =
                                Color.Black,

                            fontSize =
                                16.sp,

                            fontWeight =
                                FontWeight.ExtraBold
                        )
                    }


                    Spacer(
                        modifier =
                            Modifier.height(14.dp)
                    )


                    Text(
                        text =
                            "Find the perfect game",

                        color =
                            Color.Black,

                        fontSize =
                            22.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )


                    Spacer(
                        modifier =
                            Modifier.height(5.dp)
                    )


                    Text(
                        text =
                            "Tell us how you want to play. We'll figure out the rest.",

                        color =
                            Color(0xFF26301D),

                        fontSize =
                            12.sp
                    )


                    Spacer(
                        modifier =
                            Modifier.height(15.dp)
                    )


                    Text(
                        text =
                            "TRY AI  →",

                        color =
                            Color.Black,

                        fontSize =
                            11.sp,

                        fontWeight =
                            FontWeight.ExtraBold
                    )
                }
            }


            Spacer(
                modifier =
                    Modifier.height(26.dp)
            )


            // =================================================
            // QUICK ACTIONS
            // =================================================

            SectionTitle(
                title =
                    "QUICK ACTIONS"
            )


            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )


            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                QuickActionCard(
                    icon =
                        "⚽",

                    title =
                        "Book Turf",

                    subtitle =
                        "Find & book",

                    modifier =
                        Modifier.weight(1f),

                    onClick =
                        onBookTurf
                )


                QuickActionCard(
                    icon =
                        "🤝",

                    title =
                        "Find Players",

                    subtitle =
                        "Complete your team",

                    modifier =
                        Modifier.weight(1f),

                    onClick =
                        onFindPlayers
                )
            }


            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )


            QuickActionCard(
                icon =
                    "▣",

                title =
                    "My Bookings",

                subtitle =
                    "View & manage bookings",

                modifier =
                    Modifier.fillMaxWidth(),

                onClick =
                    onMyBookings
            )


            Spacer(
                modifier =
                    Modifier.height(28.dp)
            )


            // =================================================
            // NEARBY TURFS
            // =================================================

            Row(
                modifier =
                    Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween,

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                SectionTitle(
                    title =
                        "NEARBY TURFS"
                )


                Text(
                    text =
                        "SEE ALL  →",

                    color =
                        PullpadamGreen,

                    fontSize =
                        9.sp,

                    fontWeight =
                        FontWeight.Bold,

                    modifier =
                        Modifier.clickable {
                            onBookTurf()
                        }
                )
            }


            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )


            // =================================================
            // NEARBY TURF LIST
            // =================================================

            if (
                filteredTurfs.isEmpty()
            ) {

                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(105.dp)
                            .clip(
                                RoundedCornerShape(
                                    18.dp
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
                            "No turfs found",

                        color =
                            PullpadamGray,

                        fontSize =
                            13.sp
                    )
                }

            } else {

                filteredTurfs
                    .take(3)
                    .forEach { turf ->

                        HomeTurfCard(
                            turf =
                                turf,

                            onClick = {
                                onTurfSelected(
                                    turf
                                )
                            }
                        )


                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )
                    }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )


            // =================================================
            // TOP RATED
            // =================================================

            SectionTitle(
                title =
                    "TOP RATED"
            )


            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )


            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(
                            rememberScrollState()
                        ),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                turfs
                    .sortedByDescending {

                        it.rating
                            .toDoubleOrNull()
                            ?: 0.0
                    }
                    .take(3)
                    .forEach { turf ->

                        TopRatedCard(
                            turf =
                                turf,

                            onClick = {
                                onTurfSelected(
                                    turf
                                )
                            }
                        )
                    }
            }


            Spacer(
                modifier =
                    Modifier.height(25.dp)
            )
        }


        // =====================================================
        // BOTTOM NAVIGATION
        // =====================================================

        HomeBottomNavigation(
            onBookTurf =
                onBookTurf,

            onAI =
                onAI,

            onMyBookings =
                onMyBookings
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun SectionTitle(
    title: String
) {

    Text(
        text =
            title,

        color =
            Color.White,

        fontSize =
            14.sp,

        fontWeight =
            FontWeight.ExtraBold,

        letterSpacing =
            1.sp
    )
}


// =============================================================
// QUICK ACTION CARD
// =============================================================

@Composable
private fun QuickActionCard(
    icon: String,
    title: String,
    subtitle: String,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier =
            modifier
                .clip(
                    RoundedCornerShape(
                        18.dp
                    )
                )
                .background(
                    PullpadamCard
                )
                .clickable {
                    onClick()
                }
                .padding(17.dp)
    ) {

        Box(
            modifier =
                Modifier
                    .size(38.dp)
                    .clip(
                        RoundedCornerShape(
                            11.dp
                        )
                    )
                    .background(
                        PullpadamCard2
                    ),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                text =
                    icon,

                fontSize =
                    20.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(12.dp)
        )


        Text(
            text =
                title,

            color =
                Color.White,

            fontSize =
                14.sp,

            fontWeight =
                FontWeight.Bold
        )


        Spacer(
            modifier =
                Modifier.height(3.dp)
        )


        Text(
            text =
                subtitle,

            color =
                PullpadamGray,

            fontSize =
                10.sp
        )
    }
}


// =============================================================
// HOME TURF CARD
// =============================================================

@Composable
private fun HomeTurfCard(
    turf: Turf,
    onClick: () -> Unit
) {

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        19.dp
                    )
                )
                .background(
                    PullpadamCard
                )
                .clickable {
                    onClick()
                }
                .padding(14.dp),

        verticalAlignment =
            Alignment.CenterVertically
    ) {


        // =====================================================
        // TWO TURF IMAGES
        // =====================================================

        Row(
            modifier =
                Modifier
                    .width(96.dp)
                    .height(72.dp),

            horizontalArrangement =
                Arrangement.spacedBy(4.dp)
        ) {

            Image(
                painter =
                    painterResource(
                        id =
                            turf.image1
                    ),

                contentDescription =
                    "${turf.name} image 1",

                contentScale =
                    ContentScale.Crop,

                modifier =
                    Modifier
                        .weight(1f)
                        .height(72.dp)
                        .clip(
                            RoundedCornerShape(
                                11.dp
                            )
                        )
            )


            Image(
                painter =
                    painterResource(
                        id =
                            turf.image2
                    ),

                contentDescription =
                    "${turf.name} image 2",

                contentScale =
                    ContentScale.Crop,

                modifier =
                    Modifier
                        .weight(1f)
                        .height(72.dp)
                        .clip(
                            RoundedCornerShape(
                                11.dp
                            )
                        )
            )
        }


        Spacer(
            modifier =
                Modifier.width(13.dp)
        )


        // =====================================================
        // TURF INFORMATION
        // =====================================================

        Column(
            modifier =
                Modifier.weight(1f)
        ) {

            Text(
                text =
                    turf.name,

                color =
                    Color.White,

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.Bold
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    "📍 ${turf.location}",

                color =
                    PullpadamGray,

                fontSize =
                    9.sp
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    "★ ${turf.rating}  •  ${turf.distance}",

                color =
                    PullpadamGray,

                fontSize =
                    9.sp
            )


            Spacer(
                modifier =
                    Modifier.height(4.dp)
            )


            Text(
                text =
                    turf.price,

                color =
                    PullpadamGreen,

                fontSize =
                    10.sp,

                fontWeight =
                    FontWeight.Bold
            )
        }


        Text(
            text =
                "›",

            color =
                PullpadamGreen,

            fontSize =
                27.sp
        )
    }
}


// =============================================================
// TOP RATED CARD
// =============================================================

@Composable
private fun TopRatedCard(
    turf: Turf,
    onClick: () -> Unit
) {

    Column(
        modifier =
            Modifier
                .width(190.dp)
                .clip(
                    RoundedCornerShape(
                        18.dp
                    )
                )
                .background(
                    PullpadamCard
                )
                .clickable {
                    onClick()
                }
                .padding(12.dp)
    ) {


        // =====================================================
        // TWO IMAGE GALLERY
        // =====================================================

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(105.dp),

            horizontalArrangement =
                Arrangement.spacedBy(5.dp)
        ) {

            Image(
                painter =
                    painterResource(
                        id =
                            turf.image1
                    ),

                contentDescription =
                    "${turf.name} image 1",

                contentScale =
                    ContentScale.Crop,

                modifier =
                    Modifier
                        .weight(1f)
                        .height(105.dp)
                        .clip(
                            RoundedCornerShape(
                                13.dp
                            )
                        )
            )


            Image(
                painter =
                    painterResource(
                        id =
                            turf.image2
                    ),

                contentDescription =
                    "${turf.name} image 2",

                contentScale =
                    ContentScale.Crop,

                modifier =
                    Modifier
                        .weight(1f)
                        .height(105.dp)
                        .clip(
                            RoundedCornerShape(
                                13.dp
                            )
                        )
            )
        }


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        Text(
            text =
                turf.name,

            color =
                Color.White,

            fontSize =
                13.sp,

            fontWeight =
                FontWeight.Bold
        )


        Spacer(
            modifier =
                Modifier.height(4.dp)
        )


        Text(
            text =
                "📍 ${turf.location}",

            color =
                PullpadamGray,

            fontSize =
                9.sp
        )


        Spacer(
            modifier =
                Modifier.height(4.dp)
        )


        Text(
            text =
                "★ ${turf.rating}  •  ${turf.distance}",

            color =
                PullpadamGray,

            fontSize =
                10.sp
        )


        Spacer(
            modifier =
                Modifier.height(6.dp)
        )


        Text(
            text =
                turf.price,

            color =
                PullpadamGreen,

            fontSize =
                11.sp,

            fontWeight =
                FontWeight.Bold
        )
    }
}


// =============================================================
// BOTTOM NAVIGATION
// =============================================================

@Composable
private fun HomeBottomNavigation(
    onBookTurf: () -> Unit,
    onAI: () -> Unit,
    onMyBookings: () -> Unit
) {

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(
                    PullpadamCard
                )
                .padding(
                    top = 9.dp,
                    bottom = 10.dp
                ),

        horizontalArrangement =
            Arrangement.SpaceEvenly,

        verticalAlignment =
            Alignment.CenterVertically
    ) {


        BottomNavItem(
            icon =
                "⌂",

            label =
                "Home",

            selected =
                true,

            onClick = {}
        )


        BottomNavItem(
            icon =
                "⚽",

            label =
                "Turfs",

            selected =
                false,

            onClick =
                onBookTurf
        )


        BottomNavItem(
            icon =
                "✦",

            label =
                "AI",

            selected =
                false,

            onClick =
                onAI
        )


        BottomNavItem(
            icon =
                "▣",

            label =
                "Bookings",

            selected =
                false,

            onClick =
                onMyBookings
        )
    }
}


// =============================================================
// BOTTOM NAV ITEM
// =============================================================

@Composable
private fun BottomNavItem(
    icon: String,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier =
            Modifier
                .clickable {
                    onClick()
                }
                .padding(
                    horizontal = 16.dp,
                    vertical = 2.dp
                ),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text =
                icon,

            color =
                if (selected) {
                    PullpadamGreen
                } else {
                    PullpadamGray
                },

            fontSize =
                19.sp
        )


        Spacer(
            modifier =
                Modifier.height(3.dp)
        )


        Text(
            text =
                label,

            color =
                if (selected) {
                    PullpadamGreen
                } else {
                    PullpadamGray
                },

            fontSize =
                9.sp,

            fontWeight =
                if (selected) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
        )
    }
}