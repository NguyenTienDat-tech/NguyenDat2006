package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.ForgotUiState

class ForgotViewModel : ViewModel() {
    private val _uiState = MutableLiveData(ForgotUiState())
    val uiState: LiveData<ForgotUiState> = _uiState

    //navigationOTP
    fun otpClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOTP = true)
    }

    fun doneOTP() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOTP = false)
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
}