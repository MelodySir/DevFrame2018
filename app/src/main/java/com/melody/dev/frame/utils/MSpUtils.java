package com.melody.dev.frame.utils;

import com.blankj.utilcode.util.SPUtils;

public class MSpUtils {

    public static final String SP_CONFIG = "config";
    public static final String SP_AD_COUNT = "ad_count";

    //是否是首次启动
    public static boolean isFirstLaunch() {
        boolean firstLaunch = SPUtils.getInstance(SP_CONFIG).getBoolean("first_launch", true);
        if (firstLaunch) SPUtils.getInstance(SP_CONFIG).put("first_launch", false);
        return firstLaunch;
    }


}
