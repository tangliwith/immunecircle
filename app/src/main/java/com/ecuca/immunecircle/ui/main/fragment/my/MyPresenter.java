package com.ecuca.immunecircle.ui.main.fragment.my;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class MyPresenter extends BaseActPresenter {
    //View
    MyView v;

    @Inject
    public MyPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (MyView) actView;
    }
}
