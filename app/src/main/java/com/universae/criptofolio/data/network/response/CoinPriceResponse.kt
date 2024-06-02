package com.universae.criptofolio.data.network.response

data class CoinPriceResponse (
    val eur: Double
)

typealias CryptoData = Map<String, CoinPriceResponse>