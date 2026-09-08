package com.example.openningscreencompose.ui.screens.auth.login

sealed class LoginEvent {
    object NavigationRegister: LoginEvent()
}