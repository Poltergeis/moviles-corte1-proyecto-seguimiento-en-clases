package com.example.myapplicationexample1.login.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationexample1.login.domain.usecase.LoginUseCase
import com.example.myapplicationexample1.login.presentation.viewmodel.LoginViewModel

class LoginViewModelFactory(
    private val loginUseCase: LoginUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginUseCase = loginUseCase) as T
    }
}