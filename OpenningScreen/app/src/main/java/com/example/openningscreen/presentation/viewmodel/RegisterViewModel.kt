package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.presentation.event.RegisterEvent
import com.example.openningscreen.presentation.state.RegisterUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    //stateFlow
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    //eventFlow
    private val _event = MutableSharedFlow<RegisterEvent>()
    val event = _event.asSharedFlow()


    //changePassword
    fun changePassword() {
        _uiState.value = _uiState.value.copy(isPasswordVisible = !_uiState.value.isPasswordVisible)
    }

    //navigationLogin
    fun loginClick() {
        viewModelScope.launch {
            _event.emit(RegisterEvent.NavigationLogin)
        }
    }

    //inputName
    fun onNameChange(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    //inputEmail
    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    //inputPassword
    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }
}