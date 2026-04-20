package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.presentation.event.ForgotEvent
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