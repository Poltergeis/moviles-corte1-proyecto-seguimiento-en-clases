package com.example.myapplicationexample1.counter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.reflect.KMutableProperty1
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import kotlin.reflect.KProperty

class CounterViewModel: ViewModel() {
    private var _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> get() = _counter

    fun increment(){
        _counter.value++
    }

    fun decrement(){
        _counter.value--
    }
}