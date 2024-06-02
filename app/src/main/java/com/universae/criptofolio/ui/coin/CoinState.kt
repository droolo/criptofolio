package com.universae.criptofolio.ui.coin

import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.ui.transaction.TransactionState

sealed class CoinState {
    data object Loading : CoinState()
    data class Error(val error:String): CoinState()
    data  class Success(var data:List<Coin>): CoinState()
}