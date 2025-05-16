package org.example.sqdelight



import kotlinx.serialization.json.Json
// commonMain/kotlin/SettingsHelper.kt
import com.russhwolf.settings.Settings
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import com.russhwolf.settings.get
import com.russhwolf.settings.set





// Your SettingsHelper class
@Serializable
data class UserSession(val token: String, val isLoggedIn: Boolean)

class SettingsHelper(private val settings: Settings) {
    private val json = Json { ignoreUnknownKeys = true }

    fun saveSession(session: UserSession) {
        val serialized = json.encodeToString(session)
        settings.set("session_key", serialized)
    }

    fun getSession(): UserSession? {
        val serialized: String? = settings.get("session_key")
        return serialized?.let { json.decodeFromString(it) }
    }

    fun clearSession() {
        settings.remove("session_key")
    }
}