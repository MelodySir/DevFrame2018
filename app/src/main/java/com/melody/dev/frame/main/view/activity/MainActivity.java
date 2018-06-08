package com.melody.dev.frame.main.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.melody.base.BaseActivity;
import com.melody.base.bottombar.BottomBarLayout;
import com.melody.dev.frame.R;
import com.melody.dev.frame.main.model.MainModel;
import com.melody.dev.frame.main.persenter.MainPresenter;
import com.melody.dev.frame.main.view.MainView;

import butterknife.BindView;

public class MainActivity
        extends BaseActivity<MainModel, MainView, MainPresenter>
        implements MainView {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.bb_main)
    BottomBarLayout bbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void afterSetContentView() {
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateFinished() {
        mPresenter.initViewPager(vpMain, getSupportFragmentManager());
        mPresenter.initBottomBar(bbMain,vpMain);
    }

    @Override
    public void preSetContentView() {
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
