package com.example.openningscreencompose.ui.screens

import android.R.attr.tint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openningscreencompose.R
import com.example.openningscreencompose.ui.components.AppButton
import com.example.openningscreencompose.ui.theme.color_background
import com.example.openningscreencompose.ui.theme.color_text_content
import com.example.openningscreencompose.ui.theme.color_text_tittle

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(400.dp),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Explore the app",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color_text_tittle,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Now your finances are in one place\nand always under control",
            fontSize = 15.sp,
            color = color_text_tittle,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        AppButton(
            text = "Sign In",
            onClick = {

            },
            isOutlined = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            text = "Create account",
            onClick = {

            }
        )
    }
}