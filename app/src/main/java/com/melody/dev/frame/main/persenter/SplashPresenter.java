package com.melody.dev.frame.main.persenter;

import android.app.Activity;
import android.content.Intent;

import com.blankj.utilcode.util.ActivityUtils;
import com.melody.base.BasePresenter;
import com.melody.dev.frame.main.model.SplashModel;
import com.melody.dev.frame.main.model.impl.SplashModelImpl;
import com.melody.dev.frame.main.view.SplashView;
import com.melody.dev.frame.main.view.activity.MainActivity;

public class SplashPresenter extends BasePresenter<SplashModel, SplashView> {


    public SplashPresenter(SplashView view) {
        super(view);
    }

    @Override
    public SplashModel createModel() {
        return new SplashModelImpl();
    }

    //进入主页
    public void enterMainPage(Activity activity) {
        ActivityUtils.startActivity(new Intent(activity, MainActivity.class));
        activity.finish();
    }

    //根据是否是第一次启动判断显示引导页还是广告页
    public void showView() {
        if (mModel.get().isFirstLaunch())
            mView.get().showGuideView();
        else mView.get().showSplashView();
    }

}
