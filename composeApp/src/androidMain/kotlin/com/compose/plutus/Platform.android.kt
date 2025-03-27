package com.compose.plutus

import android.os.Build
import java.text.DecimalFormat

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun formatAmountNumber(value: Float): String {
    return DecimalFormat("#,###.##").format(value)
}

actual fun formatAccountNumber(value: Int): String {
    return DecimalFormat("####").format(value)
}