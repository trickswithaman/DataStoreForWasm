package org.example.sqdelight

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
        /*startKoin {
            androidContext(this@MyApp) // Provide the Android context
            modules(appModule) // Your Koin modules
        }*/
    }
}