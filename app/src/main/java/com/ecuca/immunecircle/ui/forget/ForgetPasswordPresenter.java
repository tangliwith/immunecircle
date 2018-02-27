package com.ecuca.immunecircle.ui.forget;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class ForgetPasswordPresenter extends BaseActPresenter {
    //view
    ForgetPasswordView v;

    @Inject
    public ForgetPasswordPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (ForgetPasswordView) actView;
    }
}
