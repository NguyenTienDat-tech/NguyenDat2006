package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentTextAnh1Binding


class TextAnh1 : Fragment() {
    private lateinit var binding: FragmentTextAnh1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_anh1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTextAnh1Binding.bind(view)

        setOnCLick()
    }

    private fun setOnCLick() {
        binding.vectorblue.setOnClickListener {
            findNavController().navigate(R.id.blogFragment)
        }
    }

}