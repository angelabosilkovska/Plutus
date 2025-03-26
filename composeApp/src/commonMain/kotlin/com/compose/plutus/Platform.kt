package com.compose.plutus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform