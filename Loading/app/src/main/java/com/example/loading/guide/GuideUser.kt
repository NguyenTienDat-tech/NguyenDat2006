package com.example.loading.guide

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading.R
import com.example.loading.databinding.ActivityGuideUserBinding

class GuideUser : AppCompatActivity() {
    private lateinit var binding: ActivityGuideUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            val intent = Intent(this, Tag1::class.java)
            startActivity(intent)

            finish()
        }

    }
}