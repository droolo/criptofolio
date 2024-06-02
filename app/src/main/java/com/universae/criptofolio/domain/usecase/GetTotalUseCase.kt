package com.universae.criptofolio.domain.usecase

import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.data.database.dao.TotalCrypto
import com.universae.criptofolio.data.database.entities.toDatabase
import com.universae.criptofolio.domain.model.Coin
import javax.inject.Inject


class GetTotalUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): TotalCrypto {

        val total = repository.getTotal()

        return total
    }
}