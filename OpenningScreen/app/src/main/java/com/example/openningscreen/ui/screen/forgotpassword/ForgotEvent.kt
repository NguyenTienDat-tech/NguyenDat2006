package com.example.openningscreen.ui.screen.forgotpassword

sealed class ForgotEvent {
    object NavigationOTP: ForgotEvent()
    object NavigationLogin: ForgotEvent()
}