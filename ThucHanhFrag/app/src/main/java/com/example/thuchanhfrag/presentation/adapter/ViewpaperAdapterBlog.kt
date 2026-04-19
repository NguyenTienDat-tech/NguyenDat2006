package com.example.thuchanhfrag.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.thuchanhfrag.presentation.ui.BlogFragment
import com.example.thuchanhfrag.presentation.ui.Bookmark
import com.example.thuchanhfrag.presentation.ui.Discover

class ViewpaperAdapterBlog(fragmentBlog: BlogFragment): FragmentStateAdapter(fragmentBlog) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Discover()
            1 -> Bookmark()
            else -> Discover()
        }
    }


    override fun getItemCount(): Int = 2

}