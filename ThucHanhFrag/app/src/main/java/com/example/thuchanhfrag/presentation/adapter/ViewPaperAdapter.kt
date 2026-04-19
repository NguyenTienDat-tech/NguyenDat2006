package com.example.thuchanhfrag.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.thuchanhfrag.presentation.ui.HomeFragment
import com.example.thuchanhfrag.presentation.ui.Tag1Fragment
import com.example.thuchanhfrag.presentation.ui.Tag2Fragment
import com.example.thuchanhfrag.presentation.ui.Tag3Fragment
import com.example.thuchanhfrag.presentation.ui.Tag4Fragment

class ViewPaperAdapter(fragmentHome: HomeFragment): FragmentStateAdapter(fragmentHome) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tag1Fragment()
            1 -> Tag2Fragment()
            2 -> Tag3Fragment()
            3 -> Tag4Fragment()
            else -> Tag1Fragment()
        }
    }

    override fun getItemCount(): Int = 4
}