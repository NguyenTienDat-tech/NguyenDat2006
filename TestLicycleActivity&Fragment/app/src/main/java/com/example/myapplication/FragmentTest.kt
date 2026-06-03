package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentTestBinding


class FragmentTest : Fragment() {
    private lateinit var binding: FragmentTestBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Licycle Fragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Licycle Fragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTestBinding.bind(view)

        binding.nextActivity.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        display()

        Log.d("Licycle Fragment", "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Licycle Fragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Licycle Fragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Licycle Fragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Licycle Fragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Licycle Fragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Licycle Fragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Licycle Fragment", "onDetach")
    }

    private fun display() {
        binding.display.setOnClickListener {
            val input = binding.input.text.toString().trim()
            binding.result.text = input
        }
    }
}