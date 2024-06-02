package com.universae.criptofolio.domain.usecase

import com.universae.criptofolio.data.Repository
import javax.inject.Inject

class RemoveTransactionsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() = repository.deleteAllTransactions()
}