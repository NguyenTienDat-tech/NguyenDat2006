package com.example.openningscreen.presentation.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openningscreen.data.Repository.UserRepository
import com.example.openningscreen.presentation.event.LoginEvent
import com.example.openningscreen.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
): ViewModel() {
    //StateFlow
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()


    //Event
    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()


    //changePassword
    fun changePassword() {
        _uiState.value = _uiState.value.copy(isPasswordVisible = !_uiState.value.isPasswordVisible)
    }

    //navigationRegister
    fun registerClick() {
        viewModelScope.launch {
            _event.emit(LoginEvent.NavigationRegister)
        }
    }


    //navigationForgot
    fun forgotCLick() {
        viewModelScope.launch {
            _event.emit(LoginEvent.NavigationForgot)
        }
    }

    //InputEmail
    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    //InputPassword
    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    //đăng nhập login
    fun onLoginClick() {
        viewModelScope.launch {
            val email = _uiState.value.email.trim()
            val password = _uiState.value.password.trim()

            //check trùng
            val success = repository.login(_uiState.value.email.trim(), _uiState.value.password.trim())

            //check email, pasword
            if (email.isEmpty() || password.isEmpty()) {
            _event.emit(LoginEvent.Null("Vui lòng nhập đầy đủ thông tin"))
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _event.emit(LoginEvent.CheckEmail("Nhập không đúng email. Nhập lại!"))
            }
            else if (success){
                _event.emit(LoginEvent.NavigationHome)
            }
            else {
                _event.emit(LoginEvent.Error("Tài khoản không tồn tại"))
            }
        }
    }

}