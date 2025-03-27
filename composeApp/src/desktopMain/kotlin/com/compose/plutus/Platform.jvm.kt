package com.compose.plutus

import java.text.DecimalFormat

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun formatAmountNumber(value: Float): String {
    return DecimalFormat("#,###.##").format(value)
}

actual fun formatAccountNumber(value: Int): String {
    return DecimalFormat("####").format(value)
}