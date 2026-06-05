package com.example.loading

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.loading.databinding.ActivityLoadingFakeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingFake : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingFakeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingFakeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.max = 100

        lifecycleScope.launch {
            for (i in 0..100) {
                binding.progressBar.progress = i
                delay(20)
            }

            val intent = Intent(this@LoadingFake, Home::class.java)
            startActivity(intent)

            finish()
        }
    }
}