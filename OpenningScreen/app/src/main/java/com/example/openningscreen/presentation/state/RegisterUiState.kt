package com.example.openningscreen.presentation.state

data class RegisterUiState (
    val isPasswordVisible: Boolean = false,
    val navigationLogin: Boolean = false,


    val name: String = "",
    val email: String = "",
    val password: String = ""
)