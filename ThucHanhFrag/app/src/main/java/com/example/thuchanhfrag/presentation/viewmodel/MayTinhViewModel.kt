package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuchanhfrag.presentation.state.LoanUiState
import com.example.thuchanhfrag.presentation.state.MayTinhUiState

class MayTinhViewModel : ViewModel() {
    private val _uiState = MutableLiveData(MayTinhUiState())
    val uiState: LiveData<MayTinhUiState> = _uiState

    fun onHomeClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = true)
    }

    fun doneHome() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = false)
    }
}