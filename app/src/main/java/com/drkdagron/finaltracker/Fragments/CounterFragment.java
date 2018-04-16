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

        v.findViewById(R.id.pInfectSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyInfect(getArguments().getInt(ARG_PLAYER_WATCH), false);
            }
        });
        v.findViewById(R.id.pInfectAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyInfect(getArguments().getInt(ARG_PLAYER_WATCH), true);
            }
        });

        v.findViewById(R.id.pEnergySub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyEnergy(getArguments().getInt(ARG_PLAYER_WATCH), false);
            }
        });
        v.findViewById(R.id.pEnergyAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyEnergy(getArguments().getInt(ARG_PLAYER_WATCH), true);
            }
        });

        return v;
    }

    public void modifyInfect(int player, boolean add) {
        //Log.w(TAG, v.getTag().toString().substring(3));

        if (add) {
            LifeManager.getInstance().players[player].Infect++;
        } else if (!add) {
            LifeManager.getInstance().players[player].Infect--;
        }

        ((TextView)getView().findViewById(R.id.pInfect)).setText(String.valueOf(LifeManager.getInstance().players[player].Infect));
    }

    public void modifyEnergy(int player, boolean add) {
        //Log.w(TAG, v.getTag().toString().substring(3));

        if (add) {
            LifeManager.getInstance().players[player].Energy++;
        } else if (!add) {
            LifeManager.getInstance().players[player].Energy--;
        }

        ((TextView)getView().findViewById(R.id.pEnergy)).setText(String.valueOf(LifeManager.getInstance().players[player].Energy));
    }
}
