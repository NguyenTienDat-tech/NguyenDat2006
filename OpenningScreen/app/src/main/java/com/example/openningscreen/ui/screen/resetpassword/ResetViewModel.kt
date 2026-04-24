package com.example.openningscreen.ui.screen.resetpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResetViewModel : ViewModel() {
    //stateFlow
    private val _uiState = MutableStateFlow(ResetUiState())
    val uiState = _uiState.asStateFlow()

    //event
    private val _event = MutableSharedFlow<ResetEvent>()
    val event = _event.asSharedFlow()

    //changePassword
    fun changePassword() {
        _uiState.value = _uiState.value.copy(isPasswordVisible = !_uiState.value.isPasswordVisible)
    }

    //changePassword1
    fun changePassword1() {
        _uiState.value = _uiState.value.copy(isPasswordVisible1 = !_uiState.value.isPasswordVisible1)
    }

    //navigationSuccesspassword
    fun successClick() {
        viewModelScope.launch {
            _event.emit(ResetEvent.NavigationSuccess)
        }
    }

    //navigationOTP
    fun otpClick() {
        viewModelScope.launch {
            _event.emit(ResetEvent.NavigationOTP)
        }
    }


    //inputPassword
    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    //inputPassword1
    fun onPasswordChange1(password1: String) {
        _uiState.value = _uiState.value.copy(password1 = password1)
    }
}