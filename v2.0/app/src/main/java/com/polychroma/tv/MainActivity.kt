package com.polychroma.tv

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.tv_polychroma_full_screen.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tv_polychroma_full_screen)
        actionBar?.setDisplayHomeAsUpEnabled(false)

        web_view_ad.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        val webSettings = web_view_ad.settings
        webSettings.javaScriptEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = false
        webSettings.loadWithOverviewMode = false
        webSettings.domStorageEnabled = true
        webSettings.setAppCacheEnabled(true)
        webSettings.setSupportMultipleWindows(true)
        web_view_ad.webChromeClient = WebChromeClient()
        web_view_ad.isHardwareAccelerated
        web_view_ad.setInitialScale(1)
        web_view_ad.isVerticalScrollBarEnabled = false
        web_view_ad.isHorizontalScrollBarEnabled = false
        web_view_ad.setBackgroundColor(Color.TRANSPARENT)
        web_view_ad.loadUrl("https://live.polychroma.tv/m/#01")

    }

    override fun onBackPressed() {
        if (web_view_ad.canGoBack()) {
            web_view_ad.goBack()
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }

    companion object {

        private val AUTO_HIDE = true

        private val AUTO_HIDE_DELAY_MILLIS = 3000

        private val UI_ANIMATION_DELAY = 300
    }
}
