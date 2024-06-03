package com.universae.criptofolio.data.network

import com.universae.criptofolio.CriptofolioApp.Companion.prefs
import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.data.database.dao.CriptofolioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{

        val client = OkHttpClient.Builder()
            .addInterceptor(APIKeyInterceptor())
            .build()

       return Retrofit

           .Builder().baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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


    private fun apiKeyAsHeader(it: Interceptor.Chain) = it.proceed(
        it.request()
            .newBuilder()
            .addHeader("x-cg-demo-api-key", prefs.getApiKey())
            .build()
    )
}

class APIKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val currentUrl = chain.request().url()
        val newUrl = currentUrl.newBuilder().addQueryParameter("x-cg-demo-api-key", prefs.getApiKey()).build()
        val currentRequest = chain.request().newBuilder()
        val newRequest = currentRequest.url(newUrl).build()
        return chain.proceed(newRequest)
    }
}