package com.universae.criptofolio.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.domain.usecase.GetTotalUseCase
import com.universae.criptofolio.domain.usecase.InsertTransactionUseCase
import com.universae.criptofolio.domain.usecase.RemoveTransactionsUseCase
import com.universae.criptofolio.domain.usecase.UpdatePricesUseCase
import com.universae.criptofolio.ui.transaction.TransactionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTotalUseCase: GetTotalUseCase,
    private val updatePricesUseCase: UpdatePricesUseCase) : ViewModel() {

    private var _state = MutableStateFlow<MainState>(MainState.Loading)
    val state: StateFlow<MainState> = _state

        fun updatePrices()
    {
        viewModelScope.launch {
            _state.value = MainState.Loading

            val result = withContext(Dispatchers.IO) {
                updatePricesUseCase()
                getTotalUseCase()
            }

            if (result != null) {
                _state.value = MainState.Success(result)
            }
            else{
                _state.value = MainState.Error("Error")
            }

        }
    }


}