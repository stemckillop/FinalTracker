package com.drkdagron.finaltracker;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class P3Activity extends AppCompatActivity {
    public final String TAG = "P3Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifeManager.getInstance().resetPlayers(3);
        setContentView(R.layout.activity_p3);

        for (int i = 0; i < 3; i++) {
            ViewPager vp = (ViewPager)findViewById(Constants.Pagers[i]);
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
