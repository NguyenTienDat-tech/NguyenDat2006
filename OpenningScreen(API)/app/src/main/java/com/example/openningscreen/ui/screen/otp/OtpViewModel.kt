package com.example.openningscreen.ui.screen.otp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OtpViewModel(
    private val repository: UserRepository
) : ViewModel() {
    //state
    private val _uiState = MutableStateFlow(OtpUiState())
    val uiState = _uiState.asStateFlow()

    //event
    private val _event = MutableSharedFlow<OtpEvent>()
    val event = _event.asSharedFlow()

    //navigationForgot
    fun forgotClick() {
        viewModelScope.launch {
            _event.emit(OtpEvent.NavigationForgot)
        }
    }

    fun input1(otp: String) {
        _uiState.value = _uiState.value.copy(otp1 = otp)
    }

    fun input2(otp: String) {
        _uiState.value = _uiState.value.copy(otp2 = otp)
    }

    fun input3(otp: String) {
        _uiState.value = _uiState.value.copy(otp3 = otp)
    }

    fun input4(otp: String) {
        _uiState.value = _uiState.value.copy(otp4 = otp)
    }

    //navigationReset
    fun resetClick(email: String) {
        val otp = _uiState.value.otp1 + _uiState.value.otp2 + _uiState.value.otp3 + _uiState.value.otp4

        viewModelScope.launch {
            val success = repository.otp(email, otp)

            Log.d("OTP", "after repository = $success")

            if (success) {
                _event.emit(OtpEvent.NavigationResetSendEmail(email))
            }
            else {
                _event.emit(OtpEvent.Null("Otp không tồn tại"))
            }
        }
    }
}

