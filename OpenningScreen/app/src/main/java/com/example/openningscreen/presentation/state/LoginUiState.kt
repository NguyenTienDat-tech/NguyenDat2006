package com.example.openningscreen.presentation.state

data class LoginUiState (
    val isPasswordVisible: Boolean = false,
    val navigationRegister: Boolean = false,
    val navigationForgot: Boolean = false,

    val email: String = "",
    val password: String = "",
)