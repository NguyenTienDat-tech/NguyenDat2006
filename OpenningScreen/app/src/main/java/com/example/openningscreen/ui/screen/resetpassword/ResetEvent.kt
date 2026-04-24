package com.example.openningscreen.ui.screen.resetpassword

sealed class ResetEvent {
    object NavigationOTP: ResetEvent()
    object NavigationSuccess: ResetEvent()
}