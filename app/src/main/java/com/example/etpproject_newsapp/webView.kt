package com.example.etpproject_newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        lateinit var toolbar: Toolbar
        lateinit var webView: WebView
        toolbar = findViewById(R.id.toolbar)
        webView = findViewById(R.id.webview)
        setSupportActionBar(toolbar)

        val intent = intent
        val url = intent.getStringExtra("url")
        webView.webViewClient = WebViewClient()
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}
