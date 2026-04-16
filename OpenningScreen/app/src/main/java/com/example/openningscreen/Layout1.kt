package com.example.openningscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout1Binding


class Layout1 : Fragment() {
    private lateinit var binding: FragmentLayout1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout1Binding.bind(view)

        setOnClick()
    }

    private fun setOnClick() {
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.layout2)
        }
        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.layout3)
        }
    }
}