package com.example.openningscreen.presentation.ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentResetpasswordBinding
import com.example.openningscreen.presentation.viewmodel.ResetViewModel


class ResetPasswordFragment : Fragment() {
    private lateinit var binding: FragmentResetpasswordBinding
    private val viewModel: ResetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resetpassword, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentResetpasswordBinding.bind(view)

        setOnCLick()
        obseverData()
    }

    private fun setOnCLick() {
        binding.resetPassword.setOnClickListener {
            viewModel.successClick()
        }

        binding.vector.setOnClickListener {
            viewModel.otpClick()
        }

        binding.eye.setOnClickListener {
            viewModel.changePassword()
        }

        binding.eye1.setOnClickListener {
            viewModel.changePassword1()
        }
    }

    private fun obseverData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            //isPassword
            if (isVisible.isPasswordVisible) {
                binding.inputPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.eye.setImageResource(R.drawable.eyeopen)
            }
            else {
                binding.inputPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.eye.setImageResource(R.drawable.eyeclose)
            }

            binding.inputPassword.setSelection(binding.inputPassword.length())


            //isPassword1
            if (isVisible.isPasswordVisible1) {
                binding.inputPassword1.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.eye1.setImageResource(R.drawable.eyeopen)
            }
            else {
                binding.inputPassword1.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.eye1.setImageResource(R.drawable.eyeclose)
            }

            binding.inputPassword1.setSelection(binding.inputPassword1.length())


            //NavigationOTP
            if (isVisible.navigationOTP) {
                findNavController().navigate(R.id.layout5)
                viewModel.doneOtp()
            }


            //NavigationResetSuccess
            if (isVisible.navigationSuccess) {
                findNavController().navigate(R.id.layout7)
                viewModel.doneSuccess()
            }
        }
    }


}