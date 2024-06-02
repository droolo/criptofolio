package com.universae.criptofolio.data.model

data class TransactionModel (
    val id:Int = 0,
    val date: String,
    val amount: Float,
    val wallet: String,
    val asset: String,
    val fee: Float,
    val type: Int
    )
