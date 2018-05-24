package com.melody.dev.frame.main.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.melody.base.BaseActivity;
import com.melody.base.BasePresenter;
import com.melody.dev.frame.R;
import com.melody.dev.frame.adapter.SplashGuideAdapter;
import com.melody.dev.frame.main.persenter.SplashPresenter;
import com.melody.dev.frame.main.view.SplashView;
import com.melody.dev.frame.utils.MSpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashView {

    @BindView(R.id.iv_ad_splash)
    ImageView ivAdSplash;
    @BindView(R.id.btn_jump_splash)
    TextView btnJumpSplash;
    @BindView(R.id.vs_guide_splash)
    ViewStub vsGuideSplash;

    private ViewPager guideViewPager;

    private SplashPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mPresenter = new SplashPresenter(this);
        initView();
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void initView() {
        try {
            if (MSpUtils.isFirstLaunch())
                loadGuideView();
            else initSplashView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initSplashView() {
        btnJumpSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });
        btnJumpSplash.setText("跳过 0");
        btnJumpSplash.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadGuideView() {
        vsGuideSplash.inflate();
        guideViewPager = findViewById(R.id.vp_guide);
        guideViewPager.setAdapter(new SplashGuideAdapter(getSupportFragmentManager()));
    }

}
