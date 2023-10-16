package com.example.kt_less22

import com.example.kt_less22.api_service.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class ApplicationModule {

    @Provides
    @Singleton
    fun getApiClient() = ApiClient().client

    @Provides
    @Singleton
    fun getRepository(apiClient: ApiClient) = Repository(apiClient)
}