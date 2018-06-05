package com.melody.dev.frame.main.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.melody.base.BaseFragment;
import com.melody.base.utils.StatusBarUtils;
import com.melody.dev.frame.R;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.container_status_bar_home_fragment)
    LinearLayout statusBarContainer;
    @BindView(R.id.tv_title_home_fragment)
    TextView tvTitleHomeFragment;
    @BindView(R.id.tv_content_home_fragment)
    TextView tvContentHomeFragment;

    private String contentString = null;
    private Integer topColor = null;

    private StatusBarUtils mStatusBarUtils = null;
    private View statusBarView = null;

    public static HomeFragment getInstance(String title, int color) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", title);
        bundle.putInt("color", color);
        fragment.setArguments(bundle);
        return fragment;
    }

    @SuppressLint("ValidFragment")
    private HomeFragment() {
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            contentString = getArguments().getString("content");
            topColor = getArguments().getInt("color");
        }
    }

    @Override
    public void onCreateViewFinished(View fragmentView) {
        tvContentHomeFragment.setText(contentString == null ? "暂无数据" : contentString);
        if (topColor != null) tvTitleHomeFragment.setBackgroundColor(topColor);


        if (statusBarView == null) {
            if (mStatusBarUtils == null) mStatusBarUtils = new StatusBarUtils();
            statusBarView = mStatusBarUtils.getStatusBarView(getActivity());
        }
//        statusBarContainer.removeAllViews();
        if (statusBarView != null) {
            if(statusBarView.getParent()!=null)((LinearLayout)statusBarView.getParent()).removeView(statusBarView);
            statusBarView.setBackgroundColor(Color.BLACK);
            statusBarContainer.addView(statusBarView, 0);
            if (topColor != null && (topColor == 0xffffff00 || topColor == 0xff00ff00))
                statusBarView.setVisibility(View.VISIBLE);
            else statusBarView.setVisibility(View.GONE);
        }

    }


}
