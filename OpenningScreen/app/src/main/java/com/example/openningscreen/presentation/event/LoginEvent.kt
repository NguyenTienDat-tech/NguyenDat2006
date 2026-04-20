package com.example.openningscreen.presentation.event

sealed class LoginEvent {
    object NavigationRegister: LoginEvent()
    object NavigationForgot: LoginEvent()
}