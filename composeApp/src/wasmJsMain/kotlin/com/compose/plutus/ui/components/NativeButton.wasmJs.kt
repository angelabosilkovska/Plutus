package com.compose.plutus.ui.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
actual fun NativeButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier,
    backgroundColor: Color,
    textColor: Color,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = textColor
        )
    ) {
        Text(label)
    }
}
