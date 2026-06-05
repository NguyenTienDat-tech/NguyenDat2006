package com.example.loading.guide

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading.Home
import com.example.loading.R
import com.example.loading.databinding.ActivityTag1Binding
import com.example.loading.databinding.ActivityTag2Binding

class Tag2 : AppCompatActivity() {
    private lateinit var binding: ActivityTag2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTag2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)

            finish()
        }

    }
}