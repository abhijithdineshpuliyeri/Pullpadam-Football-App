package com.example.pullpadamwherethegamebegins.navigation

import android.net.Uri

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// =============================================================
// AI SCREENS
// =============================================================

import com.example.pullpadamwherethegamebegins.screens.AIFindGameScreen
import com.example.pullpadamwherethegamebegins.screens.AIFindPlayerScreen
import com.example.pullpadamwherethegamebegins.screens.AIFindTeamScreen
import com.example.pullpadamwherethegamebegins.screens.AIGameMatchesScreen
import com.example.pullpadamwherethegamebegins.screens.AIPlayerMatchesScreen
import com.example.pullpadamwherethegamebegins.screens.AITeamMatchesScreen
import com.example.pullpadamwherethegamebegins.screens.PullpadamAIScreen

// =============================================================
// PROFILE
// =============================================================

import com.example.pullpadamwherethegamebegins.screens.ProfileScreen
import com.example.pullpadamwherethegamebegins.screens.EditProfileScreen
import com.example.pullpadamwherethegamebegins.screens.AIRecruitmentScreen

// =============================================================
// GENERAL
// =============================================================

import com.example.pullpadamwherethegamebegins.screens.BookingConfirmationScreen
import com.example.pullpadamwherethegamebegins.screens.BookingStore
import com.example.pullpadamwherethegamebegins.screens.BookingSuccessfulScreen
import com.example.pullpadamwherethegamebegins.screens.CreateAccountScreen
import com.example.pullpadamwherethegamebegins.screens.HomeScreen
import com.example.pullpadamwherethegamebegins.screens.LoginScreen
import com.example.pullpadamwherethegamebegins.screens.MyBookingsScreen
import com.example.pullpadamwherethegamebegins.screens.OnboardingScreen
import com.example.pullpadamwherethegamebegins.screens.SplashScreen

// =============================================================
// TURF
// =============================================================

import com.example.pullpadamwherethegamebegins.screens.Turf
import com.example.pullpadamwherethegamebegins.screens.TurfDetailsScreen
import com.example.pullpadamwherethegamebegins.screens.TurfListScreen


@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()


    // =========================================================
    // PROFILE DATA
    // =========================================================

    var playerName by remember {
        mutableStateOf("Abhijith")
    }

    var primaryPosition by remember {
        mutableStateOf("Forward")
    }

    var secondaryPosition by remember {
        mutableStateOf("Left Wing")
    }

    var playingLevel by remember {
        mutableStateOf("Competitive")
    }

    var preferredFormat by remember {
        mutableStateOf("5v5 • 7v7")
    }

    var availability by remember {
        mutableStateOf("Evening")
    }

    var playerLocation by remember {
        mutableStateOf("Kannur")
    }

    var recruitmentEnabled by remember {
        mutableStateOf(true)
    }


    // =========================================================
    // NAVIGATION
    // =========================================================

    NavHost(

        navController =
            navController,

        // LOGIN IS NOW THE FIRST SCREEN
        startDestination =
            "login",

        modifier =
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
    ) {


        // =====================================================
        // SPLASH
        // =====================================================

        composable("splash") {

            SplashScreen(

                onSplashFinished = {

                    navController.navigate(
                        "login"
                    ) {

                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // =====================================================
        // ONBOARDING
        // =====================================================

        composable("onboarding") {

            OnboardingScreen(

                onGetStarted = {

                    navController.navigate(
                        "login"
                    )
                }
            )
        }


        // =====================================================
        // LOGIN
        // =====================================================

        composable("login") {

            LoginScreen(

                onLogin = {

                    navController.navigate(
                        "home"
                    ) {

                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },

                onCreateAccount = {

                    navController.navigate(
                        "createAccount"
                    )
                }
            )
        }


        // =====================================================
        // CREATE ACCOUNT
        // =====================================================

        composable("createAccount") {

            CreateAccountScreen(

                onAccountCreated = {

                    navController.navigate(
                        "home"
                    ) {

                        popUpTo("createAccount") {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // =====================================================
        // HOME
        // =====================================================

        composable("home") {

            HomeScreen(

                // -------------------------------------------------
                // AI
                // -------------------------------------------------

                onAI = {

                    navController.navigate(
                        "aiHome"
                    )
                },


                // -------------------------------------------------
                // FIND PLAYERS
                // -------------------------------------------------

                onFindPlayers = {

                    navController.navigate(
                        "aiFindPlayer"
                    )
                },


                // -------------------------------------------------
                // BOOK TURF
                // -------------------------------------------------

                onBookTurf = {

                    navController.navigate(
                        "turfList"
                    )
                },


                // -------------------------------------------------
                // MY BOOKINGS
                // -------------------------------------------------

                onMyBookings = {

                    navController.navigate(
                        "myBookings"
                    )
                },


                // -------------------------------------------------
                // TURF SELECTED
                // -------------------------------------------------

                onTurfSelected = { turf ->

                    val encodedName =
                        Uri.encode(
                            turf.name
                        )

                    navController.navigate(
                        "turfDetails/$encodedName"
                    )
                }
            )
        }


        // =====================================================
        // PROFILE
        // =====================================================

        composable("profile") {

            ProfileScreen(

                playerName =
                    playerName,

                position =
                    primaryPosition,

                secondaryPosition =
                    secondaryPosition,

                level =
                    playingLevel,

                format =
                    preferredFormat,

                availability =
                    availability,

                location =
                    playerLocation,

                recruitmentEnabled =
                    recruitmentEnabled,

                onEditProfile = {

                    navController.navigate(
                        "editProfile"
                    )
                },

                onRecruitment = {

                    navController.navigate(
                        "aiRecruitment"
                    )
                }
            )
        }


        // =====================================================
        // EDIT PROFILE
        // =====================================================

        composable("editProfile") {

            EditProfileScreen(

                currentName =
                    playerName,

                currentPosition =
                    primaryPosition,

                currentSecondaryPosition =
                    secondaryPosition,

                currentLevel =
                    playingLevel,

                currentFormat =
                    preferredFormat,

                currentAvailability =
                    availability,

                currentLocation =
                    playerLocation,

                onSave = {
                        name,
                        position,
                        secondary,
                        level,
                        format,
                        time,
                        location ->

                    playerName =
                        name

                    primaryPosition =
                        position

                    secondaryPosition =
                        secondary

                    playingLevel =
                        level

                    preferredFormat =
                        format

                    availability =
                        time

                    playerLocation =
                        location

                    navController.popBackStack()
                },

                onBack = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================================
        // AI RECRUITMENT
        // =====================================================

        composable("aiRecruitment") {

            AIRecruitmentScreen(

                initiallyEnabled =
                    recruitmentEnabled,

                onSave = { enabled ->

                    recruitmentEnabled =
                        enabled

                    navController.popBackStack()
                },

                onBack = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================================
        // PULLPADAM AI HOME
        // =====================================================

        composable("aiHome") {

            PullpadamAIScreen(

                onFindGame = {

                    navController.navigate(
                        "aiFindGame"
                    )
                },

                onFindTeam = {

                    navController.navigate(
                        "aiFindTeam"
                    )
                },

                onFindPlayer = {

                    navController.navigate(
                        "aiFindPlayer"
                    )
                }
            )
        }


        // =====================================================
        // AI FIND GAME
        // =====================================================

        composable("aiFindGame") {

            AIFindGameScreen(

                onFindGame = {
                        format,
                        time,
                        budget,
                        distance ->

                    navController.navigate(

                        "aiGameMatches/" +
                                Uri.encode(format) +
                                "/" +
                                Uri.encode(time) +
                                "/" +
                                Uri.encode(budget) +
                                "/" +
                                Uri.encode(distance)
                    )
                }
            )
        }


        // =====================================================
        // AI GAME MATCHES
        // =====================================================

        composable(

            route =
                "aiGameMatches/{format}/{time}/{budget}/{distance}",

            arguments =
                listOf(

                    navArgument("format") {
                        type =
                            NavType.StringType
                    },

                    navArgument("time") {
                        type =
                            NavType.StringType
                    },

                    navArgument("budget") {
                        type =
                            NavType.StringType
                    },

                    navArgument("distance") {
                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val format =
                backStackEntry
                    .arguments
                    ?.getString("format")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val time =
                backStackEntry
                    .arguments
                    ?.getString("time")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val budget =
                backStackEntry
                    .arguments
                    ?.getString("budget")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val distance =
                backStackEntry
                    .arguments
                    ?.getString("distance")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            AIGameMatchesScreen(

                format =
                    format,

                time =
                    time,

                budget =
                    budget,

                distance =
                    distance,

                onJoinGame = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================================
        // AI FIND TEAM
        // =====================================================

        composable("aiFindTeam") {

            AIFindTeamScreen(

                onFindTeams = {
                        playerCount,
                        format,
                        time,
                        distance ->

                    navController.navigate(

                        "aiTeamMatches/" +
                                playerCount +
                                "/" +
                                Uri.encode(format) +
                                "/" +
                                Uri.encode(time) +
                                "/" +
                                Uri.encode(distance)
                    )
                }
            )
        }


        // =====================================================
        // AI TEAM MATCHES
        // =====================================================

        composable(

            route =
                "aiTeamMatches/{playerCount}/{format}/{time}/{distance}",

            arguments =
                listOf(

                    navArgument("playerCount") {
                        type =
                            NavType.IntType
                    },

                    navArgument("format") {
                        type =
                            NavType.StringType
                    },

                    navArgument("time") {
                        type =
                            NavType.StringType
                    },

                    navArgument("distance") {
                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val playerCount =
                backStackEntry
                    .arguments
                    ?.getInt(
                        "playerCount"
                    )
                    ?: 3

            val format =
                backStackEntry
                    .arguments
                    ?.getString("format")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val time =
                backStackEntry
                    .arguments
                    ?.getString("time")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val distance =
                backStackEntry
                    .arguments
                    ?.getString("distance")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            AITeamMatchesScreen(

                playerCount =
                    playerCount,

                format =
                    format,

                time =
                    time,

                distance =
                    distance,

                onMergeTeams = {

                    navController.navigate(
                        "aiHome"
                    ) {

                        popUpTo(
                            "aiHome"
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // =====================================================
        // AI FIND PLAYER
        // =====================================================

        composable("aiFindPlayer") {

            AIFindPlayerScreen(

                onFindPlayers = {
                        position,
                        playersNeeded,
                        format,
                        level,
                        distance ->

                    navController.navigate(

                        "aiPlayerMatches/" +
                                Uri.encode(position) +
                                "/" +
                                playersNeeded +
                                "/" +
                                Uri.encode(format) +
                                "/" +
                                Uri.encode(level) +
                                "/" +
                                Uri.encode(distance)
                    )
                }
            )
        }


        // =====================================================
        // AI PLAYER MATCHES
        // =====================================================

        composable(

            route =
                "aiPlayerMatches/{position}/{playersNeeded}/{format}/{level}/{distance}",

            arguments =
                listOf(

                    navArgument("position") {
                        type =
                            NavType.StringType
                    },

                    navArgument("playersNeeded") {
                        type =
                            NavType.IntType
                    },

                    navArgument("format") {
                        type =
                            NavType.StringType
                    },

                    navArgument("level") {
                        type =
                            NavType.StringType
                    },

                    navArgument("distance") {
                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val position =
                backStackEntry
                    .arguments
                    ?.getString("position")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val playersNeeded =
                backStackEntry
                    .arguments
                    ?.getInt(
                        "playersNeeded"
                    )
                    ?: 1

            val format =
                backStackEntry
                    .arguments
                    ?.getString("format")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val level =
                backStackEntry
                    .arguments
                    ?.getString("level")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val distance =
                backStackEntry
                    .arguments
                    ?.getString("distance")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            AIPlayerMatchesScreen(

                position =
                    position,

                playersNeeded =
                    playersNeeded,

                format =
                    format,

                level =
                    level,

                distance =
                    distance,

                onInvitePlayer = {

                    navController.popBackStack()
                }
            )
        }


        // =====================================================
        // TURF LIST
        // =====================================================

        composable("turfList") {

            TurfListScreen(

                onTurfSelected = { turf ->

                    val encodedName =
                        Uri.encode(
                            turf.name
                        )

                    navController.navigate(
                        "turfDetails/$encodedName"
                    )
                }
            )
        }


        // =====================================================
        // TURF DETAILS
        // =====================================================

        composable(

            route =
                "turfDetails/{turfName}",

            arguments =
                listOf(

                    navArgument("turfName") {

                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val turfName =
                backStackEntry
                    .arguments
                    ?.getString("turfName")
                    ?.let {
                        Uri.decode(it)
                    }

            val turf =
                getTurfByName(
                    turfName
                )

            if (turf != null) {

                TurfDetailsScreen(

                    turf =
                        turf,

                    onBookNow = {
                            date,
                            time,
                            format,
                            session ->

                        navController.navigate(

                            "bookingConfirmation/" +

                                    Uri.encode(
                                        turf.name
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        date
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        time
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        format
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        session
                                    )
                        )
                    }
                )
            }
        }


        // =====================================================
        // BOOKING CONFIRMATION
        // =====================================================

        composable(

            route =
                "bookingConfirmation/{turfName}/{date}/{time}/{format}/{session}",

            arguments =
                listOf(

                    navArgument("turfName") {
                        type =
                            NavType.StringType
                    },

                    navArgument("date") {
                        type =
                            NavType.StringType
                    },

                    navArgument("time") {
                        type =
                            NavType.StringType
                    },

                    navArgument("format") {
                        type =
                            NavType.StringType
                    },

                    navArgument("session") {
                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val turfName =
                backStackEntry
                    .arguments
                    ?.getString("turfName")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val date =
                backStackEntry
                    .arguments
                    ?.getString("date")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val time =
                backStackEntry
                    .arguments
                    ?.getString("time")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val format =
                backStackEntry
                    .arguments
                    ?.getString("format")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val session =
                backStackEntry
                    .arguments
                    ?.getString("session")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val turf =
                getTurfByName(
                    turfName
                )

            if (turf != null) {

                BookingConfirmationScreen(

                    turfName =
                        turf.name,

                    date =
                        date,

                    time =
                        time,

                    format =
                        format,

                    session =
                        session,

                    price =
                        turf.price,

                    onConfirmBooking = {

                        BookingStore.addBooking(

                            turfName =
                                turf.name,

                            format =
                                format,

                            session =
                                session,

                            date =
                                date,

                            time =
                                time,

                            price =
                                turf.price
                        )


                        navController.navigate(

                            "bookingSuccessful/" +

                                    Uri.encode(
                                        turf.name
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        date
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        time
                                    ) +

                                    "/" +

                                    Uri.encode(
                                        turf.price
                                    )
                        )
                    }
                )
            }
        }


        // =====================================================
        // BOOKING SUCCESSFUL
        // =====================================================

        composable(

            route =
                "bookingSuccessful/{turfName}/{date}/{time}/{price}",

            arguments =
                listOf(

                    navArgument("turfName") {
                        type =
                            NavType.StringType
                    },

                    navArgument("date") {
                        type =
                            NavType.StringType
                    },

                    navArgument("time") {
                        type =
                            NavType.StringType
                    },

                    navArgument("price") {
                        type =
                            NavType.StringType
                    }
                )
        ) { backStackEntry ->

            val turfName =
                backStackEntry
                    .arguments
                    ?.getString("turfName")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val date =
                backStackEntry
                    .arguments
                    ?.getString("date")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val time =
                backStackEntry
                    .arguments
                    ?.getString("time")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            val price =
                backStackEntry
                    .arguments
                    ?.getString("price")
                    ?.let {
                        Uri.decode(it)
                    }
                    ?: ""

            BookingSuccessfulScreen(

                turfName =
                    turfName,

                date =
                    date,

                time =
                    time,

                price =
                    price,

                onGoHome = {

                    navController.navigate(
                        "home"
                    ) {

                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }


        // =====================================================
        // MY BOOKINGS
        // =====================================================

        composable("myBookings") {

            MyBookingsScreen(

                bookings =
                    BookingStore.bookings,

                onBookingCancelled = { booking ->

                    BookingStore.cancelBooking(
                        booking
                    )
                }
            )
        }
    }
}


// =============================================================
// TURF LOOKUP
// =============================================================

private fun getTurfByName(
    name: String?
): Turf? {

    val turfs =
        listOf(

            Turf(
                name =
                    "Green Arena",

                rating =
                    "4.8",

                distance =
                    "2.4 km",

                price =
                    "₹1,200 / hour",

                type =
                    "5v5 • 7v7",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf1,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf2,

                location =
                    "Talap, Kannur, Kerala",

                address =
                    "Near Talap Junction, Kannur"
            ),


            Turf(
                name =
                    "KickZone Football",

                rating =
                    "4.6",

                distance =
                    "3.1 km",

                price =
                    "₹1,000 / hour",

                type =
                    "5v5",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf3,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf4,

                location =
                    "Thavakkara, Kannur, Kerala",

                address =
                    "Opposite Thavakkara Bus Stand"
            ),


            Turf(
                name =
                    "Goal Masters",

                rating =
                    "4.7",

                distance =
                    "4.2 km",

                price =
                    "₹1,500 / hour",

                type =
                    "7v7 • 11v11",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf5,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf6,

                location =
                    "Pallikunnu, Kannur, Kerala",

                address =
                    "Pallikunnu Main Road, Kannur"
            ),


            Turf(
                name =
                    "Football Hub",

                rating =
                    "4.5",

                distance =
                    "5.0 km",

                price =
                    "₹900 / hour",

                type =
                    "5v5",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf7,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf8,

                location =
                    "Chalad, Kannur, Kerala",

                address =
                    "Chalad Football Ground Road"
            ),


            Turf(
                name =
                    "Pro Arena",

                rating =
                    "4.9",

                distance =
                    "5.8 km",

                price =
                    "₹1,400 / hour",

                type =
                    "5v5 • 7v7",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf9,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf10,

                location =
                    "Valapattanam, Kannur, Kerala",

                address =
                    "Near Valapattanam Railway Station"
            ),


            Turf(
                name =
                    "City Football",

                rating =
                    "4.6",

                distance =
                    "6.4 km",

                price =
                    "₹1,100 / hour",

                type =
                    "7v7",

                image1 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf11,

                image2 =
                    com.example.pullpadamwherethegamebegins
                        .R.drawable.turf12,

                location =
                    "South Bazar, Kannur, Kerala",

                address =
                    "South Bazar Sports Complex"
            )
        )


    return turfs.find {

        it.name == name
    }
}