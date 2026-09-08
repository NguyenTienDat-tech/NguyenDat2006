package com.example.openningscreencompose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.openningscreencompose.R

val LiberiaFontFamily = FontFamily(
    Font(R.font.roboto_condensed_regular, FontWeight.Normal),
    Font(R.font.roboto_condensed_bold, FontWeight.Bold),
    Font(R.font.roboto_semicondensed_medium, FontWeight.Medium),
    Font(R.font.roboto_semicondensed_semibold, FontWeight.SemiBold)
)

data class AppCustomTypography(
    val chaoMung: TextStyle,
    val tieuDe: TextStyle,
    val tieuDe1: TextStyle,
    val tieuDe2: TextStyle,
    val hienThiAI: TextStyle,
    val chu1: TextStyle,
    val chu2: TextStyle,
    val chu3: TextStyle,
    val status: TextStyle,
    val thongBao: TextStyle,
    val chuThich: TextStyle,
    val nut1: TextStyle,
    val nut2: TextStyle,
    val nut3: TextStyle
)


val Typography: AppCustomTypography = AppCustomTypography(
    chaoMung = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    tieuDe = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp),
    tieuDe1 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp),
    tieuDe2 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    hienThiAI = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 24.sp),
    chu1 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp),
    chu2 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    chu3 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    status = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 15.sp),
    thongBao = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 11.sp),
    chuThich = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    nut1 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp),
    nut2 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    nut3 = TextStyle(fontFamily = LiberiaFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp)
)

// Tạo biến cục bộ để phân phối Font đi toàn App
val LocalAppTypography = staticCompositionLocalOf {
    Typography
}


object AppTheme {
    val typography: AppCustomTypography
        @Composable
        get() = LocalAppTypography.current
}