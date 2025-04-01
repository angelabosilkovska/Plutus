package com.compose.plutus.ui.accounts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.compose.plutus.data.UserData
import com.compose.plutus.ui.components.AccountRow
import com.compose.plutus.ui.components.StatementBody
import com.compose.plutus.util.toComposeColor
import org.jetbrains.compose.resources.stringResource
import plutus.composeapp.generated.resources.Res
import plutus.composeapp.generated.resources.total

@Composable
fun AccountsScreen(
    onAccountClick: (String) -> Unit = {},
    userData: UserData
) {
    val amountsTotal = remember { userData.accounts.map { account -> account.balance }.sum() }
    StatementBody(
        modifier = Modifier
            .semantics { contentDescription = "Accounts Screen" }
            .padding(16.dp, 8.dp)
        ,
        items = userData.accounts,
        amounts = { account -> account.balance },
        colors = { account -> account.color.toComposeColor() },
        amountsTotal = amountsTotal,
        circleLabel = stringResource(Res.string.total),
        rows = { account ->
            AccountRow(
                modifier = Modifier.clickable {
                    onAccountClick(account.name)
                },
                name = account.name,
                number = account.number,
                amount = account.balance,
                color = account.color.toComposeColor()
            )
        }
    )
}

@Composable
fun SingleAccountScreen(
    accountType: String?,
    userData: UserData
) {
    val account = remember(accountType) { userData.getAccount(accountType) }
    StatementBody(
        modifier = Modifier.padding(16.dp, 8.dp),
        items = listOf(account),
        colors = { account.color.toComposeColor() },
        amounts = { account.balance },
        amountsTotal = account.balance,
        circleLabel = account.name,
    ) { row ->
        AccountRow(
            name = row.name,
            number = row.number,
            amount = row.balance,
            color = row.color.toComposeColor()
        )
    }
}
