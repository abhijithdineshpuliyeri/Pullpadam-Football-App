package com.example.pullpadamwherethegamebegins

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

import com.example.pullpadamwherethegamebegins.navigation.AppNavigation


class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)


        // =====================================================
        // EDGE-TO-EDGE
        // =====================================================

        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )


        // =====================================================
        // BLACK SYSTEM BARS
        // =====================================================

        window.statusBarColor =
            android.graphics.Color.BLACK

        window.navigationBarColor =
            android.graphics.Color.BLACK


        // =====================================================
        // REMOVE NAVIGATION BAR CONTRAST
        // =====================================================

        window.isNavigationBarContrastEnforced =
            false


        // =====================================================
        // WHITE SYSTEM BAR ICONS
        // =====================================================

        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).apply {

            isAppearanceLightStatusBars =
                false

            isAppearanceLightNavigationBars =
                false
        }


        // =====================================================
        // APP CONTENT
        // =====================================================

        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFF0B0D0C)
                    )
            ) {

                AppNavigation()
            }
        }
    }
}