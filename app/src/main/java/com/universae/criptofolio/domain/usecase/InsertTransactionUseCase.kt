package com.universae.criptofolio.domain.usecase

import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.domain.model.Transaction
import javax.inject.Inject

class InsertTransactionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(transaction: Transaction) = repository.insertTransaction(transaction)
}