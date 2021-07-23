package com.sudipasarkar.kisanseva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import  android.content.Intent;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    LottieAnimationView lottieAnimationView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        int secondsDelayed =1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(IntroActivity.this,RegisterActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}