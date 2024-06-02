package com.universae.criptofolio.data

import android.util.Log
import com.universae.criptofolio.data.database.dao.CriptofolioDao
import com.universae.criptofolio.data.database.dao.TotalCrypto
import com.universae.criptofolio.data.database.entities.CoinEntity
import com.universae.criptofolio.data.database.entities.toDatabase
import com.universae.criptofolio.data.model.CoinModel
import com.universae.criptofolio.data.network.CriptoApiService
import com.universae.criptofolio.data.network.response.CoinPriceResponse
import com.universae.criptofolio.data.network.response.CoinResponse
import com.universae.criptofolio.data.network.response.CryptoData
import com.universae.criptofolio.data.network.response.toDomain
import com.universae.criptofolio.domain.IRepository
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.domain.model.toDomain
import com.universae.criptofolio.domain.usecase.RemoveTransactionsUseCase
import javax.inject.Inject

class Repository @Inject constructor(
    private val criptoApiService: CriptoApiService,
    private val criptofolioDao: CriptofolioDao
): IRepository {
    override suspend fun getCoinDetail(): CoinResponse {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllCoins(coins: List<CoinEntity>) {
        criptofolioDao.insertAllCoins(coins)
    }
    override suspend fun getCoinsFromApi() : List<Coin>
    {
        val coins = criptoApiService.getCoinList().map { it.toDomain() }
        return coins
    }

    override suspend fun getCoinsPriceFromApi(): CryptoData
    {
        val symbols = "bitcoin,ethereum,solana"
        return criptoApiService.getCoinPrices(symbols)
    }

    override suspend fun getCoinsFromDatabase() : List<Coin>
    {
        return criptofolioDao.getAllCoins().map { it.toDomain() }
    }

    suspend fun updateCoinPrice(id: String, price: Float)
    {
        criptofolioDao.updateCoin(id, price)
    }
    override suspend fun deleteAllCoins(){
        criptofolioDao.deleteAllCoins()
    }

    suspend fun getTotal(): TotalCrypto
    {
        return criptofolioDao.getTotal()
    }
    override suspend fun getAllTransactionsFromDatabase():List<Transaction> {
        return criptofolioDao.getAllTransactions().map { it.toDomain()  }
    }

    override suspend fun insertTransaction(transaction: Transaction) {
        criptofolioDao.insertTransaction(transaction.toDatabase())
    }

    override suspend fun deleteTransaction(id: Int){
        criptofolioDao.deleteTransaction(id)
    }

    override suspend fun deleteAllTransactions(){
        criptofolioDao.deleteAllTransactions()
    }
}