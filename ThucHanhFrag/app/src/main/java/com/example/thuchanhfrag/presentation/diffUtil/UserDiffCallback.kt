package com.example.thuchanhfrag.presentation.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.thuchanhfrag.presentation.state.BaoMoi

class UserDiffCallback : DiffUtil.ItemCallback<BaoMoi>() {


    override fun areItemsTheSame(old: BaoMoi, new: BaoMoi): Boolean {
        return old.images == new.images
    }

    override fun areContentsTheSame(old: BaoMoi, new: BaoMoi): Boolean {
        return old == new
    }
}