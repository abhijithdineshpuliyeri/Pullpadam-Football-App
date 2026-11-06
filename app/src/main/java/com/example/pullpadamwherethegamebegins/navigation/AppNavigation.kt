package com.example.pullpadamwherethegamebegins.navigation

import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt
import kotlinx.coroutines.delay
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.pullpadamwherethegamebegins.data.model.AIChatMessage
import com.example.pullpadamwherethegamebegins.viewmodel.AIMatchViewModel

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
import com.example.pullpadamwherethegamebegins.screens.AIFeaturesHubScreen

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

    val aiMatchViewModel: AIMatchViewModel = viewModel()


    // =========================================================
    // NAVIGATION
    // =========================================================

    Box(modifier = Modifier.fillMaxSize()) {
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
                // PROFILE
                // -------------------------------------------------

                onProfile = {

                    navController.navigate(
                        "profile"
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
                    navController.navigate("aiFindGame")
                },

                onFindTeam = {
                    navController.navigate("aiFindTeam")
                },

                onFindPlayer = {
                    navController.navigate("aiFindPlayer")
                },

                onOpenAiHub = {
                    navController.navigate("aiFeaturesHub")
                }
            )
        }

        // =====================================================
        // 20 AI FEATURES HUB
        // =====================================================

        composable("aiFeaturesHub") {

            AIFeaturesHubScreen(
                onNavigateBack = {
                    navController.popBackStack()
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

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showFloatingChatbot = currentRoute != null &&
            currentRoute != "splash" &&
            currentRoute != "onboarding" &&
            currentRoute != "login"

    if (showFloatingChatbot) {
        FloatingAiChatbotWidget(viewModel = aiMatchViewModel)
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

// =============================================================
// FLOATING UNIVERSAL AI CHATBOT WIDGET (DRAGGABLE + GOAL ANIMATION)
// =============================================================

@Composable
fun FloatingAiChatbotWidget(
    viewModel: AIMatchViewModel = viewModel()
) {
    var isChatOpen by remember { mutableStateOf(false) }
    var isFabVisible by remember { mutableStateOf(true) }
    var showGoalAnimation by remember { mutableStateOf(false) }

    val messages by viewModel.chatMessages.collectAsState()
    val isChatLoading by viewModel.isChatLoading.collectAsState()
    var userText by remember { mutableStateOf("") }

    // 2D Draggable Offsets for FAB Icon
    var fabOffsetX by remember { mutableFloatStateOf(0f) }
    var fabOffsetY by remember { mutableFloatStateOf(0f) }

    // 2D Draggable Offsets for Open Chat Window Box
    var windowOffsetX by remember { mutableFloatStateOf(0f) }
    var windowOffsetY by remember { mutableFloatStateOf(0f) }

    // Guided Interactive Flow States
    var activeFlow by remember { mutableStateOf("NONE") } // "NONE", "PLAYER", "TURF"
    var playerStep by remember { mutableIntStateOf(1) } // 1: Position, 2: Area, 3: Style
    var turfStep by remember { mutableIntStateOf(1) }   // 1: Area, 2: Budget, 3: Format

    var selPos by remember { mutableStateOf("") }
    var selPlayerArea by remember { mutableStateOf("") }
    var selTurfArea by remember { mutableStateOf("") }
    var selTurfBudget by remember { mutableStateOf("") }

    fun triggerGoalDismissAnimation() {
        isChatOpen = false
        windowOffsetX = 0f
        windowOffsetY = 0f
        showGoalAnimation = true
    }

    LaunchedEffect(showGoalAnimation) {
        if (showGoalAnimation) {
            delay(80) // 80 ms goal animation duration
            showGoalAnimation = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        contentAlignment = if (!isChatOpen) Alignment.BottomEnd else Alignment.Center
    ) {
        // Lower 1/4 Screen GOAL Scoring Animation Overlay
        if (showGoalAnimation) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .height(95.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFB6FF3B))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "GOAL!",
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "PULLPADAM AI MATCHMAKER",
                        color = Color.Black,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }

        if (!isChatOpen && isFabVisible) {
            // Neon-Green Football Pitch Emblem FAB with "ASK"
            Box(
                modifier = Modifier
                    .padding(bottom = 20.dp, end = 20.dp)
                    .offset { IntOffset(fabOffsetX.roundToInt(), fabOffsetY.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragEnd = {
                                if (fabOffsetY > 120f) {
                                    isFabVisible = false
                                    fabOffsetY = 0f
                                    fabOffsetX = 0f
                                    triggerGoalDismissAnimation()
                                }
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                fabOffsetX += dragAmount.x
                                fabOffsetY += dragAmount.y
                            }
                        )
                    }
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFB6FF3B))
                    .clickable { isChatOpen = true }
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val radius = size.minDimension / 2
                    drawCircle(
                        color = Color(0xFF151917),
                        radius = radius * 0.88f,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx())
                    )
                    drawLine(
                        color = Color(0xFF151917),
                        start = androidx.compose.ui.geometry.Offset(0f, size.height / 2),
                        end = androidx.compose.ui.geometry.Offset(size.width, size.height / 2),
                        strokeWidth = 2.dp.toPx()
                    )
                }

                Text(
                    text = "ASK",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )
            }
        } else if (isChatOpen) {
            // Freely Movable Chatbot Window (Touch & drag anywhere on screen)
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .offset { IntOffset(windowOffsetX.roundToInt(), windowOffsetY.roundToInt()) }
                    .fillMaxWidth(0.95f)
                    .height(510.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .background(Color(0xFF151917))
                    .padding(14.dp)
            ) {
                Column {
                    // Draggable Top Header Handle Bar
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF1B201D))
                            .pointerInput(Unit) {
                                detectDragGestures(
                                    onDragEnd = {
                                        if (windowOffsetY > 220f) {
                                            triggerGoalDismissAnimation()
                                        }
                                    },
                                    onDrag = { change, dragAmount ->
                                        change.consume()
                                        windowOffsetX += dragAmount.x
                                        windowOffsetY += dragAmount.y
                                    }
                                )
                            }
                            .padding(vertical = 8.dp, horizontal = 12.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .width(36.dp)
                                    .height(4.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(Color(0xFFB6FF3B))
                            )
                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text("PULLPADAM AI ASSISTANT", color = Color(0xFFB6FF3B), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 0.8.sp)
                                    Text("DRAG TO POSITION • SWIPE DOWN TO CLOSE", color = Color(0xFF9A9F9C), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(Color(0xFF24321B))
                                        .clickable {
                                            triggerGoalDismissAnimation()
                                        }
                                        .padding(horizontal = 10.dp, vertical = 5.dp)
                                ) {
                                    Text("CLOSE", color = Color(0xFFB6FF3B), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // GUIDED CHOICE CHIPS BAR
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        when (activeFlow) {
                            "NONE" -> {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF202521))
                                        .clickable {
                                            activeFlow = "PLAYER"
                                            playerStep = 1
                                            viewModel.sendChatMessage("I'd like to find players. Which position are you looking for?")
                                        }
                                        .padding(horizontal = 8.dp, vertical = 5.dp)
                                ) {
                                    Text("⚽ Find Players", color = Color(0xFFB6FF3B), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF202521))
                                        .clickable {
                                            activeFlow = "TURF"
                                            turfStep = 1
                                            viewModel.sendChatMessage("Let's search for turfs & available slots! Which area are you looking for a turf in?")
                                        }
                                        .padding(horizontal = 8.dp, vertical = 5.dp)
                                ) {
                                    Text("🏟️ Turf Slots", color = Color(0xFFB6FF3B), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xFF202521))
                                        .clickable {
                                            viewModel.sendChatMessage("Who is available in my team right now?")
                                        }
                                        .padding(horizontal = 8.dp, vertical = 5.dp)
                                ) {
                                    Text("👥 My Team", color = Color.White, fontSize = 9.sp)
                                }
                            }

                            "PLAYER" -> {
                                when (playerStep) {
                                    1 -> listOf("Midfielder", "Striker", "Defender", "Goalkeeper", "Winger").forEach { pos ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    selPos = pos
                                                    playerStep = 2
                                                    viewModel.sendChatMessage("Selected: $pos. Which area/location should we search in?")
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(pos, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }

                                    2 -> listOf("Kannur", "Thana", "Valapattanam", "All Areas").forEach { area ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    selPlayerArea = if (area == "All Areas") "" else area
                                                    playerStep = 3
                                                    viewModel.sendChatMessage("Selected: $area. What playing style or compatibility do you prefer?")
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(area, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }

                                    3 -> listOf("High Match 90%+", "Box-to-Box", "Counter-Attacker").forEach { style ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    viewModel.sendChatMessage("FILTER_PLAYER:$selPos|$selPlayerArea|$style")
                                                    activeFlow = "NONE"
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(style, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }

                            "TURF" -> {
                                when (turfStep) {
                                    1 -> listOf("Kannur Town", "Thana", "South Bazar", "Valapattanam").forEach { area ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    selTurfArea = area
                                                    turfStep = 2
                                                    viewModel.sendChatMessage("Selected area: $area. What is your budget range?")
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(area, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }

                                    2 -> listOf("₹1,000 - ₹1,500", "₹1,500 - ₹2,000", "₹2,000 - ₹2,500").forEach { budget ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    selTurfBudget = budget
                                                    turfStep = 3
                                                    viewModel.sendChatMessage("Budget: $budget. Which pitch format?")
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(budget, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }

                                    3 -> listOf("5v5", "7v7", "11v11").forEach { format ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(Color(0xFF202521))
                                                .clickable {
                                                    viewModel.sendChatMessage("FILTER_TURF:$selTurfArea|$selTurfBudget|$format")
                                                    activeFlow = "NONE"
                                                }
                                                .padding(horizontal = 6.dp, vertical = 4.dp)
                                        ) {
                                            Text(format, color = Color(0xFFB6FF3B), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF1B201D))
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        messages.forEach { msg ->
                            FloatingChatMessageBubble(msg)
                            Spacer(modifier = Modifier.height(6.dp))
                        }

                        if (isChatLoading) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                CircularProgressIndicator(modifier = Modifier.size(14.dp), color = Color(0xFFB6FF3B), strokeWidth = 2.dp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("AI reading live app data...", color = Color(0xFF9A9F9C), fontSize = 10.sp)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = userText,
                            onValueChange = { userText = it },
                            placeholder = { Text("Ask slots, players, roster, drills...", color = Color(0xFF9A9F9C), fontSize = 10.sp) },
                            modifier = Modifier.weight(1f).height(46.dp),
                            shape = RoundedCornerShape(10.dp),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFFB6FF3B),
                                unfocusedBorderColor = Color(0xFF303833),
                                focusedContainerColor = Color(0xFF1B201D),
                                unfocusedContainerColor = Color(0xFF1B201D),
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                            keyboardActions = KeyboardActions(onSend = {
                                if (userText.isNotBlank()) {
                                    viewModel.sendChatMessage(userText)
                                    userText = ""
                                }
                            })
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Box(
                            modifier = Modifier
                                .height(46.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFB6FF3B))
                                .clickable {
                                    if (userText.isNotBlank()) {
                                        viewModel.sendChatMessage(userText)
                                        userText = ""
                                    }
                                }
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("SEND", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FloatingChatMessageBubble(message: AIChatMessage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.isUser) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = if (message.isUser) 10.dp else 2.dp,
                        bottomEnd = if (message.isUser) 2.dp else 10.dp
                    )
                )
                .background(if (message.isUser) Color(0xFFB6FF3B) else Color(0xFF28302A))
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Text(
                text = message.text,
                color = if (message.isUser) Color.Black else Color.White,
                fontSize = 10.sp,
                lineHeight = 15.sp
            )
        }
    }
}

