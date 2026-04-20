package com.example.openningscreen.presentation.event

sealed class OtpEvent {
    object NavigationForgot: OtpEvent()
    object NavigationReset: OtpEvent()
}