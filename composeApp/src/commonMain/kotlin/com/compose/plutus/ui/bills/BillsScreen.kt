package com.compose.plutus.ui.bills

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import com.compose.plutus.data.Bill
import com.compose.plutus.data.UserData
import com.compose.plutus.ui.components.BillRow
import com.compose.plutus.ui.components.StatementBody
import org.jetbrains.compose.resources.stringResource
import plutus.composeapp.generated.resources.Res
import plutus.composeapp.generated.resources.due

@Composable
fun BillsScreen(
    onBillClick: (String) -> Unit = {},
    bills: List<Bill> = remember { UserData.bills },
) {
    StatementBody(
        modifier = Modifier
            .clearAndSetSemantics { contentDescription = "Bills" }
            .padding(16.dp, 8.dp),
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(Res.string.due),
        rows = { bill ->
            BillRow(
                modifier = Modifier.clickable {
                    onBillClick(bill.name)
                },
                name = bill.name,
                due = bill.due,
                amount = bill.amount, color = bill.color
            )
        }
    )
}

@Composable
fun SingleBillScreen(
    billType: String? = UserData.bills.first().name
) {
    val bill = remember(billType) { UserData.getBill(billType) }
    StatementBody(
        modifier = Modifier.padding(16.dp, 8.dp),
        items = listOf(bill),
        colors = { bill.color },
        amounts = { bill.amount },
        amountsTotal = bill.amount,
        circleLabel = bill.name,
    ) { row ->
        BillRow(
            name = row.name,
            due = row.due,
            amount = row.amount,
            color = row.color
        )
    }
}

