package com.example.podcast.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W600,
        fontSize = 32.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        color = Gray500
    ),
    body2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W200,
        fontSize = 12.sp,
        color = Gray500
    )
)