package com.ecuca.immunecircle.ui.splash;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

public class SplashAct extends BaseMvpActivity implements SplashView {

    @Override
    public void inJect() {
        MyApplication.app.createActivityComponent(this);
        MyApplication.app.getActivityComponent().inJect(this);
    }

    @Override
    public BaseActPresenter initPresenter() {
        return null;
    }

    @Override
    public int initRootView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
