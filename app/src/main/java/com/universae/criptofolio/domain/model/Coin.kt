package com.universae.criptofolio.domain.model

import com.universae.criptofolio.data.database.entities.CoinEntity
import com.universae.criptofolio.data.database.entities.TransactionEntity
import com.universae.criptofolio.data.model.CoinModel
import com.universae.criptofolio.data.model.TransactionModel

data class Coin(
    val id:String,
    val name:String,
    val symbol: String

)


fun CoinModel.toDomain() = Coin(id, name, symbol)
fun CoinEntity.toDomain() = Coin(id, name, symbol)