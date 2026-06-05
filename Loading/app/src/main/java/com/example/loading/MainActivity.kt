package com.example.loading

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading.databinding.ActivityMainBinding
import com.example.loading.guide.GuideUser
import kotlin.time.Instant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setOnClick()
    }

    private fun setOnClick() {
        binding.loadingFake.setOnClickListener {
            val intent = Intent(this, LoadingFake::class.java)
            startActivity(intent)
        }

        binding.loadingAPI.setOnClickListener {
            val intent = Intent(this, LoadingAPI::class.java)
            startActivity(intent)
        }

        binding.guideUser.setOnClickListener {
            val intent = Intent(this, GuideUser::class.java)
            startActivity(intent)
        }
    }


}