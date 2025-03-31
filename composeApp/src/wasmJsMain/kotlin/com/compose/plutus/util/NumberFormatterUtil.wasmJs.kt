package com.compose.plutus.util

actual fun formatAmountNumber(value: Float): String {
    return value.toInt().toString() // Remove decimals and formatting

//    return (value.toDouble().asDynamic()).toLocaleString("en-US", object {
//        val minimumFractionDigits = 0
//        val maximumFractionDigits = 2
//        val useGrouping = true
//    })
}

actual fun formatAccountNumber(value: Int): String {
    return value.toString() // Remove decimals and formatting
}