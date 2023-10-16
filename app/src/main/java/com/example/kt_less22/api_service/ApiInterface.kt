package com.example.kt_less22.api_service

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    suspend fun getHeroesRequest():List<HeroResponse>
}