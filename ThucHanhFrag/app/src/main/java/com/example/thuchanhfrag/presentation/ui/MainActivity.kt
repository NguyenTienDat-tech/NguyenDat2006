package com.example.thuchanhfrag.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.thuchanhfrag.R
import com.example.thuchanhfrag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupController()
        setupBottomNav()
        hideDestination()
    }

    private fun setupController() {
        //1.Tìm khung và lấy điều khiển
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun setupBottomNav() {
        binding.bottomNavgation.setupWithNavController(navController)
    }

    private fun hideDestination() {
        //4.Dặn dò ẩn/hiện thanh điều hướng tùy theo màn hình
        navController.addOnDestinationChangedListener { controller, destination, bundle ->
            if (destination.id == R.id.maytinh || destination.id == R.id.textanh1 || destination.id == R.id.loancalculator || destination.id == R.id.maytinh || destination.id == R.id.bankingcalculator || destination.id == R.id.othercalculator) {
                binding.bottomNavgation.visibility = View.GONE // Nếu đích đến là màn hình Máy tính -> Giấu thanh điều hướng đi
            }
            else {
                binding.bottomNavgation.visibility = View.VISIBLE // Nếu là các màn hình khác (Home, Blog) -> Hiện thanh điều hướng lên
            }
        }
    }
}