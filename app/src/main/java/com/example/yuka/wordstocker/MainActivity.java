package com.example.yuka.wordstocker;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonSearch;
    private TextInputEditText textSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSearch = findViewById(R.id.button_search);
        textSearch = findViewById(R.id.text_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearch();

            }
        });

    }

    public void startSearch(){
        Intent intent = new Intent(this, WebViewActivity.class);
//        intent.putExtra(Intent.EXTRA_EMAIL, recipientArray);
        startActivity(intent);
    }
}
