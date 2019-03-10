package com.example.yuka.wordstocker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private String searchText;
    private final String SEARCH_URL = "https://www.google.com/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = this.getIntent();
        searchText = intent.getStringExtra("searchText");
        WebView webViewSearch = (WebView) findViewById(R.id.webview_search);
        webViewSearch.setWebViewClient(new WebViewClient());
        webViewSearch.loadUrl(SEARCH_URL+searchText);

    }
}
