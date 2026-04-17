package com.example.openningscreen.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentForgotpasswordBinding
import com.example.openningscreen.presentation.viewmodel.ForgotViewModel


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
        obseverData()
    }

    private fun setOnClick() {
        binding.sendCode.setOnClickListener {
            viewModel.otpClick()
        }

        binding.vector.setOnClickListener {
            viewModel.loginClick()
        }
    }

    private fun obseverData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            //navigationOTP
            if (isVisible.navigationOTP) {
                findNavController().navigate(R.id.layout5)
                viewModel.doneOTP()
            }

            //navigationLogin
            if (isVisible.navigationLogin) {
                findNavController().navigate(R.id.layout2)
                viewModel.doneLogin()
            }
        }
    }

}