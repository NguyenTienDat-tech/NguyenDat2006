package com.example.recycleviewtest

import androidx.recyclerview.widget.DiffUtil

class DiffCallBack: DiffUtil.ItemCallback<NhanVien>() {
    override fun areItemsTheSame(old: NhanVien, new: NhanVien): Boolean {
        return old.sdt == new.sdt
    }

    override fun areContentsTheSame(old: NhanVien, new: NhanVien): Boolean {
        return old == new
    }
}