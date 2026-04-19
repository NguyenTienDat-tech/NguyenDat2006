package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentTag1Binding
import com.example.thuchanhfrag.presentation.viewmodel.Tag1ViewModel

class Tag1Fragment : Fragment() {
    private lateinit var binding: FragmentTag1Binding
    private val viewModel: Tag1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTag1Binding.bind(view)

        setOnclick()
        observeData()
    }

    private fun setOnclick() {
        binding.calculator1.setOnClickListener {
            viewModel.onMayTinhClick()
        }
        binding.loancalculator1.setOnClickListener {
            viewModel.onLoanClick()
        }
        binding.bankingcalculator1.setOnClickListener {
            viewModel.onBankingClick()
        }
        binding.othercalculator1.setOnClickListener {
            viewModel.onOtherClick()
        }
    }

    private fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            if (isVisible.navigationMayTinh) {
                findNavController().navigate(R.id.maytinh)
                viewModel.doneMayTinh()
            }

            if (isVisible.navigationLoan) {
                findNavController().navigate(R.id.loancalculator)
                viewModel.doneLoan()
            }

            if (isVisible.navigationBanking) {
                findNavController().navigate(R.id.bankingcalculator)
                viewModel.doneBanking()
            }

            if (isVisible.navigationOther) {
                findNavController().navigate(R.id.othercalculator)
                viewModel.doneOther()
            }
        }
    }
}