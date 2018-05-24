package com.melody.dev.frame.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ActivityUtils;
import com.melody.dev.frame.R;
import com.melody.dev.frame.main.view.impl.MainActivity;

@SuppressLint("ValidFragment")
public class GuideFragment extends Fragment {

    private int imageId;

    @SuppressLint("ValidFragment")
    public GuideFragment(int imageId) {
        this.imageId = imageId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ImageView iv = new ImageView(getContext());
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageResource(imageId);
        if (imageId == R.mipmap.img_guide_four)
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityUtils.startActivity(new Intent(getActivity(), MainActivity.class));
                    ActivityUtils.finishActivity(getActivity());
                }
            });

        return iv;
    }
}
