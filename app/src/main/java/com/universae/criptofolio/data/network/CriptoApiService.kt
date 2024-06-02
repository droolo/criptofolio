package com.universae.criptofolio.data.network

import com.universae.criptofolio.data.network.response.CoinPriceResponse
import com.universae.criptofolio.data.network.response.CoinResponse
import com.universae.criptofolio.data.network.response.CryptoData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = "CG-oVmVRdXv6oz9qLTr4wRsmL2b"

interface CriptoApiService {
    @Headers("x-cg-demo-api-key: $API_KEY")
    @GET("coins/list")
    suspend fun getCoinList(): List<CoinResponse>

    @Headers("x-cg-demo-api-key: $API_KEY")
    @GET("simple/price?vs_currencies=eur")
    suspend fun getCoinPrices(
        @Query("ids") symbols: String,
    ): CryptoData
}