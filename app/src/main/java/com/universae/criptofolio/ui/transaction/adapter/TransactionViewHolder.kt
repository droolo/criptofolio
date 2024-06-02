package com.universae.criptofolio.ui.transaction.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.universae.criptofolio.databinding.ItemTransactionBinding
import com.universae.criptofolio.domain.model.Transaction

class TransactionViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemTransactionBinding.bind(view)

    fun render(transaction: Transaction){

        binding.txtAsset.text = transaction.asset
        binding.txtQty.text = transaction.amount.toString()
        binding.txtType.text = transaction.type.toString()
      //  binding.txtDate.text = transaction.date.toString()

    }
}