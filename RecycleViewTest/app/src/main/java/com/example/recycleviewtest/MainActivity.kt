package com.example.recycleviewtest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecycleAdapter
    private val list = mutableListOf<NhanVien>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecycleAdapter { nhanVienCurrent ->
            list.remove(nhanVienCurrent)
            adapter.submitList(list.toList())
        }


        binding.recycleview.layoutManager = LinearLayoutManager(this)
        binding.recycleview.adapter = adapter

        adapter.submitList(list.toList())

        binding.them.setOnClickListener {
            Them()
        }

    }

    private fun Them() {
        val ten = binding.inputTen.text.toString().trim()
        val sdt = binding.inputSDT.text.toString().trim()

        list.add(NhanVien(ten, sdt))
        adapter.submitList(list.toList())


        binding.inputTen.setText("")
        binding.inputSDT.setText("")
    }
}