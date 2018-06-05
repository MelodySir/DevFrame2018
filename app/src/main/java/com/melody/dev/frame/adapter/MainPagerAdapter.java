package com.melody.dev.frame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.melody.base.BaseFragment;

import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    public MainPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
