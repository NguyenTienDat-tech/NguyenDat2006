package com.example.openningscreen.presentation.state

data class ResetUiState (
    val isPasswordVisible: Boolean = false,
    val isPasswordVisible1: Boolean = false,
    val navigationSuccess: Boolean = false,
    val navigationOTP: Boolean = false,

    val password: String = "",
    val password1: String = ""
)