package com.universae.criptofolio.services

import com.universae.criptofolio.model.Coin
import com.universae.criptofolio.model.CoinLatest
import com.universae.criptofolio.model.CriptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = "1932720d-3a62-45c4-81f1-841c9735afd7"

interface CriptoApiService {
    @Headers("X-CMC_PRO_API_KEY: $API_KEY")
    @GET("v1/cryptocurrency/map?sort=id")
    suspend fun getCoinList(
        @Query("start") start: Int,
        @Query("limit") limit: Int
    ): Response<CriptoResponse<Coin>>

    @Headers("X-CMC_PRO_API_KEY: $API_KEY")
    @GET("v2/cryptocurrency/quotes/latest?symbol=btc,hbar")
    suspend fun getCoinList(
        @Query("symbol") simbols: String,
    ): Response<CriptoResponse<CoinLatest>>
}

/*
object CriptoApiServiceFactory
{
    fun makeCriptoApiService() : CriptoApiService {
        return Retrofit.Builder()
            .baseUrl("")

            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CriptoApiService::class.java)
    }
}

 */