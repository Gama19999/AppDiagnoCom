package com.gamars.diagnocom;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SE1FActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // No NightMode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR); // No screen rotation

        setContentView(R.layout.activity_se1f);
    }
}
