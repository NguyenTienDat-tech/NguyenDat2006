package com.example.openningscreen.presentation.event

sealed class WelcomeEvent {
    object NavigationLogin: WelcomeEvent()
    object NavigationRegister: WelcomeEvent()
}