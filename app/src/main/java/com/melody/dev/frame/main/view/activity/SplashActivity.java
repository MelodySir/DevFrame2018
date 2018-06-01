package com.melody.dev.frame.main.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.melody.base.BaseActivity;
import com.melody.dev.frame.R;
import com.melody.dev.frame.main.model.SplashModel;
import com.melody.dev.frame.main.persenter.SplashPresenter;
import com.melody.dev.frame.main.view.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;
import cn.bingoogolapple.bgabanner.BGAOnNoDoubleClickListener;

public class SplashActivity
        extends BaseActivity<SplashModel, SplashView, SplashPresenter>
        implements SplashView {

    @BindView(R.id.iv_ad_splash)
    ImageView bgabAdSplash;
    @BindView(R.id.btn_jump_splash)
    TextView btnJumpSplash;
    @BindView(R.id.vs_guide_splash)
    ViewStub vsGuideSplash;

    private BGABanner bgBanner, fgBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        butterKnifeUnBinder = ButterKnife.bind(this);
    }

    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void preSetContentView() {
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

//    @Override
//    public void afterSetContentView() {
//        butterKnifeUnBinder = ButterKnife.bind(this);
//    }

    @Override
    public void onCreateFinished() {
//        mPresenter.showView();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    public void showSplashView() {
        btnJumpSplash.setText("跳过 0");
        btnJumpSplash.setOnClickListener(new BGAOnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                mPresenter.enterMainPage(mActivity);
            }
        });
    }

    private void initGuideView() {
        if (bgBanner == null || fgBanner == null) {
            vsGuideSplash.inflate();
            bgBanner = findViewById(R.id.bgab_bg_view_guide);
            fgBanner = findViewById(R.id.bgab_fg_view_guide);
        }
    }

    @Override
    public void showGuideView() {
        initGuideView();
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
                mPresenter.enterMainPage(mActivity);
            }
        });

    }

}
