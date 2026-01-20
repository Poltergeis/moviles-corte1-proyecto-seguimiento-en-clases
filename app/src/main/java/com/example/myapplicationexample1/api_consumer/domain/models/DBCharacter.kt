package com.example.myapplicationexample1.api_consumer.domain.models

data class DBCharacter(
    val id: UInt,
    val name: String,
    val ki: String,
    val race: String,
    val affiliation: String,
    val imageURL: String
)