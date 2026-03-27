package com.example.maytinh

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.maytinh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var isWeather = false

    private var luuInput = ""
    private var luuToanTu = ""
    private var luuKetQua = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SetUpListen()
    }

    private fun SetUpListen() {
        binding.weather.setOnClickListener {
            SetUpWeather()
        }

        SetUpButton()
    }

    private fun SetUpWeather(){
        isWeather = !isWeather

        if (isWeather) {
            binding.weather.setImageResource(R.drawable.morning)

        }
        else {
            binding.weather.setImageResource(R.drawable.weather)
        }
    }


    private fun SetUpButton() {
        with (binding) {
            ac.setOnClickListener {
                XoaKetQua()
            }
            khong.setOnClickListener {
                xulynutso("0")
            }
            mot.setOnClickListener {
                xulynutso("1")
            }
            hai.setOnClickListener {
                xulynutso("2")
            }
            ba.setOnClickListener {
                xulynutso("3")
            }
            bon.setOnClickListener {
                xulynutso("4")
            }
            nam.setOnClickListener {
                xulynutso("5")
            }
            sau.setOnClickListener {
                xulynutso("6")
            }
            bay.setOnClickListener {
                xulynutso("7")
            }
            tam.setOnClickListener {
                xulynutso("8")
            }
            chin.setOnClickListener {
                xulynutso("9")
            }
            nho.setOnClickListener {
                xulytoantuso("<")
            }
            chiadu.setOnClickListener {
                xulytoantuso("%")
            }
            chiahet.setOnClickListener {
                xulytoantuso("/")
            }
            nhan.setOnClickListener {
                xulytoantuso("*")
            }
            tru.setOnClickListener {
                xulytoantuso("-")
            }
            cong.setOnClickListener {
                xulytoantuso("+")
            }
            bang.setOnClickListener {
                KetQua()
            }
        }
    }

    private fun xulynutso(value: String) {
        luuInput += value
        binding.ketqua.text = luuInput
    }

    private fun xulytoantuso(toantu: String) {
        luuToanTu = toantu
        binding.ketqua.text = luuToanTu
        luuKetQua = luuInput.toDouble()
        luuInput = ""
    }

    private fun XoaKetQua() {
        luuInput = ""
        binding.ketqua.text="0"

    }

    private fun KetQua() {
        val luuSo = luuInput.toDouble()
        var ketqua = 0.0

        when (luuToanTu) {
            "+" -> ketqua = luuKetQua + luuSo
            "-" -> ketqua = luuKetQua - luuSo
            "*" -> ketqua = luuKetQua * luuSo
            "/" -> ketqua = luuKetQua / luuSo
            "%" -> ketqua = luuKetQua % luuSo
        }
        binding.ketqua.text = ketqua.toString()
        luuInput = ketqua.toString()
    }

}

