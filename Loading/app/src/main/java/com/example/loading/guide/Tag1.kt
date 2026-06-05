package com.example.loading.guide

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading.R
import com.example.loading.databinding.ActivityGuideUserBinding
import com.example.loading.databinding.ActivityTag1Binding

class Tag1 : AppCompatActivity() {
    private lateinit var binding: ActivityTag1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTag1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val intent = Intent(this, Tag2::class.java)
            startActivity(intent)

            finish()
        }

    }
}