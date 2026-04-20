package com.example.openningscreen.presentation.event

sealed class ForgotEvent {
    object NavigationOTP: ForgotEvent()
    object NavigationLogin: ForgotEvent()
}