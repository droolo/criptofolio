package com.universae.criptofolio.ui.transaction.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.databinding.ItemCoinBinding
import com.universae.criptofolio.databinding.ItemTransactionBinding
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction

class CoinViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemCoinBinding.bind(view)

    fun render(coin: Coin){
        binding.txtName.text = coin.name
        binding.txtSymbol.text = coin.symbol
    }
}