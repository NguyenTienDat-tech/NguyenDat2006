package com.example.openningscreen.presentation.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.data.Repository.UserRepository
import com.example.openningscreen.presentation.event.LoginEvent
import com.example.openningscreen.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
): ViewModel() {
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

    //navigationHome
    fun homeClick() {
        viewModelScope.launch {
            _event.emit(LoginEvent.NavigationHome)
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

    //đăng nhập login
    fun onLoginClick() {
        viewModelScope.launch {

            val success = repository.login(_uiState.value.email.trim(), _uiState.value.password.trim())

            if (success) {
                _event.emit(LoginEvent.NavigationHome)
            }
            else {
                _event.emit(LoginEvent.Error("Tai khoan khong ton tai!"))
            }

        }
    }

}