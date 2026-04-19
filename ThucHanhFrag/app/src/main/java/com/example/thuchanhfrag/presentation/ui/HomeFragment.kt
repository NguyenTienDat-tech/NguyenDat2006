package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentHomeBinding
import com.example.thuchanhfrag.presentation.adapter.ViewPaperAdapter
import com.example.thuchanhfrag.presentation.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)


        //Adapter
        val adapter = ViewPaperAdapter(this)
        binding.viewPaper.adapter = adapter


        setOnClick()
        observeData()
    }

    private fun setOnClick() {
        //Bấm vào nút chuyển sang layout
        binding.giaodich.setOnClickListener {
            viewModel.nextPage(0)
        }
        binding.danhsach.setOnClickListener {
            viewModel.nextPage(1)
        }
        binding.phiendich.setOnClickListener {
            viewModel.nextPage(2)
        }
        binding.caidat.setOnClickListener {
            viewModel.nextPage(3)
        }
    }

    private fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) { page ->
            binding.viewPaper.currentItem = page
        }
    }
}