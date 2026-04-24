package com.example.openningscreen.ui.screen.otp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OtpViewModel : ViewModel() {
    //event
    private val _event = MutableSharedFlow<OtpEvent>()
    val event = _event.asSharedFlow()

    //navigationForgot
    fun forgotClick() {
        viewModelScope.launch {
            _event.emit(OtpEvent.NavigationForgot)
        }
    }


    //navigationReset
    fun resetClick() {
        viewModelScope.launch {
            _event.emit(OtpEvent.NavigationReset)
        }
    }

}