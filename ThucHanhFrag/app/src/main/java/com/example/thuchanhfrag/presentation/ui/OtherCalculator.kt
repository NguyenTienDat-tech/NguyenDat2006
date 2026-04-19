package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentOtherCalculatorBinding
import com.example.thuchanhfrag.presentation.viewmodel.MayTinhViewModel
import com.example.thuchanhfrag.presentation.viewmodel.OtherViewModel
import kotlin.getValue

class OtherCalculator : Fragment() {
    private lateinit var binding: FragmentOtherCalculatorBinding
    private val viewModel: OtherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOtherCalculatorBinding.bind(view)

        setOnClick()
        observeData()
    }

    private fun setOnClick() {
        binding.muiten.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    private fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            if (isVisible.navigationHome) {
                findNavController().navigate(R.id.homeFragment)
                viewModel.doneHome()
            }
        }
    }

}