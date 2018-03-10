package com.ecuca.immunecircle.ui.userinfo;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;
import com.ecuca.immunecircle.ui.user.UserProtocolView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class UserInfoPresenter extends BaseActPresenter {
    //view
    UserInfoView v;

    @Inject
    public UserInfoPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (UserInfoView) actView;
    }
}
