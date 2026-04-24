package com.example.openningscreen.ui.screen.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ForgotViewModel : ViewModel() {
    //event
    private val _event = MutableSharedFlow<ForgotEvent>()
    val event = _event.asSharedFlow()


    //navigationOTP
    fun otpClick() {
        viewModelScope.launch {
            _event.emit(ForgotEvent.NavigationOTP)
        }
    }

    //navigationLogin
    fun loginClick() {
        viewModelScope.launch {
            _event.emit(ForgotEvent.NavigationLogin)
        }
    }

}