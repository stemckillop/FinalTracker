package com.drkdagron.finaltracker;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.drkdagron.finaltracker.Fragments.CounterFragment;
import com.drkdagron.finaltracker.Fragments.EdhCounterFragment;
import com.drkdagron.finaltracker.Fragments.LifeFragment;

public class PlayerAdapter extends FragmentStatePagerAdapter {
    public int player;

    public PlayerAdapter(FragmentManager fm, int player) {
        super(fm);
        this.player = player;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if (position == 0) {
            frag = LifeFragment.newInstance(player);
        } else if (position == 1) {
            frag = CounterFragment.newInstance(player);
        } else if (position == 2) {
            frag = EdhCounterFragment.newInstance(player);
        }

        return frag;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
