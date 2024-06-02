package com.universae.criptofolio.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.universae.criptofolio.data.database.dao.CriptofolioDao
import com.universae.criptofolio.data.database.entities.CoinEntity
import com.universae.criptofolio.data.database.entities.TransactionEntity

@Database(entities = [TransactionEntity::class, CoinEntity::class],
    version = 1)
abstract class CriptofolioDatabase: RoomDatabase(){
    abstract  fun getCriptofolioDao(): CriptofolioDao
}