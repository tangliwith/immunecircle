package com.ecuca.immunecircle.ui.register.input;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册时输入验证码页面
 */
public class RegistInputCodeActivity extends BaseMvpActivity implements RegistInputCodeView {
    @Inject
    RegistInputCodePresenter presenter;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_regist_time)
    TextView tvRegistTime;
    @BindView(R.id.tv_regist_get_code)
    TextView tvRegistGetCode;
    @BindView(R.id.ll_code_input)
    LinearLayout llCodeInput;
    @BindView(R.id.tv_regist_send_code)
    TextView tvRegistSendCode;

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
        return R.layout.activity_regist_input_code;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras();
        showTitleBack();
        setTitleText(bundle.getString("type"));
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }

    @OnClick({R.id.tv_regist_get_code, R.id.tv_regist_send_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_regist_get_code:
                break;
            case R.id.tv_regist_send_code:
                break;
        }
    }
}
