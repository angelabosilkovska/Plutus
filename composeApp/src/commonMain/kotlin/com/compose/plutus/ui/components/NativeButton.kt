package com.compose.plutus.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
expect fun NativeButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier,
    backgroundColor: Color,
    textColor: Color,
)