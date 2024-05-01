package com.universae.criptofolio.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.universae.criptofolio.databinding.FragmentConfigBinding


class ConfigFragment : Fragment() {

    private var _binding:FragmentConfigBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfigBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}