package com.universae.criptofolio.domain.usecase

import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.domain.model.Coin
import javax.inject.Inject


class UpdatePricesUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke() {
        val prices = repository.getCoinsPriceFromApi()

        for (entry in prices.entries.iterator()) {
            repository.updateCoinPrice(entry.key, entry.value.eur.toFloat())
        }
    }
}