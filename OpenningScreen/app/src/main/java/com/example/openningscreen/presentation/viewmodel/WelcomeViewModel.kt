package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.presentation.event.WelcomeEvent
import com.example.openningscreen.presentation.state.WelcomeUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {
    private val _event = MutableSharedFlow<WelcomeEvent>()
    val event = _event.asSharedFlow()

    fun loginClick() {
        viewModelScope.launch {
            _event.emit(WelcomeEvent.NavigationLogin)
        }
    }


    fun registerClick() {
        viewModelScope.launch {
            _event.emit(WelcomeEvent.NavigationRegister)
        }
    }

}