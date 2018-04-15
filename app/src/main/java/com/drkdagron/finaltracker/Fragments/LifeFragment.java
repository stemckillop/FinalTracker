package com.drkdagron.finaltracker.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.drkdagron.finaltracker.LifeManager;
import com.drkdagron.finaltracker.R;

public class LifeFragment extends Fragment {
    private static final String ARG_PLAYER_WATCH = "player_watch";
    public int playerWatching;

    public static LifeFragment newInstance(int player) {
        LifeFragment frag = new LifeFragment();
        Bundle bun = new Bundle();
        bun.putInt(ARG_PLAYER_WATCH, player);
        frag.setArguments(bun);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contain_life, container, false);

        v.findViewById(R.id.pAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyLife(getArguments().getInt(ARG_PLAYER_WATCH), true);
            }
        });
        v.findViewById(R.id.pSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyLife(getArguments().getInt(ARG_PLAYER_WATCH), false);
            }
        });

        return v;
    }

    public void modifyLife(int player, boolean add) {
        //Log.w(TAG, v.getTag().toString().substring(3));

        if (add) {
            LifeManager.getInstance().players[player].Life++;
        } else if (!add) {
            LifeManager.getInstance().players[player].Life--;
        }

        ((TextView)getView().findViewById(R.id.pL)).setText(String.valueOf(LifeManager.getInstance().players[player].Life));
    }
}
