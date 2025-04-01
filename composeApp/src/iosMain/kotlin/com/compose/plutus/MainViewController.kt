package com.compose.plutus

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.window.ComposeUIViewController
import com.compose.plutus.network.UserDataClient
import com.compose.plutus.network.createHttpClient
import io.ktor.client.engine.darwin.Darwin

val LocalNativeViewFactory = staticCompositionLocalOf<NativeViewFactory> {
    error("No view factory provided")
}

fun MainViewController(
    nativeViewFactory: NativeViewFactory
) = ComposeUIViewController {
    CompositionLocalProvider(LocalNativeViewFactory provides nativeViewFactory) {
        App(
            client = remember {
                UserDataClient(createHttpClient(Darwin.create()))
            }
        )
    }
}