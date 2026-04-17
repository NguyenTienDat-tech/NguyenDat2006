package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.RegisterUiState

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableLiveData(RegisterUiState())
    val uiState: LiveData<RegisterUiState> = _uiState

    fun changePassword() {
        val current = _uiState.value!!
        _uiState.value = current.copy(isPasswordVisible = !current.isPasswordVisible)
    }

    fun loginClick() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationLogin = true)
    }

    fun doneLogin() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationLogin = false)
    }
}