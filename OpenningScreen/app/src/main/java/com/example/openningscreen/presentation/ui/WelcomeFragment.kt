package com.example.openningscreen.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentWelcomeBinding
import com.example.openningscreen.presentation.event.WelcomeEvent
import com.example.openningscreen.presentation.viewmodel.WelcomeViewModel
import kotlinx.coroutines.launch
import kotlin.getValue


class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentWelcomeBinding.bind(view)

        setOnClick()
        eventData()
    }

    private fun setOnClick() {
        binding.signUp.setOnClickListener {
            viewModel.loginClick()
        }
        binding.createAccount.setOnClickListener {
            viewModel.registerClick()
        }
    }

    private fun eventData() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is WelcomeEvent.NavigationLogin -> {
                        findNavController().navigate(R.id.layout2)
                    }

                    is WelcomeEvent.NavigationRegister -> {
                        findNavController().navigate(R.id.layout3)
                    }
                }
            }
        }
    }
}