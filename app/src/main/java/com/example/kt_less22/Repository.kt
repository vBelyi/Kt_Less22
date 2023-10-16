package com.example.kt_less22

import com.example.kt_less22.api_service.ApiClient
import com.example.kt_less22.api_service.ApiInterface
import com.example.kt_less22.api_service.HeroResponse
import retrofit2.Response

class Repository (private val client: ApiClient) {
    suspend fun getHeroes(): List<HeroResponse> {
        val apiInterface = client.client.create(ApiInterface::class.java)
        return apiInterface.getHeroesRequest()
    }
}