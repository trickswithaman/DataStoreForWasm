package org.example.sqdelight

import android.content.Context
import android.content.SharedPreferences
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


lateinit var androidContext: Context

// Call this during application startup (e.g., in Application class)
fun initKoinAndroid(appContext: Context) {
    androidContext = appContext
    startKoin {
        androidContext(appContext)
        modules(appModule)
    }
}

actual val settings: Settings by lazy {
    val delegate: SharedPreferences = androidContext.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    SharedPreferencesSettings(delegate)
}