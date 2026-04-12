package com.example.recycleviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(
    private val delete: (Int) -> Unit
): ListAdapter<NhanVien, RecycleAdapter.ViewHolder>(DiffCallBack()) {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ten: TextView = itemView.findViewById(R.id.ten)
        val sdt: TextView = itemView.findViewById(R.id.sdt)
        val bin: ImageView = itemView.findViewById(R.id.bin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(parent: ViewHolder, position: Int) {
        val nhanVienCurrent = getItem(position)

        parent.ten.text = nhanVienCurrent.ten
        parent.sdt.text = nhanVienCurrent.sdt

        parent.bin.setOnClickListener {
            delete(position)
        }
    }


}