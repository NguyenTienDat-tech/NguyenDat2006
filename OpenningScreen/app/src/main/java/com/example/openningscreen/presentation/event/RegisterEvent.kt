package com.example.openningscreen.presentation.event

sealed class RegisterEvent {
    object NavigationLogin: RegisterEvent()
}