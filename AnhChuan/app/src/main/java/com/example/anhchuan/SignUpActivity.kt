package com.example.anhchuan

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.anhchuan.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private var isEye = false
    private var isSquare = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetUpListeners()

    }

    private fun SetUpListeners() {
        binding.button.setOnClickListener {
            InputEmail()
        }

        binding.password1.imageEye.setOnClickListener {
            ShowHideEye()
        }

        binding.signUp.setOnClickListener {
            signUpScreen()
        }

        binding.square.setOnClickListener {
            ClickSquare()
        }
    }

    private fun InputEmail() {
        val email = binding.Email1.Email.text.toString().trim()
        val passWord = binding.password1.textPassword.text.toString().trim()

        if (email.isEmpty() || passWord.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ, vui lòng nhập lại", Toast.LENGTH_SHORT).show()
            return
        }

        else {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ShowHideEye() {
        isEye = !isEye

        if (isEye) {
            binding.password1.textPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.password1.imageEye.setImageResource(R.drawable.eyeopen)
        }
        else {
            binding.password1.textPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.password1.imageEye.setImageResource(R.drawable.eye)
        }

        binding.password1.textPassword.setSelection(binding.password1.textPassword.length())
    }

    private fun signUpScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun ClickSquare() {
        isSquare = !isSquare

        if (isSquare) {
            binding.square.setImageResource(R.drawable.squaretrue)
        }
        else {
            binding.square.setImageResource(R.drawable.square)
        }
    }


}