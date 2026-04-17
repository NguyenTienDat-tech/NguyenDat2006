package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.WelcomeUiState

class WelcomeViewModel : ViewModel() {
    private val _uiState = MutableLiveData(WelcomeUiState())
    val uiState: LiveData<WelcomeUiState> = _uiState

    fun loginClick() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationLogin = true)
    }

    fun doneLogin() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationLogin = false)
    }

    fun registerClick() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationRegister = true)
    }

    fun doneRegister() {
        val current = _uiState.value!!
        _uiState.value = current.copy(navigationRegister = false)
    }
}