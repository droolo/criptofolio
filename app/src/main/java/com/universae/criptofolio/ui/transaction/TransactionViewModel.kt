package com.universae.criptofolio.ui.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.criptofolio.domain.usecase.GetTransactionsUseCase
import com.universae.criptofolio.domain.usecase.InsertTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(private val getTransactionsUseCase: GetTransactionsUseCase,
    private val insertTransactionUseCase: InsertTransactionUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<TransactionState>(TransactionState.Loading)
    val state: StateFlow<TransactionState> = _state

    init {
       // getTransactions()
    }
    fun getTransactions()
    {
        viewModelScope.launch {
            _state.value = TransactionState.Loading

           // insertTransactionUseCase()

            val result = withContext(Dispatchers.IO) { getTransactionsUseCase() }
            if (result != null) {
                _state.value = TransactionState.Success(result)
            }
            else{
                _state.value = TransactionState.Error("Error")
            }
        }
    }
}