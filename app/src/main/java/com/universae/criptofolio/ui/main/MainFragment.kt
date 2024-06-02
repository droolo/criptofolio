package com.universae.criptofolio.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.universae.criptofolio.data.database.dao.TotalCrypto
import com.universae.criptofolio.databinding.FragmentMainBinding
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.ui.transaction.TransactionState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel by viewModels<MainViewModel>()
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         initUI()
    }

    private fun initUI() {

        mainViewModel.updatePrices()

        initUIState()

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                mainViewModel.state.collect {
                    when (it) {
                        is MainState.Error -> errorState()
                        MainState.Loading -> loadingState()
                        is MainState.Success -> successState(it.data)
                    }
                }
            }
        }
    }


    private fun loadingState() {
        var q = 1
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun successState(total:TotalCrypto) {
       // binding.progressCircular.isVisible = false
        binding.txtTotal.setText(total.total.toString())
    }
}


