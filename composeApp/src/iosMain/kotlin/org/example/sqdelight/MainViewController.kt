package org.example.sqdelight

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val viewModel = SessionViewModel()
    App(viewModel)
}