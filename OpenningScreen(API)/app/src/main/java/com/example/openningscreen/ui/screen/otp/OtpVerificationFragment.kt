package com.example.openningscreen.ui.screen.otp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.data.remote.retrofitInstance.RetrofitInstance
import com.example.openningscreen.data.repository.UserRepository
import com.example.openningscreen.databinding.FragmentOtpverificationBinding
import kotlinx.coroutines.launch

class OtpVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOtpverificationBinding
    private val viewModel: OtpViewModel by viewModels() {
        OTPViewModelFactory(
            UserRepository(
                apiService = RetrofitInstance.apiService,
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otpverification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOtpverificationBinding.bind(view)

        setOnCLick()
        eventData()
    }

    private fun setOnCLick() {
        binding.verify.setOnClickListener {
            val email = arguments?.getString("email") ?: ""

            viewModel.resetClick(email)
        }

        setupOtp()

        binding.vector.setOnClickListener {
            viewModel.forgotClick()
        }
    }

    private fun setupOtp() {
        binding.input1.addTextChangedListener {
            viewModel.input1(it.toString())
        }
        binding.input2.addTextChangedListener {
            viewModel.input2(it.toString())
        }
        binding.input3.addTextChangedListener {
            viewModel.input3(it.toString())
        }
        binding.input4.addTextChangedListener {
            viewModel.input4(it.toString())
        }
    }

    private fun eventData() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is OtpEvent.NavigationForgot -> {
                        findNavController().navigate(R.id.layout4)
                    }

                    is OtpEvent.NavigationReset -> {
                        findNavController().navigate(R.id.layout6)
                    }

                    is OtpEvent.Null -> {
                        Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
                    }

                    is OtpEvent.NavigationResetSendEmail -> {
                        findNavController().navigate(
                            R.id.layout6,
                            Bundle().apply {
                                putString("email", event.email)
                                putString("otp", binding.input1.text.toString() + binding.input2.text.toString() + binding.input3.text.toString() + binding.input4.text.toString())
                            }
                        )
                    }
                }
            }
        }
    }
}