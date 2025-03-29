package com.compose.plutus.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val primaryLight = Color(0xFF4C662B)
val onPrimaryLight = Color(0xFFFFFFFF)
val secondaryLight = Color(0xFF586249)
val onSecondaryLight = Color(0xFFFFFFFF)
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val backgroundLight = Color(0xFFF9FAEF)
val onBackgroundLight = Color(0xFF1A1C16)
val surfaceLight = Color(0xFFF9FAEF)
val onSurfaceLight = Color(0xFF1A1C16)

val primaryDark = Color(0xFFB1D18A)
val onPrimaryDark = Color(0xFF1F3701)
val secondaryDark = Color(0xFFBFCBAD)
val onSecondaryDark = Color(0xFF2A331E)
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val backgroundDark = Color(0xFF12140E)
val onBackgroundDark = Color(0xFFE2E3D8)
val surfaceDark = Color(0xFF12140E)
val onSurfaceDark = Color(0xFFE2E3D8)

val darkColors = darkColors(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    error = errorDark,
    onError = onErrorDark,
)

val lightColors = lightColors(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    error = errorLight,
    onError = onErrorLight,
)

