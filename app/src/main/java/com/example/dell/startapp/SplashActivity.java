package com.example.dell.startapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    CountDownTimer countDownTimer = new CountDownTimer(3000, 1000)
    {
        @Override
        public void onTick(long millisUntilFinished) {}
        @Override
        public void onFinish() {
            Intent i = new Intent(SplashActivity.this, infoDcei.class);
            startActivity(i);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        countDownTimer.start();
    }
}
