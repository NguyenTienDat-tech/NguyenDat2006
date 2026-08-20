package com.example.openningscreencompose.ui.screens.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openningscreencompose.R
import com.example.openningscreencompose.ui.components.AppButton
import com.example.openningscreencompose.ui.components.AppTextField
import com.example.openningscreencompose.ui.theme.color_primary
import com.example.openningscreencompose.ui.theme.color_text_tittle

@Composable
fun LoginScreen(
    onNavigationToRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hi, Welcome!",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color_text_tittle,
        )

        Spacer(modifier = Modifier.height(24.dp))

        var emailText by remember { mutableStateOf("") }
        AppTextField(
            label = "Email address",
            placeholder = "helloworld@gmail.com",
            value = emailText,
            onValueChange = { newValue ->
                emailText = newValue
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        var passwordText by remember { mutableStateOf("") }
        AppTextField(
            label = "Password",
            placeholder = "123456789",
            value = passwordText,
            onValueChange = { newValue ->
                passwordText = newValue
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Forgot password?",
            fontSize = 14.sp,
            color = color_text_tittle,
            modifier = Modifier
                .align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(38.dp))

        AppButton(
            text = "Log in",
            onClick = {

            },
        )

        Spacer(modifier = Modifier.height(92.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don’t have an account?",
                fontSize = 14.sp,
                color = color_text_tittle
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Sign up",
                fontSize = 14.sp,
                color = color_primary,
                modifier = Modifier.clickable {
                    onNavigationToRegister()
                }
            )
        }

    }
}