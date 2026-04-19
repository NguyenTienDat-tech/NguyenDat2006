package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _uiState = MutableLiveData<Int>()
    val uiState: LiveData<Int> = _uiState

    init {
        _uiState.value = 0
    }

    fun nextPage(page: Int) {
        _uiState.value = page
    }
    
}