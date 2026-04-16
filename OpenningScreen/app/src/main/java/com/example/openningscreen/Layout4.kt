package com.example.openningscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout4Binding


class Layout4 : Fragment() {
    private lateinit var binding: FragmentLayout4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout4Binding.bind(view)

        setOnClick()
    }

    private fun setOnClick() {
        binding.sendCode.setOnClickListener {
            findNavController().navigate(R.id.layout5)
        }

        binding.vector.setOnClickListener {
            findNavController().navigate(R.id.layout2)
        }
    }

}