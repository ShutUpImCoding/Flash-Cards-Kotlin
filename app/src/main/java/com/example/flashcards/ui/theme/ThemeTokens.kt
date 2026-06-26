package com.example.flashcards.ui.theme


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ExtendedColors(
    val success: Color,
    val warning: Color,
    val border: Color,
    val borderStrong: Color,
    val chartPrimary: Color,
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        success = Success,
        warning = Warning,
        border = DarkBorder,
        borderStrong = DarkBorderStrong,
        chartPrimary = AmberHighlight
    )
}