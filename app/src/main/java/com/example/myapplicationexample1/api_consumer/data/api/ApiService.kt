package com.example.myapplicationexample1.api_consumer.data.api

import retrofit2.http.GET

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(): Response
}