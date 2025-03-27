package com.compose.plutus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed interface Destination {
    val icon: ImageVector
    val route: String
}

data object Overview : Destination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

data object Accounts : Destination {
    override val icon = Icons.Filled.AttachMoney
    override val route = "accounts"
}

data object Bills : Destination {
    override val icon = Icons.Filled.MoneyOff
    override val route = "bills"
}

data object SingleAccount : Destination {
    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
    // part of the TabRow selection
    override val icon = Icons.Filled.Money
    override val route = "single_account"
    const val accountTypeArg = "account_type"
    val routeWithArgs = "$route/{$accountTypeArg}"
    val arguments = listOf(
        navArgument(accountTypeArg) { type = NavType.StringType }
    )
}

// Screens to be displayed in the top TabRow
val tabRowScreens = listOf(Overview, Accounts, Bills)
