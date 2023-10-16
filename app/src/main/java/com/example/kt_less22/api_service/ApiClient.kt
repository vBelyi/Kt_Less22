package com.example.kt_less22.api_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiClient @Inject constructor(){
    val client = Retrofit.Builder()
        .baseUrl("https://akabab.github.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}