package com.example.openningscreen

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout2Binding


class Layout2 : Fragment() {
    private lateinit var binding: FragmentLayout2Binding
    private var isPassword = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout2Binding.bind(view)

        setOnClick()
    }

    private fun setOnClick() {
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.layout4)
        }

        binding.eye.setOnClickListener {
            replacePassword()
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

}