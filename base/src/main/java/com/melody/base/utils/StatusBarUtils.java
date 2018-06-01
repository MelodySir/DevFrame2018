package com.melody.base.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * 使用自定义状态栏背景时需设置全屏
 */
public class StatusBarUtils {

    private View mStatusBarView = null;

    private Integer screenWidth = null, statusBarHeight = null;
    private ViewGroup.LayoutParams layoutParams = null;

    public StatusBarUtils() {
    }

    private void initParams(Activity mActivity) {
        if (layoutParams != null) return;
        if (statusBarHeight == null || screenWidth == null) {
            screenWidth = ScreenUtils.getScreenWidth();
            statusBarHeight = getStatusBarHeight(mActivity);
        }
        layoutParams = new ViewGroup.LayoutParams(screenWidth, statusBarHeight);
    }

    //获取视图
    public View getmStatusBarView(Activity mActivity) {
        if (mStatusBarView == null) createStatusView(mActivity);
        return mStatusBarView;
    }

    //设置颜色
    public void setmStatusBarColor(int color) {
        if (mStatusBarView == null) return;
        mStatusBarView.setBackgroundColor(color);
    }

    //显示隐藏
    public void setmStatusBarVisibility(boolean show) {
        if (mStatusBarView == null) return;
        mStatusBarView.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    /**
     * 生成一个和状态栏大小相同的矩形条 * * @param activity 需要设置的activity * * @param color 状态栏颜色值 * * @return 状态栏矩形条
     */
    private void createStatusView(Activity mActivity) {
        if (mStatusBarView == null) return;
        mStatusBarView = new View(mActivity);
        initParams(mActivity);
        mStatusBarView.setLayoutParams(layoutParams);
        mStatusBarView.requestLayout();
    }

    /**
     * 获取状态栏高度
     */
    private int getStatusBarHeight(Activity activity) {
        int statusBarHeight = 0;
        if (activity != null) {
            int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }


}
