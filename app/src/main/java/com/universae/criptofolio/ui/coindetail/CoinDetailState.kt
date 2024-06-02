package com.universae.criptofolio.ui.coindetail

import com.universae.criptofolio.ui.coin.CoinState

sealed class CoinDetailState {
    data object Loading : CoinDetailState()
    data class Error(val error:String): CoinDetailState()
    data  class Success(var data:String): CoinDetailState()
}