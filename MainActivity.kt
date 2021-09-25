package space.fly.for_wview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.KeyEvent
import android.webkit.WebViewClient



class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val mWebView = findViewById<WebView>(R.id.webview)

        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true
        //mWebView.loadUrl(getString(R.string.website_url))
        mWebView.loadUrl("https://engeng.herokuapp.com/")
        mWebView.webViewClient = HelloWebViewClient()
        WebView.setWebContentsDebuggingEnabled(false)

    }

    private inner class HelloWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url)
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {

        return super.onKeyDown(keyCode, event)
    }

}
