package com.universae.criptofolio.ui.coin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.universae.criptofolio.databinding.FragmentCoinBinding
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.ui.transaction.adapter.CoinAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CoinFragment : Fragment() {

    private val coinViewModel by viewModels<CoinViewModel>()

    private lateinit var adapterCoin: CoinAdapter

    private var _binding: FragmentCoinBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()

        initList()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                coinViewModel.state.collect {
                    when (it) {
                        is CoinState.Error -> errorState()
                        CoinState.Loading -> loadingState()
                        is CoinState.Success -> successState(it.data)
                    }
                }
            }
        }
    }

    private fun initList()
    {
        adapterCoin = CoinAdapter()

        binding.rvCoins.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterCoin
        }

        coinViewModel.getCoins()
    }

    private fun loadingState() {
        binding.progressCircular.isVisible = true
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun successState(list:List<Coin>) {
        binding.progressCircular.isVisible = false
        adapterCoin.updateList(list)
    }

}


