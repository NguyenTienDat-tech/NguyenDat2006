package com.example.openningscreen.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentOtpverificationBinding
import com.example.openningscreen.presentation.viewmodel.OtpViewModel


class OtpVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOtpverificationBinding
    private val viewModel: OtpViewModel by viewModels()

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
        obseverData()
    }

    private fun setOnCLick() {
        binding.verify.setOnClickListener {
            viewModel.resetClick()
        }

        binding.vector.setOnClickListener {
            viewModel.forgotClick()
        }
    }

    private fun obseverData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            //navigationForgot
            if (isVisible.navigationForgot) {
                findNavController().navigate(R.id.layout4)
                viewModel.doneForgot()
            }

            //navigationReset
            if (isVisible.navigationReset) {
                findNavController().navigate(R.id.layout6)
                viewModel.doneReset()
            }
        }
    }
}