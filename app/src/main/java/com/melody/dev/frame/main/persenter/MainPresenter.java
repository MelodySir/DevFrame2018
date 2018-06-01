package com.melody.dev.frame.main.persenter;

import com.melody.base.BasePresenter;
import com.melody.dev.frame.main.model.MainModel;
import com.melody.dev.frame.main.model.impl.MainModelImpl;
import com.melody.dev.frame.main.view.MainView;

public class MainPresenter extends BasePresenter<MainModel, MainView> {

    public MainPresenter(MainView view) {
        super(view);
    }

    @Override
    public MainModel createModel() {
        return new MainModelImpl();
    }
}
