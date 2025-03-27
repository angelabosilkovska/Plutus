package com.compose.plutus.ui.bills

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import com.compose.plutus.data.Bill
import com.compose.plutus.data.UserData
import com.compose.plutus.ui.components.BillRow
import com.compose.plutus.ui.components.StatementBody
import org.jetbrains.compose.resources.stringResource
import plutus.composeapp.generated.resources.Res
import plutus.composeapp.generated.resources.due

@Composable
fun BillsScreen(
    bills: List<Bill> = remember { UserData.bills }
) {
    StatementBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(Res.string.due),
        rows = { bill ->
            BillRow(bill.name, bill.due, bill.amount, bill.color)
        }
    )
}
