package com.ecuca.immunecircle.ui.register.end;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/3/1.
 */

public class RegistEndPresenter extends BaseActPresenter {
    //view
    RegisterEndView v;

    @Inject
    public RegistEndPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (RegisterEndView) actView;
    }
}
