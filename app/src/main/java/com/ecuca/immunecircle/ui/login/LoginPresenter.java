package com.ecuca.immunecircle.ui.login;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class LoginPresenter extends BaseActPresenter {
    //view
    LoginView v;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (LoginView) actView;
    }
}
