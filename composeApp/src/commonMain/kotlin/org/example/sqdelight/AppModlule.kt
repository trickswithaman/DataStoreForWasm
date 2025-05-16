package org.example.sqdelight

import com.russhwolf.settings.Settings
import org.koin.dsl.module

val appModule = module {
    // Provide Settings instance (expect to be defined per platform)
    single<Settings> { settings }

    // Provide SettingsHelper with injected Settings
    single { SettingsHelper(get()) }

    // Provide SessionViewModel with SettingsHelper
    factory { SessionViewModel(get()) }
}

expect val settings: Settings