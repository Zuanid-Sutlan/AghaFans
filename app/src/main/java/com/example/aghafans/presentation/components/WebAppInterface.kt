package com.example.aghafans.presentation.components

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface

class WebAppInterface(private val context: Context) {

    @JavascriptInterface
    fun onThemeDetected(theme: String) {
        // Log or handle the detected theme
        Log.d("ThemeDetection", "Website theme is: $theme")
        // Handle the theme change in your app (e.g., display a toast or adjust UI)
    }
}
