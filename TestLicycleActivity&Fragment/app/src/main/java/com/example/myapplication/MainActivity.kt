package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextActivity.setOnClickListener {
            val intent = Intent(this, MainActivityFragment::class.java)
            startActivity(intent)
        }

        display()
        Log.d("Licycle Activity","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Licycle Activity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Licycle Activity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Licycle Activity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Licycle Activity","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Licycle Activity","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Licycle Activity","onDestroy")
    }

    private fun display() {
        binding.display.setOnClickListener {
            val input = binding.input.text.toString().trim()
            binding.result.text = input
        }
    }
}