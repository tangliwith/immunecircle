package com.ecuca.immunecircle.ui.user;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class UserProtocolPresenter extends BaseActPresenter {
    //view
    UserProtocolView v;

    @Inject
    public UserProtocolPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (UserProtocolView) actView;
    }
}
