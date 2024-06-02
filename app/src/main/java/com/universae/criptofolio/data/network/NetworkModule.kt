package com.universae.criptofolio.data.network

import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.data.database.dao.CriptofolioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
       return Retrofit
           .Builder().baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providateCritoApiService(retrofit:Retrofit):CriptoApiService{
        return retrofit.create(CriptoApiService::class.java)
    }

    @Provides
    fun provideRepository(
        criptoApiService: CriptoApiService, criptofolioDao: CriptofolioDao): Repository{
        return Repository(criptoApiService, criptofolioDao)
    }
}