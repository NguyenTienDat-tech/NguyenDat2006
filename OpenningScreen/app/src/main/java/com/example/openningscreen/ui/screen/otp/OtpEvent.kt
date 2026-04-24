package com.example.openningscreen.ui.screen.otp

sealed class OtpEvent {
    object NavigationForgot: OtpEvent()
    object NavigationReset: OtpEvent()
}