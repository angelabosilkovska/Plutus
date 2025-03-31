package com.compose.plutus

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.plutus.ui.theme.PlutusTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.compose.plutus.ui.components.PlutusTabRow

@Composable
@Preview
fun App() {
    PlutusTheme {
        val navController = rememberNavController()
        val currentScreen = getCurrentScreen(navController)

        Scaffold(
            topBar = {
                PlutusTabRow(
                    allScreens = tabRowScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen,
                    modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
                )
            }
        ) { innerPadding ->
            PlutusNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun getCurrentScreen(navController: NavHostController): Destination {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    return tabRowScreens.find { it.route == currentDestination?.route } ?: run {
        when (extractPrefix(currentDestination?.route)) {
            "single_bill" -> Bills
            "single_account" -> Accounts
            else -> Overview
        }
    }
}

fun extractPrefix(input: String?): String? {
    return input?.substringBefore("/")
}