package com.universae.criptofolio.ui.configuration

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.domain.usecase.GetTransactionsUseCase
import com.universae.criptofolio.domain.usecase.InsertTransactionUseCase
import com.universae.criptofolio.domain.usecase.RemoveTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(private val insertTransactionUseCase: InsertTransactionUseCase,
    private val removeTransactionsUseCase: RemoveTransactionsUseCase) : ViewModel() {

    fun createSampleData()
    {
        viewModelScope.launch {

            val sample1 = Transaction(0, "2024-04-30", 40f, "METAMASK", "bitcoin", 0.1f, 1)
            insertTransactionUseCase(sample1)

            val sample2 = Transaction(0, "2024-05-30", 30f, "METAMASK", "bitcoin", 0.5f, 1)
            insertTransactionUseCase(sample2)

            val sample3 = Transaction(0, "2024-05-30", 20f, "METAMASK", "bitcoin", 0.06f, -1)
            insertTransactionUseCase(sample3)

            val sample4 = Transaction(0, "2024-05-31", 0.5f, "METAMASK", "ethereum", 0.4f, 1)
            insertTransactionUseCase(sample4)

            val sample5 = Transaction(0, "2024-05-31", 100f, "METAMASK", "solana", 0.1f, 1)
            insertTransactionUseCase(sample5)
        }


    }

    fun removeAllData()
    {
        viewModelScope.launch {
            removeTransactionsUseCase()
        }

    }

}