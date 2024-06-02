package com.universae.criptofolio.ui.transactiondetail

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.universae.criptofolio.databinding.ActivityTransactionNewBinding
import com.universae.criptofolio.domain.model.Transaction
import com.universae.criptofolio.ui.transaction.TransactionFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionNewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionNewBinding
    private val transactionNewViewModel:TransactionNewViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI()
    {
        initListeners()
    }

    private fun initListeners() {
        binding.buttonAdd.setOnClickListener {

            if (validar()) {

                var trans = Transaction(
                    0,
                    binding.txtDate.text.toString(),
                    binding.txtQuantity.text.toString().toFloat(),
                    binding.txtWallet.text.toString(),
                    binding.txtName.text.toString(),
                    binding.txtFee.text.toString().toFloat(),
                    if(binding.rbCompra.isChecked()) 1 else -1
                )

                transactionNewViewModel.addTransaction(trans)

                Toast.makeText(this, "Transacción agregada", Toast.LENGTH_LONG).show()

                binding.txtDate.setText("")
                binding.txtQuantity.setText("")
                binding.txtWallet.setText("")
                binding.txtName.setText("")
                binding.txtFee.setText("")

            }
        }
    }

        fun validar(): Boolean {
            if (binding.txtName.text.isEmpty()) {
                Toast.makeText(this, "El nombre no puede estar vacío.", Toast.LENGTH_LONG).show()
                return false
            }

            if (binding.txtWallet.text.isEmpty()) {
                Toast.makeText(this, "La Wallet no puede estar vacía.", Toast.LENGTH_LONG).show()
                return false
            }

            if (binding.txtQuantity.text.isEmpty()) {
                Toast.makeText(this, "La cantidad no puede estar vacía.", Toast.LENGTH_LONG).show()
                return false
            }

            if (binding.txtFee.text.isEmpty()) {
                Toast.makeText(this, "La Tasa no puede estar vacía.", Toast.LENGTH_LONG).show()
                return false
            }

            if (binding.txtDate .text.isEmpty()) {
                Toast.makeText(this, "La fecha no puede estar vacía.", Toast.LENGTH_LONG).show()
                return false
            }

            return true
        }
}