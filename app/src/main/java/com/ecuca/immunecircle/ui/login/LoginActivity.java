package com.ecuca.immunecircle.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;
import com.ecuca.immunecircle.ui.forget.ForgetPasswordActivity;
import com.ecuca.immunecircle.ui.main.MainActivity;
import com.ecuca.immunecircle.ui.register.RegisterActivity;
import com.ecuca.immunecircle.utils.ActivitySwitcher;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录
 */
public class LoginActivity extends BaseMvpActivity implements LoginView {
    @Inject
    LoginPresenter presenter;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.img_change_pwd_status)
    ImageView imgChangePwdStatus;
    @BindView(R.id.lin_forget_pwd)
    LinearLayout linForgetPwd;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    boolean isShow;

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
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setTitleText("登录");
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }

    @OnClick({R.id.tv_register, R.id.img_change_pwd_status, R.id.lin_forget_pwd, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                Bundle bundle0 = new Bundle();
                bundle0.putString("type", "注册");
                ActivitySwitcher.start(LoginActivity.this, RegisterActivity.class, bundle0, false);
                break;
            case R.id.img_change_pwd_status:
                if (isShow) {
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgChangePwdStatus.setImageResource(R.mipmap.icon_login_pwd_no_see);
                    isShow = false;
                } else {
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imgChangePwdStatus.setImageResource(R.mipmap.icon_login_pwd_see);
                    isShow = true;
                }
                break;
            case R.id.lin_forget_pwd:
                Bundle bundle1 = new Bundle();
                bundle1.putString("type", "忘记密码");
                ActivitySwitcher.start(LoginActivity.this, ForgetPasswordActivity.class, bundle1, false);
                break;
            case R.id.tv_login:
                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                if (!MyApplication.app.isMobileNO(phone)) {
                    ToastMessage("请输入正确的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    ToastMessage("请输入密码");
                    return;
                }
                presenter.doLogin(phone, pwd);
                break;
        }
    }

    @Override
    public void showMsg(String msg) {
        ToastMessage(msg);
    }

    @Override
    public void jumpToMain() {
        ActivitySwitcher.start(LoginActivity.this, MainActivity.class, false);
    }
}
