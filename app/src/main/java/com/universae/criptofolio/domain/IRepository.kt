package com.universae.criptofolio.domain

import com.universae.criptofolio.data.database.entities.CoinEntity
import com.universae.criptofolio.data.network.response.CoinPriceResponse
import com.universae.criptofolio.data.network.response.CoinResponse
import com.universae.criptofolio.data.network.response.CryptoData
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction

interface IRepository {

    suspend fun getCoinDetail(): CoinResponse
    suspend fun getCoinsFromApi(): List<Coin>
    suspend fun getCoinsFromDatabase(): List<Coin>

    suspend fun insertAllCoins(coins: List<CoinEntity>)
    suspend fun deleteAllCoins()

    suspend fun getCoinsPriceFromApi(): CryptoData
    suspend fun getAllTransactionsFromDatabase(): List<Transaction>

    suspend fun insertTransaction(transaction: Transaction)
    suspend fun deleteTransaction(id: Int)
    suspend fun deleteAllTransactions()
}