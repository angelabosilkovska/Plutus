package com.compose.plutus.util

import androidx.compose.ui.graphics.Color

fun String.toComposeColor(): Color {
    val colorInt = this.removePrefix("#").toLong(16).toInt()
    return if (this.length == 7) { // Format: #RRGGBB
        Color(colorInt or 0xFF000000.toInt()) // Add full alpha
    } else { // Format: #AARRGGBB
        Color(colorInt)
    }
}