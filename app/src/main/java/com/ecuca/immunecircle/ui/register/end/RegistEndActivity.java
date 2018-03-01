package com.ecuca.immunecircle.ui.register.end;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

/**
 * 注册时输入密码的页面
 */
public class RegistEndActivity extends BaseMvpActivity implements RegisterEndView{
    @Inject
    RegistEndPresenter presenter;

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
        return R.layout.activity_regist_end;
    }

    @Override
    public void initView() {
        showTitleBack();
        setTitleText("注册");
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
