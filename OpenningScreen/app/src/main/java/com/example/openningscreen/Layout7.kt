package com.example.openningscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout6Binding
import com.example.openningscreen.databinding.FragmentLayout7Binding

class Layout7 : Fragment() {
    private lateinit var binding: FragmentLayout7Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout7Binding.bind(view)

        setOnCLick()
    }

    private fun setOnCLick() {
        binding.backToLogin.setOnClickListener {
            findNavController().navigate(R.id.layout7_layout2)
        }
    }


}