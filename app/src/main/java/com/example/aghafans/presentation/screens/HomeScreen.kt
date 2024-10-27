package com.example.aghafans.presentation.screens

import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.aghafans.presentation.components.MyWebView
import com.example.aghafans.presentation.components.WebViewThemeDetection

@Composable
fun HomeScreen(modifier: Modifier = Modifier, url: String) {

//    val context = LocalContext.current
//    val webView = remember { WebView(context) }
//
//    // Set up the back handler
//    BackHandler(enabled = webView.canGoBack()) {
//        webView.goBack()
//    }


    Box(modifier = modifier.fillMaxSize()){
        MyWebView(url = url)
//        WebViewThemeDetection(context =context, url = url)
    }
}