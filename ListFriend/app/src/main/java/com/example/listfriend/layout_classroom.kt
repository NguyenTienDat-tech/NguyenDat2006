package com.example.listfriend

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listfriend.databinding.ActivityLayoutClassroomBinding
import com.example.listfriend.databinding.ActivityMainBinding
import java.util.ArrayList

class layout_classroom : AppCompatActivity() {
    private lateinit var binding: ActivityLayoutClassroomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutClassroomBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}