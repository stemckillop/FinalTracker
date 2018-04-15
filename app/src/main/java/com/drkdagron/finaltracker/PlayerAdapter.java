package com.drkdagron.finaltracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.drkdagron.finaltracker.Fragments.CounterFragment;
import com.drkdagron.finaltracker.Fragments.LifeFragment;

public class PlayerAdapter extends FragmentPagerAdapter {
    public int player;

    public PlayerAdapter(FragmentManager fm, int player) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if (position == 0) {
            frag = LifeFragment.newInstance(1);
        } else if (position == 1) {
            frag = new CounterFragment();
        }

        return frag;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
