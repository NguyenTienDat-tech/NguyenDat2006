package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.OtpUiState

class OtpViewModel : ViewModel() {
    private val _uiState = MutableLiveData(OtpUiState())
    val uiState: LiveData<OtpUiState> = _uiState

    //navigationForgot
    fun forgotClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationForgot = true)
    }

    fun doneForgot() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationForgot = false)
    }

    //navigationReset
    fun resetClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationReset = true)
    }

    fun doneReset() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationReset = false)
    }
}