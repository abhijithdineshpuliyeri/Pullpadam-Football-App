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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamGray = Color(0xFF9A9F9C)

data class OnboardingPage(
    val icon: String,
    val title: String,
    val description: String
)

@Composable
fun OnboardingScreen(
    onGetStarted: () -> Unit
) {

    val pages = listOf(

        OnboardingPage(
            icon = "🏟️",
            title = "DISCOVER YOUR TURF",
            description = "Find football turfs around you and discover the perfect ground for your next game."
        ),

        OnboardingPage(
            icon = "🤖",
            title = "PLAY SMARTER WITH AI",
            description = "Let PULLPADAM AI find the best turf, time and match based on your preferences."
        ),

        OnboardingPage(
            icon = "🤝",
            title = "NEVER PLAY SHORT",
            description = "Don't have enough players? Connect with another incomplete team and create your game."
        )
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
    ) {

        // Skip

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = "Skip",
                color = PullpadamGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Pages

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->

            OnboardingPageContent(
                page = pages[page]
            )
        }

        // Page indicators

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            repeat(pages.size) { index ->

                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(
                            if (pagerState.currentPage == index)
                                24.dp
                            else
                                7.dp
                        )
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == index)
                                PullpadamGreen
                            else
                                Color(0xFF3A3F3B)
                        )
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Next / Get Started

        Button(
            onClick = {

                if (pagerState.currentPage < pages.lastIndex) {

                    coroutineScope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }

                } else {

                    onGetStarted()
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(56.dp),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = PullpadamGreen,
                contentColor = Color.Black
            )
        ) {

            Text(
                text = if (pagerState.currentPage == pages.lastIndex)
                    "GET STARTED"
                else
                    "NEXT",

                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )
    }
}

@Composable
private fun OnboardingPageContent(
    page: OnboardingPage
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(230.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(PullpadamCard),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = page.icon,
                fontSize = 90.sp
            )
        }

        Spacer(
            modifier = Modifier.height(42.dp)
        )

        Text(
            text = page.title,
            color = Color.White,
            fontSize = 27.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = page.description,
            color = PullpadamGray,
            fontSize = 15.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}