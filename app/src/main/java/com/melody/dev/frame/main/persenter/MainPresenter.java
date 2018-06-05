package com.melody.dev.frame.main.persenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.melody.base.BaseFragment;
import com.melody.base.BasePresenter;
import com.melody.dev.frame.adapter.MainPagerAdapter;
import com.melody.dev.frame.main.model.MainModel;
import com.melody.dev.frame.main.model.impl.MainModelImpl;
import com.melody.dev.frame.main.view.MainView;
import com.melody.dev.frame.main.view.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends BasePresenter<MainModel, MainView> {

    private List<BaseFragment> fragments = new ArrayList<>();

    public MainPresenter(MainView view) {
        super(view);
    }

    @Override
    public MainModel createModel() {
        return new MainModelImpl();
    }

    public void initViewPager(ViewPager pager, FragmentManager manager) {
        initFragments();
        pager.setAdapter(new MainPagerAdapter(manager, fragments));
    }

    private void initFragments() {
        fragments.clear();
        fragments.add(HomeFragment.getInstance("First Page", 0xffff0000));
        fragments.add(HomeFragment.getInstance("Second Page", 0xffffff00));
        fragments.add(HomeFragment.getInstance("Third Page", 0xff00ff00));
        fragments.add(HomeFragment.getInstance("Fourth Page", 0xff00ffff));
        fragments.add(HomeFragment.getInstance("Fifth Page", 0xff000000));
    }


}
