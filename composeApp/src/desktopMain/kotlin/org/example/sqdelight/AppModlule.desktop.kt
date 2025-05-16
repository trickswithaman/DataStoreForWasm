package org.example.sqdelight

import com.russhwolf.settings.PropertiesSettings
import com.russhwolf.settings.Settings
import java.util.Properties

actual val settings: Settings by lazy {
    val properties = Properties()
    // Optionally, load properties from a file here
    PropertiesSettings(properties)
}



