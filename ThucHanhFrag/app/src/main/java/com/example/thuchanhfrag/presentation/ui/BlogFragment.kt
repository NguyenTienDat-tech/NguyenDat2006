package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.FragmentBlogBinding
import com.example.thuchanhfrag.presentation.adapter.ViewpaperAdapterBlog
import com.example.thuchanhfrag.presentation.viewmodel.BlogViewModel


class BlogFragment : Fragment() {
    private lateinit var binding: FragmentBlogBinding
    private val viewmodel: BlogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlogBinding.bind(view)

        val adapter = ViewpaperAdapterBlog(this)
        binding.ViewPaper1.adapter = adapter

        setOnClick()
        observeData()
    }

    private fun setOnClick() {
        binding.discover.setOnClickListener {
            viewmodel.nextPage(0)
        }
        binding.bookmark.setOnClickListener {
            viewmodel.nextPage(1)
        }
    }

    private fun observeData() {
        viewmodel.uiState.observe(viewLifecycleOwner) { page ->
            binding.ViewPaper1.currentItem = page
        }
    }

}