package com.universae.criptofolio.domain.usecase

import com.universae.criptofolio.data.Repository
import com.universae.criptofolio.data.database.entities.toDatabase
import com.universae.criptofolio.domain.model.Coin
import javax.inject.Inject


class GetCoinsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): List<Coin> {

        val coins = repository.getCoinsFromApi()

        return if (coins.isNotEmpty()) {
            repository.deleteAllCoins()
            repository.insertAllCoins(coins.map { it.toDatabase() })
            coins
        } else {
            repository.getCoinsFromDatabase()
        }
    }
}