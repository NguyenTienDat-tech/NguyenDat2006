package com.example.thuchanhfrag.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.presentation.diffUtil.UserDiffCallback
import com.example.thuchanhfrag.presentation.state.BaoMoi

class ProductAdapter(
    private val onClick: (BaoMoi)-> Unit
): ListAdapter<BaoMoi, ProductAdapter.ViewHolder>(UserDiffCallback()) {

    //1. View Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bao1 : ImageView = itemView.findViewById(R.id.bao1)
    }

    //2. Tạo ViewHolder mới
    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        //Biến fileXML thành view thật
        val view = LayoutInflater.from(holder.context).inflate(R.layout.bao_moi, holder, false)
        return ViewHolder(view)
    }

    //3. Gán dữ liệu vào ViewHolder
    override fun onBindViewHolder(parent: ViewHolder, position: Int) {
        val baoHienTai = getItem(position)

        // Nhét dữ liệu
        parent.bao1.setImageResource(baoHienTai.images)

        parent.itemView.setOnClickListener {
            onClick(baoHienTai)
        }
    }

}