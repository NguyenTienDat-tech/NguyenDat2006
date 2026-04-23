package com.example.openningscreen.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.presentation.event.RegisterEvent
import com.example.openningscreen.presentation.event.SuccessEvent
import com.example.openningscreen.presentation.state.RegisterUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SuccessViewModel : ViewModel(){
    private val _event = MutableSharedFlow<SuccessEvent>()
    val event = _event.asSharedFlow()

    fun loginClick() {
        viewModelScope.launch {
            _event.emit(SuccessEvent.NavigationLogin)
        }
    }
}