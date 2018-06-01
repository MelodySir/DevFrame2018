package com.melody.dev.frame.main.model.impl;

import com.melody.dev.frame.main.model.SplashModel;
import com.melody.dev.frame.utils.MSpUtils;

public class SplashModelImpl implements SplashModel {

    @Override
    public boolean isFirstLaunch() {
        return MSpUtils.isFirstLaunch();
    }

}
