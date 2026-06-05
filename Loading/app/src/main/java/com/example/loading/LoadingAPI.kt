package com.example.loading

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.loading.databinding.ActivityHomeBinding
import com.example.loading.databinding.ActivityLoadingApiBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingAPI : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingAPI()
    }

    private fun loadingAPI() {
        lifecycleScope.launch {
            initData()

            val intent = Intent(this@LoadingAPI, Home::class.java)
            startActivity(intent)

            finish()
        }
    }


    //cái chỗ delay là mình thay thế những cái api, roomdatabase thì sau mà có dùng thì sẽ thay delay thành hàm romdatabase
    suspend fun initData() {
        binding.progressBar.setProgressCompat(20, true)
        delay(500)
        binding.progressBar.setProgressCompat(60, true)
        delay(500)
        binding.progressBar.setProgressCompat(100, true)
        delay(500)
    }
}