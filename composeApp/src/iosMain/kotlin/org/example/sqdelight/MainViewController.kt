package org.example.sqdelight

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.component.get

fun MainViewController() = ComposeUIViewController {
    initKoin()
    object : KoinComponent{
        val viewModel : SessionViewModel = get()
    }.let {
        App(it.viewModel)
    }
}

fun initKoin(){
    startKoin {
        modules(appModule)
    }
}