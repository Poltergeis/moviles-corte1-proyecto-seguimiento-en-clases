package com.example.myapplicationexample1.api_consumer.data.api

import com.example.myapplicationexample1.api_consumer.domain.models.DBCharacter

data class Response(
    val items: List<DBCharacter>
)
