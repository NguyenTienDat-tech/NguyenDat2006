package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuchanhfrag.presentation.state.Tag1UiState

class Tag1ViewModel : ViewModel() {
    private val _uiState = MutableLiveData(Tag1UiState())
    val uiState: LiveData<Tag1UiState> = _uiState

    fun onMayTinhClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationMayTinh = true)
    }

    fun doneMayTinh() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationMayTinh = false)
    }

    fun onLoanClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationLoan = true)
    }

    fun doneLoan() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationLoan = false)
    }

    fun onBankingClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationBanking = true)
    }

    fun doneBanking() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationBanking = false)
    }

    fun onOtherClick() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOther = true)
    }

    fun doneOther() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationOther = false)
    }

}