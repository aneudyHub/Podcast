package com.example.podcast.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple300,
    primaryVariant = Purple500,
    secondary = Teal200,
    secondaryVariant = Teal600,
    background = Gray900,
    surface = Gray500,
    error = Error,
    onPrimary = White,
    onBackground = White,
    onSurface = White
)

private val LightColorPalette = lightColors(
    primary = Purple300,
    primaryVariant = Purple500,
    secondary = Teal200,
    secondaryVariant = Teal600,
    background = Gray100,
    surface = Gray100,
    error = Error,
    onPrimary = White,
    onBackground = Black,
    onSurface = Black
)

@Composable
fun PodcastTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}