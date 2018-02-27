package com.ecuca.immunecircle.ui.main;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class MainPresenter extends BaseActPresenter {
    //View
    MainView v;

    @Inject
    public MainPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (MainView) actView;
    }
}
