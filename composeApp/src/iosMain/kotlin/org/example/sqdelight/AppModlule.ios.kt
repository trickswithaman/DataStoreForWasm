package org.example.sqdelight

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.*

import platform.Foundation.NSUserDefaults


actual val settings: Settings = NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)


