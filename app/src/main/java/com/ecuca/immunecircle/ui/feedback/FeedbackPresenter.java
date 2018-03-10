package com.ecuca.immunecircle.ui.feedback;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class FeedbackPresenter extends BaseActPresenter {
    //view
    FeedbackView v;

    @Inject
    public FeedbackPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (FeedbackView) actView;
    }

}
