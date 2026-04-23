package com.example.openningscreen.presentation.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.openningscreen.data.Repository.UserRepository
import com.example.openningscreen.presentation.viewmodel.LoginViewModel

class LoginViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}