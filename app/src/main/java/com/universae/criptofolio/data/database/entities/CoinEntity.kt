package com.universae.criptofolio.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction


@Entity(tableName = "coin")
data class CoinEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id:String,

    @ColumnInfo(name = "symbol")
    val symbol: String,

    @ColumnInfo(name = "name")
    val name:String,

    @ColumnInfo(name = "latestprice")
    val latestPrice: Float = 0f
)

fun Coin.toDatabase() = CoinEntity(id, symbol, name)