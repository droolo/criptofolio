package com.universae.criptofolio.ui.transactiondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.domain.usecase.InsertTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionNewViewModel @Inject constructor(private val insertTransactionUseCase: InsertTransactionUseCase) : ViewModel() {

    fun addTransaction(transaction: Transaction)
    {
        viewModelScope.launch {
            insertTransactionUseCase.invoke(transaction)
        }
    }
}