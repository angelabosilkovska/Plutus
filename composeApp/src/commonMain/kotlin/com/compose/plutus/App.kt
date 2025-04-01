package com.compose.plutus

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.plutus.data.UserData
import com.compose.plutus.data.accounts
import com.compose.plutus.data.bills
import com.compose.plutus.network.UserDataClient
import com.compose.plutus.ui.theme.PlutusTheme
import com.compose.plutus.ui.components.PlutusTabRow
import com.compose.plutus.util.Result

@Composable
fun App(client: UserDataClient?) {
    PlutusTheme {
        val data = getUserData(client)
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
                modifier = Modifier.padding(innerPadding),
                userData = data
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

@Composable
fun getUserData(client: UserDataClient?): UserData {
    return if (client == null) {
        UserData(accounts, bills)
    } else {
        val viewModel: AppViewModel = remember { AppViewModel(client) }
        val userDataState by viewModel.userData.collectAsState()
        if (userDataState is Result.Success) {
            (userDataState as Result.Success<UserData>).data
        } else {
            UserData(accounts, bills)
        }
    }
}