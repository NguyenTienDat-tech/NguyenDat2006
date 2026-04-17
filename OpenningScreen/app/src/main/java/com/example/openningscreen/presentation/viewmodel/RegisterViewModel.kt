package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.RegisterUiState

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableLiveData(RegisterUiState())
    val uiState: LiveData<RegisterUiState> = _uiState


    //changePassword
    fun changePassword() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(isPasswordVisible = !current.isPasswordVisible)
    }

    //navigationLogin
    fun loginClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationLogin = true)
    }

    fun doneLogin() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationLogin = false)
    }

    //inputName
    fun onNameChange(name: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(name = name)
    }

    //inputEmail
    fun onEmailChange(email: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(email = email)
    }

    //inputPassword
    fun onPasswordChange(password: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(password = password)
    }
}