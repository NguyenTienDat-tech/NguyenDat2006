package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentMayTinhBinding
import com.example.thuchanhfrag.presentation.viewmodel.BankingViewModel
import com.example.thuchanhfrag.presentation.viewmodel.MayTinhViewModel
import kotlin.getValue


class MayTinh : Fragment() {
    private lateinit var binding: FragmentMayTinhBinding
    private val viewModel: MayTinhViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_may_tinh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMayTinhBinding.bind(view)
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