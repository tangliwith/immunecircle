package com.ecuca.immunecircle.ui.about;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

/**
 * 关于我们
 */
public class AboutActivity extends BaseMvpActivity implements AboutView {

    @Inject
    AboutPresenter presenter;

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
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        showTitleBack();
        setTitleText("关于我们");
        setTitleRightImg(R.mipmap.ic_top_right, v -> {
            //按钮点击事件处理

        });
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
