package com.compose.plutus

import platform.UIKit.UIDevice
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle


class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

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