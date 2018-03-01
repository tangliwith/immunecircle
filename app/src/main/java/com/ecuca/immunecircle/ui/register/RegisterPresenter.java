package com.ecuca.immunecircle.ui.register;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class RegisterPresenter extends BaseActPresenter {
    //view
    RegisterView v;

    @Inject
    public RegisterPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (RegisterView) actView;
    }

    /**
     * 发送短信验证码
     */
    public void sendCode(String phone) {

    }
}
