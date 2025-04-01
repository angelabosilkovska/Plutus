package com.compose.plutus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.plutus.data.UserData
import com.compose.plutus.ui.accounts.AccountsScreen
import com.compose.plutus.ui.accounts.SingleAccountScreen
import com.compose.plutus.ui.bills.BillsScreen
import com.compose.plutus.ui.bills.SingleBillScreen
import com.compose.plutus.ui.overview.OverviewScreen

@Composable
fun PlutusNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    userData: UserData
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = modifier
    ) {
        composable(route = Overview.route) {
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                },
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                },
                onBillClick = { billType ->
                    navController.navigateToSingleBill(billType)
                },
                userData = userData
            )
        }
        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                },
                userData = userData
            )
        }
        composable(route = Bills.route) {
            BillsScreen(
                onBillClick = { billType ->
                    navController.navigateToSingleBill(billType)
                },
                userData
            )
        }
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments
        ) { navBackStackEntry ->
            val accountType = navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
            SingleAccountScreen(accountType, userData)
        }
        composable(
            route = SingleBill.routeWithArgs,
            arguments = SingleBill.arguments
        ) { navBackStackEntry ->
            val billType = navBackStackEntry.arguments?.getString(SingleBill.billTypeArg)
            SingleBillScreen(
                billType,
                userData
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
}

private fun NavHostController.navigateToSingleBill(billType: String) {
    this.navigateSingleTopTo("${SingleBill.route}/$billType")
}
