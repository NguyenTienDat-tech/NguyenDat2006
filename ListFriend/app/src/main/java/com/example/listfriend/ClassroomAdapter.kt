package com.example.listfriend

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.example.listfriend.databinding.ActivityLayoutClassroomBinding

class ClassroomAdapter: ListAdapter<Classroom, ClassroomAdapter.ViewHolder>(DiffUtilClassroom()) {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_layout_classroom, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        p0: ViewHolder,
        p1: Int
    ) {
        val classroom = getItem(p1)

        p0.name.text = classroom.name
        p0.hiterAdapter.submitList(classroom.members)

        //Animation
        val transition = AutoTransition()
        transition.duration = 300

        TransitionManager.beginDelayedTransition(p0.itemView as ViewGroup, AutoTransition())

        //Xoay tvArrow
        p0.tvArrow.text = if (classroom.isExpanded) "▼" else "▲"

        // Hiển thị ẩn
        p0.rvMembers.visibility = if (classroom.isExpanded) View.VISIBLE else View.GONE

        // Click để mở, đóng
        p0.itemView.setOnClickListener {
            val newList = currentList.toMutableList() //tạo bản copy

            val item = newList[p1]
            newList[p1] = item.copy(isExpanded = !item.isExpanded)
            submitList(newList)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.ten)
        val tvArrow: TextView = itemView.findViewById(R.id.tvArrow)
        val rvMembers: RecyclerView = itemView.findViewById(R.id.recycle1)

        val hiterAdapter = HiterAdapter()

        //init: Chạy khi viewholde được tạo
        init {
            rvMembers.layoutManager = LinearLayoutManager(itemView.context)
            rvMembers.adapter = hiterAdapter
        }
    }

}