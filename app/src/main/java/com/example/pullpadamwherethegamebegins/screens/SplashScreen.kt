package com.example.pullpadamwherethegamebegins.screens

/* added*/
import androidx.compose.ui.unit.dp
/* added*/

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {

    var showLogo by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {

        delay(400)
        showLogo = true

        delay(2200)
        onSplashFinished()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(
            visible = showLogo,
            enter = fadeIn() + scaleIn()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "⚽",
                    fontSize = 64.sp
                )

                Spacer(
                    modifier = Modifier.height(22.dp)
                )

                Text(
                    text = "PULLPADAM",
                    color = PullpadamGreen,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 3.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Where the Game Begins",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.sp
                )
            }
        }
    }
}