package com.universae.criptofolio.ui.coindetail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.universae.criptofolio.databinding.ActivityCoinDetailBinding

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinDetailActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityCoinDetailBinding

    private val coinDetailViewModel:CoinDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                coinDetailViewModel.state.collect{
                    when(it)
                    {
                        CoinDetailState.Loading -> loadingState()
                        is CoinDetailState.Error -> errorState()
                        is CoinDetailState.Success -> successState()
                    }
                }

        }
        }
    }



    private fun loadingState()
    {
        binding.progressCircular.isVisible = true
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun successState() {
        TODO("Not yet implemented")
    }
}