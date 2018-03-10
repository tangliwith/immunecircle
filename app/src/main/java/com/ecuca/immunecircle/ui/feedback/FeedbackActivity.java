package com.ecuca.immunecircle.ui.feedback;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

/**
 * 意见反馈
 */
public class FeedbackActivity extends BaseMvpActivity implements FeedbackView {
    @Inject
    FeedbackPresenter presenter;

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
        return R.layout.activity_feedback;
    }

    @Override
    public void initView() {
        showTitleBack();
        setBottomTextName("提交意见");
        setTitleText("意见反馈");
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
