package com.example.openningscreen.ui.screen.login

sealed class LoginEvent {
    object NavigationRegister: LoginEvent()
    object NavigationForgot: LoginEvent()
    object NavigationHome: LoginEvent()

    data class Error(val text: String): LoginEvent()
    data class CheckEmail(val text: String): LoginEvent()
    data class Null(val text: String): LoginEvent()
}