package org.example.sqdelight

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.lifecycle.viewmodel.CreationExtras.Empty.get
import kotlinx.browser.document

import org.koin.core.context.startKoin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin { modules(appModule) }
    ComposeViewport(document.body!!) {
        object : KoinComponent {
            val viewModel: SessionViewModel = get()
        }.let {
            App(it.viewModel)
        }
    }
}