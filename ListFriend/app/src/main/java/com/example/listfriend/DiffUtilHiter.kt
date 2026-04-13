package com.example.listfriend

import androidx.recyclerview.widget.DiffUtil

class DiffUtilHiter : DiffUtil.ItemCallback<HITer>() {
    override fun areItemsTheSame(
        p0: HITer,
        p1: HITer
    ): Boolean {
        return p0.name == p1.name
    }

    override fun areContentsTheSame(
        p0: HITer,
        p1: HITer
    ): Boolean {
        return p0 == p1
    }

}
