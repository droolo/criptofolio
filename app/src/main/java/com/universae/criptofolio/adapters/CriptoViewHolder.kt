package com.universae.criptofolio.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.databinding.ItemCoinBinding
import com.universae.criptofolio.model.Coin

class CriptoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemCoinBinding.bind(view)

    fun bind(coin: Coin){
        binding.txtCoinName.text = coin.name
        binding.txtPrice.text = coin.symbol

    }
}