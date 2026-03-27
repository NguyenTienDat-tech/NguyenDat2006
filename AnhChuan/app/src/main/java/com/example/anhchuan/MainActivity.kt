package com.example.anhchuan

import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.anhchuan.databinding.ActivityMainBinding
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // lateinit var: thông báo sẽ sử dụng sau
    private var isPassword = false

    override fun onCreate(savedInstanceState: Bundle?) { //onCreate: Hàm tự động chạy đầu tiên
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //inflate(...): Đọc file giao diện activity_main và chuyển vào binding
        setContentView(binding.root) //lấy toàn bộ dữ liệu vừa lấy và hiển thị lên màn hình

        setupListeners()
    }

    private fun setupListeners() {
        //Nút quay lại
        binding.Back.setOnClickListener {
            Back()
        }

        //Xử lý nút Register
        binding.btnRegister.setOnClickListener {
            validateInputsAndRegister()
        }

        //Ẩn hiện password
        binding.password1.imageEye.setOnClickListener {
            ViewAndHidePassword()
        }

        //Chuyển đến màn hình đăng nhập
        binding.Login.setOnClickListener {
            LoginScreen()
        }
    }

    private fun Back() {
        val intent = Intent(Intent.ACTION_MAIN) //action_main: khởi động một thứ gì đó từ điểm xuất phát
        intent.addCategory(Intent.CATEGORY_HOME) //category_home: đi đến màn hình chính
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK //mở màn hình chính như tác vụ mới, nếu không có thì sẽ bị lỗi vì cố nhét màn hình chính vao app
        startActivity(intent)
    }

    private fun validateInputsAndRegister() {
        val fullName = binding.fullName.text.toString().trim()
        val email = binding.Email1.Email.text.toString().trim()
        val passWord = binding.password1.textPassword.text.toString().trim()
        val phone = binding.phonenumber.text.toString().trim()
        val date = binding.date.text.toString().trim()

        //tên hoặc email trống
        if (fullName.isEmpty() || email.isEmpty() || passWord.isEmpty() || phone.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        //nhập không đúng email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email không hợp lệ, vui lòng nhập lại", Toast.LENGTH_SHORT).show()
            return
        }

        //nhập thành công
        else {
            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
        }

    }

    private fun ViewAndHidePassword() {
        isPassword = !isPassword

        if (isPassword) {
            binding.password1.textPassword.transformationMethod = HideReturnsTransformationMethod.getInstance() //Hiện mật khẩu
            binding.password1.imageEye.setImageResource(R.drawable.eyeopen) //Hiện ảnh mắt mở
        }

        else {
            binding.password1.textPassword.transformationMethod = PasswordTransformationMethod.getInstance() //Ẩn mật khẩu
            binding.password1.imageEye.setImageResource(R.drawable.eye) //Hiện ảnh mắt đóng
        }

        binding.password1.textPassword.setSelection(binding.password1.textPassword.length()) //Đưa con trỏ vào cuối đoạn chữ
    }

    private fun LoginScreen()
    {
        val intent = Intent(this, SignUpActivity::class.java) //Tạo Intent để chuyển từ màn hình hiện tại sang màn hình khac
        startActivity(intent)
    }



}