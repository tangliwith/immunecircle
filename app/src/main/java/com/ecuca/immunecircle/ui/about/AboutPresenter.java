package com.ecuca.immunecircle.ui.about;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class AboutPresenter extends BaseActPresenter {
    //view
    AboutView v;

    @Inject
    public AboutPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (AboutView) actView;
    }
}
