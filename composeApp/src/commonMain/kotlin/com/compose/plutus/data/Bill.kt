package com.compose.plutus.data

import kotlinx.serialization.Serializable

@Serializable
data class Bill(
    val name: String,
    val due: String,
    val amount: Float,
    val color: String
)
