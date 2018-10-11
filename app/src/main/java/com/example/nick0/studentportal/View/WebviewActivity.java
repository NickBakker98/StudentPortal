package com.example.nick0.studentportal.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nick0.studentportal.R;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getStringExtra("url");

        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());
        setContentView(webView);
        webView.loadUrl(url);

    }
}
