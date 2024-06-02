package com.universae.criptofolio.ui.coindetail

import androidx.lifecycle.ViewModel
import com.universae.criptofolio.ui.coin.CoinState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor() : ViewModel() {

    private var _state = MutableStateFlow<CoinDetailState>(CoinDetailState.Loading)
    val state: StateFlow<CoinDetailState> = _state
}