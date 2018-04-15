package com.drkdagron.finaltracker;

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        fixWindow();
    }

    public void modifyLife(View v) {
        //Log.w(TAG, v.getTag().toString().substring(3));
        int player = Integer.parseInt(v.getTag().toString().substring(1, 2));
        String action = v.getTag().toString().substring(3);

        if (action.equals("add")) {
            LifeManager.getInstance().players[player-1].Life++;
        } else if (action.equals("sub")) {
            LifeManager.getInstance().players[player-1].Life--;
        }

        if (player == 1) {
            ((TextView)findViewById(R.id.p1L)).setText(String.valueOf(LifeManager.getInstance().players[player-1].Life));
        } else if (player == 2) {
            ((TextView)findViewById(R.id.p2L)).setText(String.valueOf(LifeManager.getInstance().players[player-1].Life));
        }
    }

    private void fixWindow() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
