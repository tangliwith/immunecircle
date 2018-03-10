package com.ecuca.immunecircle.ui.main.fragment.message;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class MessagePresenter extends BaseActPresenter {
    //View
    MessageView v;

    @Inject
    public MessagePresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (MessageView) actView;
    }
}
