package com.compose.plutus.ui.theme

import androidx.compose.material.Colors
import platform.UIKit.*

actual fun getPlatformColorScheme(useDarkTheme: Boolean): Colors {
    return if (isIosDarkTheme()) darkColors else lightColors
}

// Detect dark mode in iOS
fun isIosDarkTheme(): Boolean {
    return UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}