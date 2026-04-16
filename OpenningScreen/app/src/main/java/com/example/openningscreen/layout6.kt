package com.example.openningscreen

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout5Binding
import com.example.openningscreen.databinding.FragmentLayout6Binding


class layout6 : Fragment() {
    private lateinit var binding: FragmentLayout6Binding
    private var isPassword = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout6, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout6Binding.bind(view)

        setOnCLick()
    }

    private fun setOnCLick() {
        binding.resetPassword.setOnClickListener {
            findNavController().navigate(R.id.layout7)
        }

        binding.vector.setOnClickListener {
            findNavController().navigate(R.id.layout5)
        }

        binding.eye.setOnClickListener {
            replacePassword()
        }

        binding.eye1.setOnClickListener {
            replacePassword1()
        }
    }

    private fun replacePassword() {
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

    private fun replacePassword1() {
        isPassword = !isPassword

        if (isPassword) {
            binding.inputPassword1.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.eye1.setImageResource(R.drawable.eyeopen)
        }
        else {
            binding.inputPassword1.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eye1.setImageResource(R.drawable.eyeclose)
        }
    }

}