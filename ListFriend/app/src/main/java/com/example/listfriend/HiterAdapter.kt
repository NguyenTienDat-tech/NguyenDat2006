package com.example.listfriend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.listfriend.ClassroomAdapter.ViewHolder


class HiterAdapter: ListAdapter<HITer, HiterAdapter.ViewHolder>(DiffUtilHiter()) {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): HiterAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.activity_layout_hiter, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: HiterAdapter.ViewHolder, p1: Int) {
        val hiter = getItem(p1)

        p0.ten.text = hiter.name

        Glide.with(p0.itemView.context)
            .load(hiter.avatar)
            .circleCrop()
            .into(p0.anh)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val anh: ImageView = itemView.findViewById(R.id.image)
        val ten: TextView = itemView.findViewById(R.id.name)
    }
}