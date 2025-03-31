package com.compose.plutus.util

import java.text.DecimalFormat

actual fun formatAmountNumber(value: Float): String {
    return DecimalFormat("#,###.##").format(value)
}

actual fun formatAccountNumber(value: Int): String {
    return DecimalFormat("####").format(value)
}