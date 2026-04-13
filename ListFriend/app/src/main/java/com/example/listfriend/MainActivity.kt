package com.example.listfriend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listfriend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterClass: ClassroomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val danhsach = listOf(
            Classroom(
                name = "Android",
                members = listOf(
                    HITer(
                        avatar = "https://scontent.fhan20-1.fna.fbcdn.net/v/t39.30808-6/651891948_2469601116825505_1918179765253299806_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=1d70fc&_nc_eui2=AeHEIh1Mm5voHJ-ofy8HVlbVr05Bj4URkcyvTkGPhRGRzBQ-QovG7MfjqvTnYFcnlrLocxtClQe3TyQ31PnWUt8C&_nc_ohc=MDdfd_Phva8Q7kNvwEuAKi5&_nc_oc=AdoTZGZ4e9FIbuUDmGBEXBfdOt1sjFTABHvdnnjal-mexTPGJ76FBGNecdz-6vvEm8_Q5vATEe4CmygG_eMapBoU&_nc_zt=23&_nc_ht=scontent.fhan20-1.fna&_nc_gid=vXO9TKTLH185VR4-Gxc6MQ&_nc_ss=7a3a8&oh=00_Af2YWBAympjr3EF2zD3rKzwvw2iY6_D0I6_xxqZskwpYbg&oe=69DFE32D",
                        name = "Nguyễn Duy Minh Quân"
                    ),
                    HITer(
                        avatar = "https://scontent.fhan2-5.fna.fbcdn.net/v/t39.30808-1/547588153_1826780454678308_6112571436516038111_n.jpg?stp=dst-jpg_s200x200_tt6&_nc_cat=106&ccb=1-7&_nc_sid=e99d92&_nc_eui2=AeE3QwaY6WF6xgfMkHaqRi4Vq1rTqgdwPWurWtOqB3A9aztStDfFIzcEgtabgBLY9t-aAEKbb6tw69ty68-idMaH&_nc_ohc=xiRUQ2ZcrBMQ7kNvwHM6zFI&_nc_oc=AdpRJXKKTqywsvn2epFVmNGwlax7Xm6RDDOkqBV_8N1_D873RKD1hFuWJ6XuVVnbvkGpVaCxKX-28ykG5-PFoS7E&_nc_zt=24&_nc_ht=scontent.fhan2-5.fna&_nc_gid=J_QVVKCW2I6Do8YnJs9-aw&_nc_ss=7a3a8&oh=00_Af28RGlG9hh6rYpFLswz6-Kuwlfbn5Fery-o9uPsqtL3VA&oe=69DFE319",
                        name = "Trần Thị Trà Mi"
                    ),
                    HITer(
                        avatar = "https://scontent.fhan2-5.fna.fbcdn.net/v/t39.30808-1/480251486_1776804929939984_6647797139726653167_n.jpg?stp=c0.120.720.720a_dst-jpg_s200x200_tt6&_nc_cat=104&ccb=1-7&_nc_sid=e99d92&_nc_eui2=AeHU_TDa6MMEUJI0E5qRuL7q-KZvfUZGGW34pm99RkYZbX_uAbsOziboy2xQXDPlDO2SzDL0iWEFAuzeSNlCYPOw&_nc_ohc=-fTMwrZwnysQ7kNvwFlJf0w&_nc_oc=AdpnZJ4H0KrgMQCIEQu1AnIi59ce80-e-ahJVEnj2DuTbZhQ25-Ywi7QObr_kwG8FO-9xN4mOymvATyU87Ll5dLs&_nc_zt=24&_nc_ht=scontent.fhan2-5.fna&_nc_gid=hxqmEs1gdGFBolJavSavKA&_nc_ss=7a3a8&oh=00_Af1TSXc84AIQt3ERZMpE9felWWdFdlahvqSJ3Uw6cFgH4g&oe=69DFCFB8",
                        name = "Phạm Xuân Hiếu"
                    )
                )
            ),
            Classroom(
                name = "Spring Boot",
                members = listOf(
                    HITer(
                        avatar = "https://scontent.fhan20-1.fna.fbcdn.net/v/t39.30808-6/648833876_1650810375915645_4930175120545122602_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=1d70fc&_nc_eui2=AeHPBXXUJImadvzDLA9MnpVfFDDEsJ25maAUMMSwnbmZoIabu44ksbcthDexxtf9INM9-9ZLhfb17w8UHxnUiH-U&_nc_ohc=PgdX1lAsauEQ7kNvwFaOqi4&_nc_oc=AdohvktWA55Bjd2E23_ccCLn4Ie_wz6nI_ixLHVwpG6EbvdA6PJUdpEd0G8CuxiF-ngZM04Xj9IXEDLBji-GNdzW&_nc_zt=23&_nc_ht=scontent.fhan20-1.fna&_nc_gid=lJh39PWf68bPYCW_lunDMw&_nc_ss=7a3a8&oh=00_Af3o61dk05ESox_iB9xzMTmPy4aVmRwkkoK3bLdG26lCUw&oe=69DFF466",
                        name = "Nguyễn Tiến Kiên"
                    ),
                    HITer(
                        avatar = "https://scontent.fhan20-1.fna.fbcdn.net/v/t1.30497-1/453178253_471506465671661_2781666950760530985_n.png?stp=dst-png_s200x200&_nc_cat=1&ccb=1-7&_nc_sid=b224c7&_nc_eui2=AeHpaH4O8DRcdIWwtkbrERpbWt9TLzuBU1Ba31MvO4FTUEuC2C4CmkwsTzaTZE84f_iCkKBrUgMBxebJFXB_VjrC&_nc_ohc=mU8H-YdbTrYQ7kNvwFsiiSj&_nc_oc=AdoAHq4wM7hDV_kJV5HJBQevFxQvp0qOAc96ZrQxv5eT2ujy9UCHVRzheuzdu4upCDKl8GgkFpOu_FOQZlL3OjND&_nc_zt=24&_nc_ht=scontent.fhan20-1.fna&_nc_ss=7a3a8&oh=00_Af2qwTYZR3NR2dWtk9C19vYKa1T_VinryljuFMY0aDhStg&oe=6A01993A",
                        name = "Đỗ Tiến Anh"
                    ),
                    HITer(
                        avatar = "https://scontent.fhan20-1.fna.fbcdn.net/v/t1.30497-1/453178253_471506465671661_2781666950760530985_n.png?stp=dst-png_s200x200&_nc_cat=1&ccb=1-7&_nc_sid=b224c7&_nc_eui2=AeHpaH4O8DRcdIWwtkbrERpbWt9TLzuBU1Ba31MvO4FTUEuC2C4CmkwsTzaTZE84f_iCkKBrUgMBxebJFXB_VjrC&_nc_ohc=mU8H-YdbTrYQ7kNvwFsiiSj&_nc_oc=AdoAHq4wM7hDV_kJV5HJBQevFxQvp0qOAc96ZrQxv5eT2ujy9UCHVRzheuzdu4upCDKl8GgkFpOu_FOQZlL3OjND&_nc_zt=24&_nc_ht=scontent.fhan20-1.fna&_nc_ss=7a3a8&oh=00_Af2qwTYZR3NR2dWtk9C19vYKa1T_VinryljuFMY0aDhStg&oe=6A01993A",
                        name = "Triệu Đăng Tuấn"
                    )
                )
            ),
            Classroom(
                name = "Tester",
                members = listOf(
                    HITer(
                        avatar = "https://scontent.fhan20-1.fna.fbcdn.net/v/t39.30808-6/651322939_2168211180586696_5999527740127000801_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=1d70fc&_nc_eui2=AeHXJJbE_ordqXE7LNMNCA_E5uiS8qwVMOPm6JLyrBUw4803zx9fkXv5niqeK63LrqKG0R6RAzt3YhfOOujjzXrK&_nc_ohc=22e-muw7FKMQ7kNvwFFaPMq&_nc_oc=AdqZuLJRbs69q8Tji_HfHFrt4BUXbV0JQ_ii-_6NdirFyPNzWQ5oY-PjFgW9e3CZdaZDiaJI74pcWR5SZKyp9-Bo&_nc_zt=23&_nc_ht=scontent.fhan20-1.fna&_nc_gid=7I9p4zJHThqW048Xf6_j6w&_nc_ss=7a3a8&oh=00_Af2RrUjZyMDDtB-KXgGIF2dKNRWZpgytQvIucg6Kv2q51Q&oe=69DFD46D",
                        name = "Trần Thị Thương"
                    ),
                    HITer(
                        avatar = "https://scontent.fhan2-5.fna.fbcdn.net/v/t39.30808-1/527788430_1883281675938191_729355354550699903_n.jpg?stp=c0.0.721.721a_dst-jpg_s200x200_tt6&_nc_cat=106&ccb=1-7&_nc_sid=e99d92&_nc_eui2=AeGCsrkiuqPuPeVKrs8igpts3aM33T7-y0PdozfdPv7LQ3wTI4NBufQVlaYALbnlfNXJKmyVJf82CET7516H5OhU&_nc_ohc=xC6a8S00tbMQ7kNvwHy115W&_nc_oc=AdoEiolGA9A5eWc7lmN3jMKheMrOMZGaccMPnt3znQxdnINf3XgKFoRXWuCIQPDWn2KkbuJsQrQe6Q9sttdvAHuB&_nc_zt=24&_nc_ht=scontent.fhan2-5.fna&_nc_gid=ab84lwHPFwD7AA2Uh9opxA&_nc_ss=7a3a8&oh=00_Af0FK5ZUSPwLG0G8ywT1X4nqVk3ocT3QcKVGhOlp_hDgyQ&oe=69DFE713",
                        name = "Lù Thị Sen"
                    )
                )
            )
        )

        adapterClass = ClassroomAdapter()
        binding.recycle.adapter = adapterClass
        binding.recycle.layoutManager = LinearLayoutManager(this)
        adapterClass.submitList(danhsach)


    }
}