package com.chickson.starwars.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val ColorPalette = lightColors(
    primary = primary,
    primaryVariant = teritory,
    secondary = secondary,
    onPrimary = Color.White,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,

    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun StarWarsTheme(content: @Composable () -> Unit) {
    val colors =  ColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}