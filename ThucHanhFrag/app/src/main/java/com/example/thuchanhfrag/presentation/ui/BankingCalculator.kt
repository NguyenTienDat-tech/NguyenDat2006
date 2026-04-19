package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentBankingCalculatorBinding
import com.example.thuchanhfrag.presentation.viewmodel.BankingViewModel
import com.example.thuchanhfrag.presentation.viewmodel.LoanViewModel
import kotlin.getValue

class BankingCalculator : Fragment() {
    private lateinit var binding: FragmentBankingCalculatorBinding
    private val viewModel: BankingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_banking_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBankingCalculatorBinding.bind(view)

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