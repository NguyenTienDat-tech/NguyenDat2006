package com.example.listfriend

import androidx.recyclerview.widget.DiffUtil

class DiffUtilClassroom : DiffUtil.ItemCallback<Classroom>() {
    override fun areItemsTheSame(
        p0: Classroom,
        p1: Classroom
    ): Boolean {
        return p0.name == p1.name
    }

    override fun areContentsTheSame(
        p0: Classroom,
        p1: Classroom
    ): Boolean {
        return p0 == p1
    }

}