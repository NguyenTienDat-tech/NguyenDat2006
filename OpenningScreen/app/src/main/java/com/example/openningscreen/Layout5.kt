package com.example.openningscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.openningscreen.databinding.FragmentLayout4Binding
import com.example.openningscreen.databinding.FragmentLayout5Binding


class Layout5 : Fragment() {
    private lateinit var binding: FragmentLayout5Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLayout5Binding.bind(view)

        setOnCLick()
    }

    private fun setOnCLick() {
        binding.verify.setOnClickListener {
            findNavController().navigate(R.id.layout6)
        }

        binding.vector.setOnClickListener {
            findNavController().navigate(R.id.layout4)
        }
    }
}