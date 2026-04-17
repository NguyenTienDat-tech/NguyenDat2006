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
import com.example.openningscreen.databinding.FragmentRegisterBinding
import com.example.openningscreen.presentation.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterBinding.bind(view)

        setOnCLick()
        obseverData()
    }

    private fun setOnCLick() {
        binding.eye.setOnClickListener {
            viewModel.changePassword()
        }

        binding.login1.setOnClickListener {
            viewModel.loginClick()
        }

        binding.inputName.addTextChangedListener {
            viewModel.onNameChange(it.toString())
        }

        binding.inputEmail.addTextChangedListener {
            viewModel.onEmailChange(it.toString())
        }

        binding.inputPassword.addTextChangedListener {
            viewModel.onPasswordChange(it.toString())
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


            //navigationLogin
            if (isVisible.navigationLogin) {
                findNavController().navigate(R.id.layout2)
                viewModel.doneLogin()
            }


            //check Name
            if (binding.inputName.text.toString() != isVisible.name) {
                binding.inputName.setText(isVisible.name)
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