package com.compose.plutus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun formatAmountNumber(value: Float): String
expect fun formatAccountNumber(value: Int): String