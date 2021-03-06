package com.ecuca.immunecircle.ui.register;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 */
public class RegisterActivity extends BaseMvpActivity implements RegisterView {
    @Inject
    RegisterPresenter presenter;
    @BindView(R.id.et_phone)
    EditText etPhone;
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
        return R.layout.activity_register;
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

    @OnClick(R.id.tv_regist_send_code)
    public void onClick() {
        String phone = etPhone.getText().toString().trim();
        if (!MyApplication.app.isMobileNO(phone)) {
            ToastMessage("请输入正确的手机号码");
            return;
        }
        presenter.sendCode(phone);
    }
}
