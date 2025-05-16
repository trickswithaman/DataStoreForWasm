package org.example.sqdelight

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.java.KoinJavaComponent.inject

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SqDelightTest",
    ) {
//        val viewModel: SessionViewModel by inject()

  //      App(viewModel)
    }
}