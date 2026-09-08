package com.example.openningscreencompose.ui.screens.auth.welcome

sealed class WelcomeEvent {
    object NavigationLogin: WelcomeEvent()
    object NavigationRegister: WelcomeEvent()
}