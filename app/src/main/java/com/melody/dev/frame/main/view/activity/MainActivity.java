package com.melody.dev.frame.main.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.melody.base.BaseActivity;
import com.melody.dev.frame.R;
import com.melody.dev.frame.main.model.MainModel;
import com.melody.dev.frame.main.persenter.MainPresenter;
import com.melody.dev.frame.main.view.MainView;

import butterknife.ButterKnife;

public class MainActivity
        extends BaseActivity<MainModel, MainView, MainPresenter>
        implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        butterKnifeUnBinder = ButterKnife.bind(this);
    }

//    @Override
//    public void afterSetContentView() {
//    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void preSetContentView() {
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}