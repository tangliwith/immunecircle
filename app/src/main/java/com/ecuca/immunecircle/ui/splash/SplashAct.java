package com.ecuca.immunecircle.ui.splash;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;
import com.ecuca.immunecircle.ui.login.LoginActivity;
import com.ecuca.immunecircle.ui.main.MainActivity;
import com.ecuca.immunecircle.ui.wellcome.WelcomeGuideActivity;
import com.ecuca.immunecircle.utils.ActivitySwitcher;

import javax.inject.Inject;

public class SplashAct extends BaseMvpActivity implements SplashView {
    @Inject
    SplashPresenter presenter;

    @Override
    public void inJect() {
        MyApplication.app.createActivityComponent(this);
        MyApplication.app.getActivityComponent().inJect(this);
    }

    @Override
    public BaseActPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int initRootView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        presenter.jumpActivity();
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }


    @Override
    public void jumpToGuide() {
        ActivitySwitcher.start(SplashAct.this, WelcomeGuideActivity.class, true);
    }

    @Override
    public void jumpToLogin() {
        ActivitySwitcher.start(SplashAct.this, LoginActivity.class, true);
    }

    @Override
    public void jumpToMain() {
        ActivitySwitcher.start(SplashAct.this, MainActivity.class, true);
    }
}
