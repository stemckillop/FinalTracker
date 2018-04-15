package com.drkdagron.finaltracker.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drkdagron.finaltracker.R;

public class CounterFragment extends Fragment {
    private static final String ARG_PLAYER_WATCH = "player_watch";
    public int playerWatching;

    public static CounterFragment newInstance(int player) {
        CounterFragment frag = new CounterFragment();
        Bundle bun = new Bundle();
        bun.putInt(ARG_PLAYER_WATCH, player);
        frag.setArguments(bun);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contain_counter, container, false);



        return v;
    }
}
