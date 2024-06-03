package com.universae.criptofolio.ui.configuration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.universae.criptofolio.CriptofolioApp.Companion.prefs
import com.universae.criptofolio.databinding.FragmentConfigBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigFragment : Fragment() {

    private val configViewModel by viewModels<ConfigViewModel>()
    private var _binding:FragmentConfigBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfigBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

        binding.txtPassword.setText(prefs.getApiKey())
    }

    private fun initUI() {

        initListeners()
    }

    private fun initListeners() {
        binding.btnSample.setOnClickListener {
            configViewModel.createSampleData()
            Toast.makeText(it.context, "Transacciones agregadas", Toast.LENGTH_LONG).show()
        }
        binding.btnClear.setOnClickListener{ configViewModel.removeAllData()
            Toast.makeText(it.context, "Transacciones eliminadas", Toast.LENGTH_LONG).show()
        }

        binding.btnSave.setOnClickListener{
            prefs.saveApiKey(binding.txtPassword.text.toString())
            Toast.makeText(it.context, "Api key guardada correctamente", Toast.LENGTH_LONG).show()
        }
    }
}