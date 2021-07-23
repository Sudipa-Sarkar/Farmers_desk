package com.sudipasarkar.kisanseva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SchemedetailActivity extends AppCompatActivity {
    String title,desc,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemedetail);
        title=getIntent().getStringExtra("title");
        desc=getIntent().getStringExtra("desc");
        link=getIntent().getStringExtra("link");
    }
}