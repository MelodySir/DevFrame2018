package com.melody.dev.frame.main.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.melody.base.BaseActivity;
import com.melody.base.BasePresenter;
import com.melody.dev.frame.R;
import com.melody.dev.frame.main.persenter.SplashPresenter;
import com.melody.dev.frame.main.view.SplashView;
import com.melody.dev.frame.utils.MSpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;
import cn.bingoogolapple.bgabanner.BGAOnNoDoubleClickListener;

public class SplashActivity extends BaseActivity implements SplashView {

    @BindView(R.id.iv_ad_splash)
    ImageView bgabAdSplash;
    @BindView(R.id.btn_jump_splash)
    TextView btnJumpSplash;
    @BindView(R.id.vs_guide_splash)
    ViewStub vsGuideSplash;

    private BGABanner bgBanner, fgBanner;
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
        btnJumpSplash.setText("跳过 0");
        btnJumpSplash.setOnClickListener(new BGAOnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ActivityUtils.startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void loadGuideView() {
        vsGuideSplash.inflate();
        bgBanner = findViewById(R.id.bgab_bg_view_guide);
        fgBanner = findViewById(R.id.bgab_fg_view_guide);

        // Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);

        bgBanner.setData(localImageSize,
                ImageView.ScaleType.CENTER_CROP,
                R.mipmap.image_guide_background_1,
                R.mipmap.image_guide_background_2,
                R.mipmap.image_guide_background_3);

        fgBanner.setData(localImageSize,
                ImageView.ScaleType.CENTER_CROP,
                R.mipmap.image_guide_foreground_1,
                R.mipmap.image_guide_foreground_2,
                R.mipmap.image_guide_foreground_3);


        fgBanner.setEnterSkipViewIdAndDelegate(R.id.tv_enter_view_guide, 0, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                ActivityUtils.startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });

    }

}
