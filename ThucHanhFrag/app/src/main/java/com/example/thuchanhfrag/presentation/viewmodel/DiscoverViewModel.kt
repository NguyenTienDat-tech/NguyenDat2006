package com.example.thuchanhfrag.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.presentation.state.BaoMoi
import com.example.thuchanhfrag.presentation.state.BaoMoiUniState

class DiscoverViewModel : ViewModel() {

    private val fakeList = mutableListOf(
        BaoMoi(R.drawable.anh1),
        BaoMoi(R.drawable.anh2),
        BaoMoi(R.drawable.anh3),
        BaoMoi(R.drawable.anh4),
        BaoMoi(R.drawable.anh5),
        BaoMoi(R.drawable.anh6),
        BaoMoi(R.drawable.anh7),
        BaoMoi(R.drawable.anh8)
    )

    private val _uiState = MutableLiveData(BaoMoiUniState(list = fakeList))
    val uiState: LiveData<BaoMoiUniState> = _uiState


    fun onAnh1Click() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationTextAnh1 = true)
    }

    fun doneAnh1() {
        val current = _uiState.value ?: return
        _uiState.value = current.copy(navigationTextAnh1 = false)
    }
}