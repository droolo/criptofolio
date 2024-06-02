package com.universae.criptofolio.ui.transaction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.R
import com.universae.criptofolio.domain.model.Transaction

class TransactionAdapter(private var transactions:List<Transaction> = emptyList()):RecyclerView.Adapter<TransactionViewHolder>(){

    fun updateList(list:List<Transaction>)
    {
        transactions = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return TransactionViewHolder(layoutInflater.inflate(R.layout.item_transaction,parent,false))
    }

    override fun getItemCount() = transactions.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item: Transaction = transactions[position]
        holder.render(item)
    }
}