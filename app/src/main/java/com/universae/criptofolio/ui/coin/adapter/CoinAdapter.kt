package com.universae.criptofolio.ui.transaction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.R
import com.universae.criptofolio.domain.model.Coin
import com.universae.criptofolio.domain.model.Transaction

class CoinAdapter(private var coins:List<Coin> = emptyList()):RecyclerView.Adapter<CoinViewHolder>(){

    fun updateList(list:List<Coin>)
    {
        coins = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.item_coin,parent,false))
    }

    override fun getItemCount() = coins.size



    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item: Coin = coins[position]
        holder.render(item)
    }

}