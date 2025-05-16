package org.example.sqdelight

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform