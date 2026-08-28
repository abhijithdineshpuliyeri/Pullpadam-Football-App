package com.example.pullpadamwherethegamebegins.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PullpadamBackground = Color(0xFF0B0D0C)
private val PullpadamGreen = Color(0xFFB6FF3B)
private val PullpadamCard = Color(0xFF151917)
private val PullpadamGray = Color(0xFF9A9F9C)

@Composable
fun CreateAccountScreen(
    onAccountCreated: () -> Unit
) {

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PullpadamBackground)
            .padding(horizontal = 24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "⚽",
            fontSize = 50.sp
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "CREATE ACCOUNT",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 1.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Join the PULLPADAM community",
            color = PullpadamGray,
            fontSize = 14.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Full name",
                    color = PullpadamGray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = PullpadamGreen,
                unfocusedBorderColor = Color(0xFF303532),
                cursorColor = PullpadamGreen,
                focusedContainerColor = PullpadamCard,
                unfocusedContainerColor = PullpadamCard
            )
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Email",
                    color = PullpadamGray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = PullpadamGreen,
                unfocusedBorderColor = Color(0xFF303532),
                cursorColor = PullpadamGreen,
                focusedContainerColor = PullpadamCard,
                unfocusedContainerColor = PullpadamCard
            )
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Password",
                    color = PullpadamGray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = PullpadamGreen,
                unfocusedBorderColor = Color(0xFF303532),
                cursorColor = PullpadamGreen,
                focusedContainerColor = PullpadamCard,
                unfocusedContainerColor = PullpadamCard
            )
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = {
                onAccountCreated()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PullpadamGreen,
                contentColor = Color.Black
            )
        ) {

            Text(
                text = "CREATE ACCOUNT",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.sp
            )
        }
    }
}