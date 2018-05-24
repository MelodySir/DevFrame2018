package com.melody.dev.frame.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.melody.dev.frame.R;
import com.melody.dev.frame.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

public class SplashGuideAdapter extends FragmentPagerAdapter {

    private final int[] imgs = new int[]
            {
                    R.mipmap.img_guide_one, R.mipmap.img_guide_two,
                    R.mipmap.img_guide_three, R.mipmap.img_guide_four
            };

    public SplashGuideAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private List<Fragment> fragments = new ArrayList<>();

    private void initFragments() {
        fragments.clear();
        for (int imgResId : imgs) {
            fragments.add(new GuideFragment(imgResId));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
