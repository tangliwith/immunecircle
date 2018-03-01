package com.ecuca.immunecircle.ui.register.input;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/3/1.
 */

public class RegistInputCodePresenter extends BaseActPresenter {
    //view
    RegistInputCodeView v;

    @Inject
    public RegistInputCodePresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (RegistInputCodeView) actView;
    }
}
