package com.universae.criptofolio.domain.model

import com.universae.criptofolio.data.database.entities.TransactionEntity
import com.universae.criptofolio.data.model.TransactionModel
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.util.Date

data class Transaction(
    val id:Int = 0,
    val date: String,
    val amount: Float,
    val wallet: String,
    val asset: String,
    val fee: Float,
    val type: Int,

)


fun TransactionModel.toDomain() = Transaction(id, date, amount,wallet, asset, fee, type)
fun TransactionEntity.toDomain() = Transaction(id, date, amount,wallet, asset, fee, type)