package com.universae.criptofolio.ui.main

import com.universae.criptofolio.data.database.dao.TotalCrypto
import com.universae.criptofolio.domain.model.Transaction

sealed class MainState {
    data object Loading : MainState()
    data class Error(val error:String): MainState()
    data  class Success(var data:TotalCrypto): MainState()
}