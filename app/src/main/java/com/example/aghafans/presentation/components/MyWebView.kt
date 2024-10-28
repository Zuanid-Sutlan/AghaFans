package com.example.aghafans.presentation.components

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.aghafans.MainActivity

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MyWebView(modifier: Modifier = Modifier, url: String) {
    val context = LocalContext.current
    val webView1 = WebView(context).apply {
        // Ensures WebView loads within the app
        webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                    // Check if the error is DNS-related
                if (error?.errorCode == ERROR_HOST_LOOKUP) {
                    Log.e("WebViewError", "DNS lookup failed: ${error.description}")
                } else {
                    Log.e("WebViewError", "Error loading page: ${error?.description}")
                }
            }
        }
        settings.javaScriptEnabled = true // Enable JavaScript
//        settings.domStorageEnabled = true // Enable DOM storage
//        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK // Optimize caching
//        settings.useWideViewPort = true // Enable wide viewport
//        settings.loadWithOverviewMode = true // Fit content on the screen
        settings.builtInZoomControls = true // Enable zoom controls
        settings.displayZoomControls = false // Hide zoom buttons
        settings.javaScriptCanOpenWindowsAutomatically = true // Allow window opening via JS
//        settings.databaseEnabled = true
        settings.setGeolocationEnabled(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true // Extra security for WebView content
        }

        /*// JavaScript interface to communicate theme info back to Android
        addJavascriptInterface(object : Any() {
            @JavascriptInterface
            fun setTheme(darkMode: Boolean) {
                isDarkTheme = darkMode
            }
        }, "AndroidInterface")*/

        /*// Inject JavaScript to detect theme
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            evaluateJavascript(
                """
                    (function() {
                        const darkMode = window.matchMedia && 
                                         window.matchMedia('(prefers-color-scheme: dark)').matches;
                        AndroidInterface.setTheme(darkMode);
                    })();
                    """.trimIndent(),
                null
            )
        }*/

        loadUrl(url) // Load the provided URL
    }

    BackHandler {
        if (webView1.canGoBack()) {
            webView1.goBack()


        } else {
            (context as MainActivity).finish()
        }
    }

    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = {
            webView1
        },
        update = { webView ->
            webView.loadUrl(url) // Reload if needed
        }
    )
}
