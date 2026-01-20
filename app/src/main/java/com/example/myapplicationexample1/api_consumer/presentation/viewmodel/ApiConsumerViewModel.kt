package com.example.myapplicationexample1.api_consumer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationexample1.api_consumer.data.api.ApiClient
import com.example.myapplicationexample1.api_consumer.domain.models.DBCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiConsumerViewModel: ViewModel() {
    private var _characters = MutableStateFlow<List<DBCharacter>>(emptyList())
    val characters: StateFlow<List<DBCharacter>> = _characters

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            val response = ApiClient.apiService.getCharacters()
            _characters.value = response.items
        }
    }
}