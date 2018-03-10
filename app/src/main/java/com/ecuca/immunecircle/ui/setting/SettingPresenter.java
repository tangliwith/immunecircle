package com.ecuca.immunecircle.ui.setting;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;
import com.ecuca.immunecircle.ui.feedback.FeedbackView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class SettingPresenter extends BaseActPresenter {
    //view
    SettingView v;

    @Inject
    public SettingPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (SettingView) actView;
    }

}
