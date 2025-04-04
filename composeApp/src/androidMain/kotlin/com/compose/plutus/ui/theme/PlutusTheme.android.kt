package com.compose.plutus.ui.theme

import androidx.compose.material.Colors

actual fun getPlatformColorScheme(useDarkTheme: Boolean): Colors {
    return when {
        useDarkTheme -> darkColors
        else -> lightColors
    }
}
