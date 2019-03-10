package com.example.yuka.wordstocker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebViewActivity extends AppCompatActivity {
    private final String SEARCH_URL = "https://www.google.com/search?q=";
    private String searchText;
    private FloatingActionButton floatingActionButtonDone;
    private SQLiteDatabase db;
    private DictionaryOpenHelper helper;
    private WebView webViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = this.getIntent();
        searchText = intent.getStringExtra("searchText");
        webViewSearch = (WebView) findViewById(R.id.webview_search);
        webViewSearch.setWebViewClient(new WebViewClient());
        webViewSearch.loadUrl(SEARCH_URL+searchText);

        floatingActionButtonDone = (FloatingActionButton)findViewById(R.id.floating_action_button);
        floatingActionButtonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(helper == null){
                    helper = new DictionaryOpenHelper(getApplicationContext());
                }
                if(db == null){
                    db = helper.getWritableDatabase();
                }
                insertData(db, searchText, webViewSearch.getUrl());
            }
        });

    }

    private void insertData(SQLiteDatabase db, String word, String url){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        ContentValues values = new ContentValues();
        values.put(DictionaryOpenHelper.SEARCH_WORD, word);
        values.put(DictionaryOpenHelper.SEARCHED_URL, url);
        values.put(DictionaryOpenHelper.SEARCHED_TIMESTAMP, dateFormat.format(date));

        db.insert(DictionaryOpenHelper.DICTIONARY_TABLE_NAME, null, values);
    }
}
