package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuchanhfrag.presentation.state.BankingUiState
import com.example.thuchanhfrag.presentation.state.OtherUiState

class OtherViewModel : ViewModel() {
    private val _uiState = MutableLiveData(OtherUiState())
    val uiState: LiveData<OtherUiState> = _uiState

    fun onHomeClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = true)
    }

    fun doneHome() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationHome = false)
    }
}