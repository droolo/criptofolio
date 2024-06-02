package com.universae.criptofolio.ui.transaction

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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.universae.criptofolio.databinding.FragmentTransactionBinding
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.ui.transaction.adapter.CoinAdapter
import com.universae.criptofolio.ui.transaction.adapter.TransactionAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransactionFragment : Fragment() {

    private val transactionViewModel by viewModels<TransactionViewModel>()

    private lateinit var adapterTransaction: TransactionAdapter
    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
        initListeners()
    }

    private fun initList()
    {
        adapterTransaction = TransactionAdapter()

        binding.rvTransaction.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterTransaction
        }

        transactionViewModel.getTransactions()
    }
    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                transactionViewModel.state.collect {
                    when (it) {
                        is TransactionState.Error -> errorState()
                        TransactionState.Loading -> loadingState()
                        is TransactionState.Success -> successState(it.data)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressCircular.isVisible = true
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }

    private fun successState(list:List<Transaction>) {
        binding.progressCircular.isVisible = false
        adapterTransaction.updateList(list)
    }

    private fun initListeners() {
        binding.btnAddTransaction.setOnClickListener {
            findNavController().navigate(
                TransactionFragmentDirections.actionTransactionFragmentToTransactionNewActivity()

            )
        }
    }

}