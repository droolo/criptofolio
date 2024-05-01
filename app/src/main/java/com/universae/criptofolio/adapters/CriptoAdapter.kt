package com.universae.criptofolio.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.R
import com.universae.criptofolio.model.Coin

class CriptoAdapter(private val coins:MutableLiveData<List<Coin>>):RecyclerView.Adapter<CriptoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriptoViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return CriptoViewHolder(layoutInflater.inflate(R.layout.item_coin,parent,false))
    }

    override fun getItemCount(): Int {
       if(coins.value != null)
       {
           return coins.value!!.size
       }
        return 0
    }

    override fun onBindViewHolder(holder: CriptoViewHolder, position: Int) {
        val item: Coin = coins.value!![position]
        holder.bind(item)
    }

}