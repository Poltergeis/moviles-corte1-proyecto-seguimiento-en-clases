package com.example.myapplicationexample1.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplicationexample1.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): ViewModel() {
    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun setUsername(value: String){
        this._username.value = value
    }

    fun setPassword(value: String){
        this._password.value = value
    }

    fun login(){
        loginUseCase()
    }
}