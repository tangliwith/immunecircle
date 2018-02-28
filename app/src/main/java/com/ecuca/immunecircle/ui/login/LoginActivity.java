package com.ecuca.immunecircle.ui.login;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.BindView;

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

    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
