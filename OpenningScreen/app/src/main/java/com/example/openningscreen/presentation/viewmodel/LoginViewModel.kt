package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.LoginUiState

class LoginViewModel: ViewModel() {
    private val _uiState = MutableLiveData(LoginUiState())
    val uiState: LiveData<LoginUiState> = _uiState

    //changePassword
    fun changePassword() {
        val current = _uiState.value ?: return //trạng thái hiện tại
        _uiState.value = current.copy(isPasswordVisible = !current.isPasswordVisible)
    }

    //navigationRegister
    fun registerClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationRegister = true)
    }

    fun doneRegister() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationRegister = false)
    }

    //navigationForgot
    fun forgotCLick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationForgot = true)
    }

    fun doneForgot() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationForgot = false)
    }

    //InputEmail
    fun onEmailChange(email: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(email = email)
    }

    //InputPassword
    fun onPasswordChange(password: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(password = password)
    }

}