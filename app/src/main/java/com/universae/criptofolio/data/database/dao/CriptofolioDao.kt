package com.universae.criptofolio.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.universae.criptofolio.data.database.entities.CoinEntity
import com.universae.criptofolio.data.database.entities.TransactionEntity

@Dao
interface CriptofolioDao {
    @Query("Select * from `transaction`")
    suspend fun getAllTransactions():List<TransactionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTransations(transactions:List<TransactionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction:TransactionEntity)

    @Query("delete from `transaction` where id = :id")
    suspend fun deleteTransaction(id:Int)

    @Query("delete from `transaction`")
    suspend fun deleteAllTransactions()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCoins(coins:List<CoinEntity>)

    @Query("update `coin` set latestprice = :latestPrice where id = :id")
    suspend fun updateCoin(id: String, latestPrice: Float)

    @Query("Select * from `coin`")
    suspend fun getAllCoins():List<CoinEntity>

    @Query("delete from `coin`")
    suspend fun deleteAllCoins()

    @Query("select sum(t.amount*t.type*c.latestprice) as total from `coin` as c inner join  `transaction` as t on c.id = t.asset")
    suspend fun getTotal(): TotalCrypto
}

data class TotalCrypto(var total: Float)