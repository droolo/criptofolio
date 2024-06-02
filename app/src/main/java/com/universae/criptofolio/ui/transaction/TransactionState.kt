package com.universae.criptofolio.ui.transaction

import com.universae.criptofolio.domain.model.Transaction


sealed class TransactionState {
    data object Loading : TransactionState()
    data class Error(val error:String): TransactionState()
    data  class Success(var data:List<Transaction>): TransactionState()
}