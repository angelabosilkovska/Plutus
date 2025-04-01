package com.compose.plutus.data

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val accounts: List<Account>,
    val bills: List<Bill>
) {
    fun getAccount(accountName: String?): Account {
        return accounts.first { it.name == accountName }
    }

    fun getBill(billName: String?): Bill {
        return bills.first { it.name == billName }
    }
}
