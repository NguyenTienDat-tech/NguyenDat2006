package com.example.openningscreen.presentation.ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.R
import com.example.openningscreen.databinding.FragmentLoginBinding
import com.example.openningscreen.presentation.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        setOnClick()
        obseverData()
    }

    private fun setOnClick() {
        binding.eye.setOnClickListener {
            viewModel.changePassword()
        }

        binding.forgotPassword.setOnClickListener {
            viewModel.forgotCLick()
        }

        binding.signUp.setOnClickListener {
            viewModel.registerClick()
        }

        binding.inputEmail.addTextChangedListener { //addTextChangedListener: check khi nào người dùng nhập
            viewModel.onEmailChange(it.toString()) //it: giá trị hiện tại
        }

        binding.inputPassword.addTextChangedListener {
            viewModel.onPasswordChange(it.toString())
        }

    }

    private fun obseverData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            //ChangePassword
            if (isVisible.isPasswordVisible) {
                binding.inputPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.eye.setImageResource(R.drawable.eyeopen)
            }
            else {
                binding.inputPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.eye.setImageResource(R.drawable.eyeclose)
            }

            binding.inputPassword.setSelection(binding.inputPassword.length())


            //navigationRegister
            if (isVisible.navigationRegister) {
                findNavController().navigate(R.id.layout3)
                viewModel.doneRegister()
            }


            //navigationForGot
            if (isVisible.navigationForgot) {
                findNavController().navigate(R.id.layout4)
                viewModel.doneForgot()
            }


            //check email
            if (binding.inputEmail.text.toString() != isVisible.email) {
                binding.inputEmail.setText(isVisible.email)
            }

            //check password
            if (binding.inputPassword.text.toString() != isVisible.password) {
                binding.inputPassword.setText(isVisible.password)
            }

        }
    }

}