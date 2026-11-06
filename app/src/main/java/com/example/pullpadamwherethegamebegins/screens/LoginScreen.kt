package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

private val PullpadamGray =
    Color(0xFF9A9F9C)

private val PullpadamBorder =
    Color(0xFF303532)


// =============================================================
// LOGIN SCREEN
// =============================================================

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onCreateAccount: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                PullpadamBackground
            )
            .padding(
                horizontal = 24.dp
            ),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {


        // =====================================================
        // LOGO
        // =====================================================

        Spacer(
            modifier =
                Modifier.height(45.dp)
        )


        Image(

            painter =
                painterResource(
                    id =
                        R.drawable.pullpadam_logo
                ),

            contentDescription =
                "PULLPADAM Logo",

            modifier =
                Modifier.size(
                    155.dp
                )
        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // WELCOME
        // =====================================================

        Text(

            text =
                "Welcome Back",

            color =
                Color.White,

            fontSize =
                28.sp,

            fontWeight =
                FontWeight.Bold
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        Text(

            text =
                "Ready for your next game?",

            color =
                PullpadamGray,

            fontSize =
                14.sp
        )


        Spacer(
            modifier =
                Modifier.height(35.dp)
        )


        // =====================================================
        // EMAIL LABEL
        // =====================================================

        Text(

            text =
                "EMAIL OR PHONE",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                12.sp,

            fontWeight =
                FontWeight.Bold,

            letterSpacing =
                1.sp
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        // =====================================================
        // EMAIL FIELD
        // =====================================================

        OutlinedTextField(

            value =
                email,

            onValueChange = {
                email = it
            },

            modifier =
                Modifier.fillMaxWidth(),

            placeholder = {

                Text(

                    text =
                        "Enter your email",

                    color =
                        PullpadamGray
                )
            },

            singleLine =
                true,

            shape =
                RoundedCornerShape(
                    16.dp
                ),

            colors =
                OutlinedTextFieldDefaults.colors(

                    focusedTextColor =
                        Color.White,

                    unfocusedTextColor =
                        Color.White,

                    focusedBorderColor =
                        PullpadamGreen,

                    unfocusedBorderColor =
                        PullpadamBorder,

                    cursorColor =
                        PullpadamGreen,

                    focusedContainerColor =
                        PullpadamCard,

                    unfocusedContainerColor =
                        PullpadamCard
                )
        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )


        // =====================================================
        // PASSWORD LABEL
        // =====================================================

        Text(

            text =
                "PASSWORD",

            modifier =
                Modifier.fillMaxWidth(),

            color =
                PullpadamGray,

            fontSize =
                12.sp,

            fontWeight =
                FontWeight.Bold,

            letterSpacing =
                1.sp
        )


        Spacer(
            modifier =
                Modifier.height(8.dp)
        )


        // =====================================================
        // PASSWORD FIELD
        // =====================================================

        OutlinedTextField(

            value =
                password,

            onValueChange = {
                password = it
            },

            modifier =
                Modifier.fillMaxWidth(),

            placeholder = {

                Text(

                    text =
                        "Enter your password",

                    color =
                        PullpadamGray
                )
            },

            singleLine =
                true,

            visualTransformation =

                if (passwordVisible) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()
                },

            trailingIcon = {

                Text(

                    text =
                        if (passwordVisible) {
                            "HIDE"
                        } else {
                            "SHOW"
                        },

                    color =
                        PullpadamGreen,

                    fontSize =
                        11.sp,

                    fontWeight =
                        FontWeight.Bold,

                    modifier =
                        Modifier
                            .padding(
                                end = 14.dp
                            )
                            .clickable {

                                passwordVisible =
                                    !passwordVisible
                            }
                )
            },

            shape =
                RoundedCornerShape(
                    16.dp
                ),

            colors =
                OutlinedTextFieldDefaults.colors(

                    focusedTextColor =
                        Color.White,

                    unfocusedTextColor =
                        Color.White,

                    focusedBorderColor =
                        PullpadamGreen,

                    unfocusedBorderColor =
                        PullpadamBorder,

                    cursorColor =
                        PullpadamGreen,

                    focusedContainerColor =
                        PullpadamCard,

                    unfocusedContainerColor =
                        PullpadamCard
                )
        )


        Spacer(
            modifier =
                Modifier.height(10.dp)
        )


        // =====================================================
        // FORGOT PASSWORD
        // =====================================================

        Row(

            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.End
        ) {

            Text(

                text =
                    "Forgot Password?",

                color =
                    PullpadamGreen,

                fontSize =
                    13.sp,

                fontWeight =
                    FontWeight.Medium,

                modifier =
                    Modifier.clickable {
                        // Backend functionality will be added later
                    }
            )
        }


        Spacer(
            modifier =
                Modifier.height(25.dp)
        )


        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        Button(

            onClick = {

                onLogin()
            },

            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(55.dp),

            shape =
                RoundedCornerShape(
                    16.dp
                ),

            colors =
                ButtonDefaults.buttonColors(

                    containerColor =
                        PullpadamGreen,

                    contentColor =
                        Color.Black
                )
        ) {

            Text(

                text =
                    "LOGIN",

                fontSize =
                    15.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                letterSpacing =
                    1.sp
            )
        }


        Spacer(
            modifier =
                Modifier.height(22.dp)
        )


        // =====================================================
        // OR DIVIDER
        // =====================================================

        Row(

            modifier =
                Modifier.fillMaxWidth(),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Spacer(

                modifier =
                    Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(
                            PullpadamBorder
                        )
            )


            Text(

                text =
                    "  OR  ",

                color =
                    PullpadamGray,

                fontSize =
                    12.sp
            )


            Spacer(

                modifier =
                    Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(
                            PullpadamBorder
                        )
            )
        }


        Spacer(
            modifier =
                Modifier.height(22.dp)
        )


        // =====================================================
        // CREATE ACCOUNT
        // =====================================================

        Row(

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(

                text =
                    "New to PULLPADAM? ",

                color =
                    PullpadamGray,

                fontSize =
                    13.sp
            )


            Text(

                text =
                    "Create Account",

                color =
                    PullpadamGreen,

                fontSize =
                    13.sp,

                fontWeight =
                    FontWeight.Bold,

                modifier =
                    Modifier.clickable {

                        onCreateAccount()
                    }
            )
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )
    }
}