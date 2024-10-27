package com.example.aghafans.presentation.components

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewThemeDetection(context: Context, url: String) {
    AndroidView(factory = {
        WebView(context).apply {
            settings.javaScriptEnabled = true  // Enable JavaScript

            // Add the JavaScript interface
            addJavascriptInterface(WebAppInterface(context), "AndroidInterface")

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    // Inject JavaScript to detect the theme after the page is fully loaded
                    evaluateJavascript(
                        """
                        (function() {
                            let theme = document.documentElement.getAttribute("data-theme");
                            if (theme === "dark") {
                                AndroidInterface.onThemeDetected("dark");
                            } else {
                                AndroidInterface.onThemeDetected("light");
                            }
                        })();
                        """.trimIndent(),
                        null
                    )
                }
            }

            loadUrl(url)
        }
    }, modifier = Modifier.fillMaxSize())
}
