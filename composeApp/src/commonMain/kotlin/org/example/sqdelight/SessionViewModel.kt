package org.example.sqdelight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SessionViewModel(private val settingsHelper: SettingsHelper) {
    var sessionState by mutableStateOf<UserSession?>(settingsHelper.getSession())
        private set

    fun login(token: String) {
        val session = UserSession(token, isLoggedIn = true)
        settingsHelper.saveSession(session)
        sessionState = session
    }

    fun logout() {
        settingsHelper.clearSession()
        sessionState = null
    }
}