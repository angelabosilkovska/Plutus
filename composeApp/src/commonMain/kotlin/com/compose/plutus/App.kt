package com.compose.plutus

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: Accounts

        Scaffold(
            topBar = {
                PlutusTabRow(
                    allScreens = tabRowScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
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