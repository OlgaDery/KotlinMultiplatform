package com.example.prohappymultiplatform

expect class Platform() {
    val platform: String
    fun randomUUID(): String
    fun date(): Long
}