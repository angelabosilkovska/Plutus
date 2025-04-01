package com.compose.plutus.data

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val name: String,
    val number: Int,
    val balance: Float,
    val color: String
)
