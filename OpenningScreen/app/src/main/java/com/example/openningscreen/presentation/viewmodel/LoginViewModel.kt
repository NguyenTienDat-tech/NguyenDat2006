package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.presentation.event.LoginEvent
import com.example.openningscreen.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    //StateFlow
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    //Event
    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()


    //changePassword
    fun changePassword() {
        _uiState.value = _uiState.value.copy(isPasswordVisible = !_uiState.value.isPasswordVisible)
    }

    //navigationRegister
    fun registerClick() {
        viewModelScope.launch {
            _event.emit(LoginEvent.NavigationRegister)
        }
    }


    //navigationForgot
    fun forgotCLick() {
        viewModelScope.launch {
            _event.emit(LoginEvent.NavigationForgot)
        }
    }


    //InputEmail
    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    //InputPassword
    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

}