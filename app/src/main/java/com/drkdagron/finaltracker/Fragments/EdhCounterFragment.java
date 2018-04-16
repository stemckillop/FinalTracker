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

public class EdhCounterFragment extends Fragment {
    private static final String ARG_PLAYER_WATCH = "player_watch";
    public int playerWatching;

    public static EdhCounterFragment newInstance(int player) {
        EdhCounterFragment frag = new EdhCounterFragment();
        Bundle bun = new Bundle();
        bun.putInt(ARG_PLAYER_WATCH, player);
        frag.setArguments(bun);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contain_edh, container, false);

        v.findViewById(R.id.pExperSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyExperience(getArguments().getInt(ARG_PLAYER_WATCH), false);
            }
        });
        v.findViewById(R.id.pExperAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyExperience(getArguments().getInt(ARG_PLAYER_WATCH), true);
            }
        });

        v.findViewById(R.id.pCmdrSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCmdrTax(getArguments().getInt(ARG_PLAYER_WATCH), false);
            }
        });
        v.findViewById(R.id.pCmdrAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyCmdrTax(getArguments().getInt(ARG_PLAYER_WATCH), true);
            }
        });

        return v;
    }

    public void modifyExperience(int player, boolean add) {
        //Log.w(TAG, v.getTag().toString().substring(3));

        if (add) {
            LifeManager.getInstance().players[player].Experience++;
        } else if (!add) {
            LifeManager.getInstance().players[player].Experience--;
        }

        ((TextView)getView().findViewById(R.id.pExper)).setText(String.valueOf(LifeManager.getInstance().players[player].Experience));
    }

    public void modifyCmdrTax(int player, boolean add) {
        //Log.w(TAG, v.getTag().toString().substring(3));

        if (add) {
            LifeManager.getInstance().players[player].CmdrTax++;
        } else if (!add) {
            LifeManager.getInstance().players[player].CmdrTax--;
        }

        ((TextView)getView().findViewById(R.id.pTax)).setText(String.valueOf(LifeManager.getInstance().players[player].CmdrTax));
    }
}
