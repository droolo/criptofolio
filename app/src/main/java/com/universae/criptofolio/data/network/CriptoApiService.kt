package com.universae.criptofolio.data.network

import com.universae.criptofolio.Prefs
import com.universae.criptofolio.data.network.response.CoinPriceResponse
import com.universae.criptofolio.data.network.response.CoinResponse
import com.universae.criptofolio.data.network.response.CryptoData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CriptoApiService {
    @GET("coins/list")
    suspend fun getCoinList(): List<CoinResponse>

    @GET("simple/price?vs_currencies=eur")
    suspend fun getCoinPrices(
        @Query("ids") symbols: String,
    ): CryptoData
}
