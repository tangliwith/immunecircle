package com.ecuca.immunecircle.ui.splash;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class SplashPresenter extends BaseActPresenter {
    //view
    SplashView v;

    @Inject
    public SplashPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (SplashView) actView;
    }
}
