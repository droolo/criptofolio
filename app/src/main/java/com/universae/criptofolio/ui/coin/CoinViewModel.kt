package com.universae.criptofolio.ui.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.criptofolio.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) : ViewModel(){

    private var _state = MutableStateFlow<CoinState>(CoinState.Loading)
    val state:StateFlow<CoinState> = _state

    fun getCoins()
    {
        viewModelScope.launch {
            _state.value = CoinState.Loading

            val result = withContext(Dispatchers.IO) { getCoinsUseCase() }
            if (result != null) {
                _state.value = CoinState.Success(result)
            }
            else{
                _state.value = CoinState.Error("Error")
            }
        }
    }
}