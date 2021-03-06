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

        for (int i = 0; i < 2; i++) {
            ViewPager vp = (ViewPager)findViewById(Constants.Pagers[i]);
            vp.setOffscreenPageLimit(2);
            PlayerAdapter pa = new PlayerAdapter(getSupportFragmentManager(), i);
            vp.setAdapter(pa);
        }
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
