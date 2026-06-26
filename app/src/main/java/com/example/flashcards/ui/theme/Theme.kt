package com.example.flashcards.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(

    primary = RustPrimary,
    onPrimary = CreamText,

    secondary = AmberHighlight,
    onSecondary = DarkBackground,

    tertiary = RustPrimaryHover,
    onTertiary = CreamText,

    background = DarkBackground,
    onBackground = TextPrimaryDark,

    surface = DarkSurface,
    onSurface = TextPrimaryDark,

    surfaceVariant = DarkSurfaceElevated,
    onSurfaceVariant = TextSecondaryDark,

    outline = DarkBorder,
)

private val LightColorScheme = lightColorScheme(

    primary = RustPrimary,
    onPrimary = CreamText,

    secondary = AmberHighlight,
    onSecondary = DarkBackground,

    tertiary = RustPrimaryHover,
    onTertiary = CreamText,

    background = LightBackground,
    onBackground = TextPrimaryLight,

    surface = LightSurface,
    onSurface = TextPrimaryLight,

    surfaceVariant = Color.White,
    onSurfaceVariant = TextSecondaryLight,

    outline = DarkBorderStrong,
)

@Composable
fun FlashCardsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),

    // Recommend FALSE for branded apps
    dynamicColor: Boolean = false,

    content: @Composable () -> Unit
) {

    val colorScheme = when {

        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val extendedColors = if (darkTheme) {
        ExtendedColors(
            success = Success,
            warning = Warning,
            border = DarkBorder,
            borderStrong = DarkBorderStrong,
            chartPrimary = AmberHighlight
        )
    } else {
        ExtendedColors(
            success = Success,
            warning = Warning,
            border = Color(0xFFE7C9A9),
            borderStrong = Color(0xFFB08968),
            chartPrimary = RustPrimary
        )
    }

    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors
    ) {

        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
