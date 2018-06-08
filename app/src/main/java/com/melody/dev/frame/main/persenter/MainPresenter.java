package com.melody.dev.frame.main.persenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.blankj.utilcode.util.ToastUtils;
import com.melody.base.BaseFragment;
import com.melody.base.BasePresenter;
import com.melody.base.bottombar.BottomBarItem;
import com.melody.base.bottombar.BottomBarLayout;
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

    public void initBottomBar(BottomBarLayout bbLayout, ViewPager pager) {
        bbLayout.setViewPager(pager);
        bbLayout.setOnItemSelectedListener(new BBSelectListenerImpl());
    }

    private void initFragments() {
        fragments.clear();
        fragments.add(HomeFragment.getInstance("首页", 0xffff0000));
        fragments.add(HomeFragment.getInstance("视频", 0xffffff00));
        fragments.add(HomeFragment.getInstance("微头条", 0xff00ff00));
        fragments.add(HomeFragment.getInstance("我的", 0xff00ffff));
    }

    private class BBSelectListenerImpl implements BottomBarLayout.OnItemSelectedListener {

        private long clickTime = 0;

        @Override
        public void onItemSelected(BottomBarItem bottomBarItem, int previousPosition, int currentPosition) {
            if (previousPosition == currentPosition) {
                long currentTime = System.currentTimeMillis();
                //当点击间隔小于400ms，判定为双击
                if (currentTime - clickTime < 400) {
                    ToastUtils.showShort("双击:" + bottomBarItem.getTextView().getText());
                    return;
                }

                clickTime = currentTime;
                ToastUtils.showShort("单击同一标题:" + bottomBarItem.getTextView().getText());
                return;
            }
            clickTime = 0;
            ToastUtils.showShort("切换至:" + bottomBarItem.getTextView().getText());
        }
    }


}
