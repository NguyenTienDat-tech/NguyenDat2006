package com.example.openningscreen.presentation.event

sealed class RegisterEvent {
    object NavigationLogin: RegisterEvent()

    data class Error(val text: String): RegisterEvent()
    data class CheckEmail(val text: String): RegisterEvent()
    data class Null(val text: String): RegisterEvent()
}