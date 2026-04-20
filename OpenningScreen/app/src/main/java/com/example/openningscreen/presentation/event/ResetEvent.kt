package com.example.openningscreen.presentation.event

sealed class ResetEvent {
    object NavigationOTP: ResetEvent()
    object NavigationSuccess: ResetEvent()
}