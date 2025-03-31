package com.compose.plutus.util

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle

actual fun formatAmountNumber(value: Float): String {
    val formatter = NSNumberFormatter()
    formatter.numberStyle = NSNumberFormatterDecimalStyle
    formatter.minimumFractionDigits = 0u
    formatter.maximumFractionDigits = 2u
    formatter.usesGroupingSeparator = true
    val number = NSNumber(value.toDouble())

    return formatter.stringFromNumber(number) ?: value.toString()
}

actual fun formatAccountNumber(value: Int): String {
    val formatter = NSNumberFormatter()
    formatter.numberStyle = NSNumberFormatterDecimalStyle
    formatter.minimumFractionDigits = 0u
    formatter.maximumFractionDigits = 0u // No decimals
    formatter.usesGroupingSeparator = false
    val number = NSNumber(value.toDouble())
    return formatter.stringFromNumber(number) ?: value.toString()
}