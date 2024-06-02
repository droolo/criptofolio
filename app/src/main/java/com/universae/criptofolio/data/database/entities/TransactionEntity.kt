package com.universae.criptofolio.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.universae.criptofolio.domain.model.Transaction


@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int = 0,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "amount")
    val amount:Float,

    @ColumnInfo(name = "wallet")
    val wallet: String,

    @ColumnInfo(name = "asset")
    val asset: String,

    @ColumnInfo(name = "fee")
    val fee: Float,

    @ColumnInfo(name = "type")
    val type: Int
)

fun Transaction.toDatabase() = TransactionEntity(id, date, amount, wallet, asset, fee, type)