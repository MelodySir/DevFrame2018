package com.melody.dev.frame.main.persenter;

import com.melody.base.BasePresenter;
import com.melody.dev.frame.main.model.SplashModel;
import com.melody.dev.frame.main.view.SplashView;

public class SplashPresenter extends BasePresenter<SplashModel, SplashView> {

    private SplashModel mModel;

    public SplashPresenter(SplashView view) {
        attachView(view);
    }


}
