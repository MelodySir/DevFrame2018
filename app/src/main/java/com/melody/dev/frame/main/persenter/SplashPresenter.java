package com.melody.dev.frame.main.persenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.blankj.utilcode.util.ActivityUtils;
import com.melody.base.BasePresenter;
import com.melody.dev.frame.main.model.SplashModel;
import com.melody.dev.frame.main.model.impl.SplashModelImpl;
import com.melody.dev.frame.main.view.SplashView;

public class SplashPresenter extends BasePresenter<SplashModel, SplashView> {

    //倒计时，3s
    private static final int COUNT_DOWN_TIME = 3;
    //间隔1s
    private int COUNT_DOWN_INTERVAL = 1000;
    //当前剩余时间
    private int currentRemainingTime = 3;

    private Handler timerHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what != 10) return false;
            if (currentRemainingTime >= 1) {
                mView.get().setJumpBtnTime(--currentRemainingTime);
                loopDelay(COUNT_DOWN_INTERVAL);
            } else {
                mView.get().enterMainPage();
            }
            return false;
        }
    });

    public SplashPresenter(SplashView view) {
        super(view);
    }

    @Override
    public SplashModel createModel() {
        return new SplashModelImpl();
    }

    //进入主页
    public void enterMainPage(Activity activity) {
        ActivityUtils.startActivity(new Intent(activity, com.melody.dev.frame.main.view.activity.MainActivity.class));
        activity.finish();
    }

    //根据是否是第一次启动判断显示引导页还是广告页
    public void showView() {
        if (mModel.get().isFirstLaunch())
            mView.get().showGuideView();
        else mView.get().showSplashView();
    }

    // 开始倒计时
    public void startCountDown() {
        currentRemainingTime = COUNT_DOWN_TIME;
        mView.get().setJumpBtnTime(currentRemainingTime);
        loopDelay(COUNT_DOWN_INTERVAL);
    }

    public void destroy() {
        timerHandler.removeCallbacksAndMessages(null);
    }

    private void loopDelay(long time) {
        timerHandler.sendEmptyMessageDelayed(10, time);
    }

}
