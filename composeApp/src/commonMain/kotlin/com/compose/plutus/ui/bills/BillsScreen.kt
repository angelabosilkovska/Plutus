package com.compose.plutus.ui.bills

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import com.compose.plutus.data.UserData
import com.compose.plutus.ui.components.BillRow
import com.compose.plutus.ui.components.StatementBody
import com.compose.plutus.util.toComposeColor
import org.jetbrains.compose.resources.stringResource
import plutus.composeapp.generated.resources.Res
import plutus.composeapp.generated.resources.due

@Composable
fun BillsScreen(
    onBillClick: (String) -> Unit = {},
    userData: UserData,
) {
    StatementBody(
        modifier = Modifier
            .clearAndSetSemantics { contentDescription = "Bills" }
            .padding(16.dp, 8.dp),
        items = userData.bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color.toComposeColor() },
        amountsTotal = userData.bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(Res.string.due),
        rows = { bill ->
            BillRow(
                modifier = Modifier.clickable {
                    onBillClick(bill.name)
                },
                name = bill.name,
                due = bill.due,
                amount = bill.amount, color = bill.color.toComposeColor()
            )
        }
    )
}

@Composable
fun SingleBillScreen(
    billType: String?,
    userData: UserData
) {
    val bill = remember(billType) { userData.getBill(billType) }
    StatementBody(
        modifier = Modifier.padding(16.dp, 8.dp),
        items = listOf(bill),
        colors = { bill.color.toComposeColor() },
        amounts = { bill.amount },
        amountsTotal = bill.amount,
        circleLabel = bill.name,
    ) { row ->
        BillRow(
            name = row.name,
            due = row.due,
            amount = row.amount,
            color = row.color.toComposeColor()
        )
    }
}

