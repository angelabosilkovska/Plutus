package com.compose.plutus

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.compose.plutus.network.UserDataClient
import com.compose.plutus.network.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Plutus",
    ) {
        App(
            client = remember {
                UserDataClient(createHttpClient(OkHttp.create()))
            }
        )
    }
}