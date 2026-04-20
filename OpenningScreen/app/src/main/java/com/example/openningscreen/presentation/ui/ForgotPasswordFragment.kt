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
import com.example.openningscreen.databinding.FragmentForgotpasswordBinding
import com.example.openningscreen.presentation.event.ForgotEvent
import com.example.openningscreen.presentation.viewmodel.ForgotViewModel
import kotlinx.coroutines.launch


class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotpasswordBinding
    private val viewModel : ForgotViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgotpassword, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentForgotpasswordBinding.bind(view)

        setOnClick()
        eventData()
    }

    private fun setOnClick() {
        binding.sendCode.setOnClickListener {
            viewModel.otpClick()
        }

        binding.vector.setOnClickListener {
            viewModel.loginClick()
        }
    }

    private fun eventData() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is ForgotEvent.NavigationOTP -> {
                        findNavController().navigate(R.id.layout5)
                    }

                    is ForgotEvent.NavigationLogin -> {
                        findNavController().navigate(R.id.layout2)
                    }
                }
            }
        }
    }

}