package com.melody.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseModel, T extends BaseView> {

    public WeakReference<T> mView;

    //绑定视图
    public void attachView(T view) {
        mView = new WeakReference<>(view);
    }

    //清空视图
    void detachView() {
        mView.clear();
    }


}
