package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuchanhfrag.presentation.state.BankingUiState
import com.example.thuchanhfrag.presentation.state.MayTinhUiState

class BankingViewModel : ViewModel() {
    private val _uiState = MutableLiveData(BankingUiState())
    val uiState: LiveData<BankingUiState> = _uiState

    fun onHomeClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = true)
    }

    fun doneHome() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = false)
    }
}