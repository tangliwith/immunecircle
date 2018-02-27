package com.ecuca.immunecircle.ui.main;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

/**
 * 主页
 */
public class MainActivity extends BaseMvpActivity implements MainView {

    @Inject
    MainPresenter presenter;

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
        return R.layout.activity_main;
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
