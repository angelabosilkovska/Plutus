package com.compose.plutus

import platform.UIKit.UIViewController

interface NativeViewFactory {

    fun createButtonView(
        label: String,
        onClick: () -> Unit
    ): UIViewController

}