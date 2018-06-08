package com.melody.dev.frame.main.view;

import com.melody.base.BaseView;

public interface SplashView extends BaseView{

    // 显示闪屏页
    void showSplashView();

    // 显示引导页
    void showGuideView();

    //设置跳过按钮显示秒数
    void setJumpBtnTime(int seconds);

    void enterMainPage();

}
