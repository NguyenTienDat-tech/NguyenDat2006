package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentDiscoverBinding
import com.example.thuchanhfrag.presentation.adapter.ProductAdapter
import com.example.thuchanhfrag.presentation.viewmodel.DiscoverViewModel


class Discover : Fragment() {
    private lateinit var binding: FragmentDiscoverBinding
    private lateinit var adapter: ProductAdapter
    private val viewModel: DiscoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDiscoverBinding.bind(view)

        setOnClick()

        binding.recycle.layoutManager = LinearLayoutManager(requireContext())
        binding.recycle.adapter = adapter


        observeData()
    }

    private fun setOnClick() {

        adapter = ProductAdapter { baoMoi ->
            when (baoMoi.images) {
                R.drawable.anh1 -> {
                    viewModel.onAnh1Click()
                }
            }
        }
    }

    private fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) { isVisible ->
            adapter.submitList(isVisible.list)

            if (isVisible.navigationTextAnh1) {
                findNavController().navigate(R.id.textanh1)
                viewModel.doneAnh1()
            }
        }
    }
}