package com.example.openningscreen

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout3Binding


class Layout3 : Fragment() {
    private lateinit var binding: FragmentLayout3Binding
    private var isPassword = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout3Binding.bind(view)

        setOnCLick()
    }

    private fun setOnCLick() {
        binding.eye.setOnClickListener {
            changePassword()
        }

        binding.login1.setOnClickListener {
            findNavController().navigate(R.id.layout2)
        }
    }

    private fun changePassword() {
        isPassword = !isPassword

        if (isPassword) {
            binding.inputPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.eyeopen)
        }
        else {
            binding.inputPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.eyeclose)
        }
    }


}