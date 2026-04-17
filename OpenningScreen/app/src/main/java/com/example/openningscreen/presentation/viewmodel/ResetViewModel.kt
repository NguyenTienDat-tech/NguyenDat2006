package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openningscreen.presentation.state.ResetUiState

class ResetViewModel : ViewModel() {
    private val _uiState = MutableLiveData(ResetUiState())
    val uiState: LiveData<ResetUiState> = _uiState

    //changePassword
    fun changePassword() {
        val current = _uiState.value ?: return //trạng thái hiện tại
        _uiState.value = current.copy(isPasswordVisible = !current.isPasswordVisible)
    }

    //changePassword1
    fun changePassword1() {
        val current = _uiState.value ?: return //trạng thái hiện tại
        _uiState.value = current.copy(isPasswordVisible1 = !current.isPasswordVisible1)
    }

    //navigationSuccesspassword
    fun successClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationSuccess = true)
    }

    fun doneSuccess() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationSuccess = false)
    }

    //navigationOTP
    fun otpClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOTP = true)
    }

    fun doneOtp() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOTP = false)
    }

    //inputPassword
    fun onPasswordChange(password: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(password = password)
    }

    //inputPassword1
    fun onPasswordChange1(password1: String) {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(password1 = password1)
    }
}