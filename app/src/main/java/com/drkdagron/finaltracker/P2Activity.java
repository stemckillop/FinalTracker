package com.drkdagron.finaltracker;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class P2Activity extends AppCompatActivity {
    public final String TAG = "P2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeManager.getInstance();
        setContentView(R.layout.activity_p2);

        ViewPager vp = (ViewPager)findViewById(R.id.p1c);
        PlayerAdapter p1 = new PlayerAdapter(getSupportFragmentManager(), 0);
        vp.setAdapter(p1);

        ViewPager vpp = (ViewPager)findViewById(R.id.p2c);
        PlayerAdapter p2 = new PlayerAdapter(getSupportFragmentManager(), 1);
        vpp.setAdapter(p2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fixWindow();
    }



    private void fixWindow() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
