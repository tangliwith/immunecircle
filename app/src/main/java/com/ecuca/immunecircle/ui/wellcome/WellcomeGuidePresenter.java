package com.ecuca.immunecircle.ui.wellcome;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/28.
 */

public class WellcomeGuidePresenter extends BaseActPresenter {
    //view
    WellcomeGuideView v;


    @Inject
    public WellcomeGuidePresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (WellcomeGuideView) actView;
    }
}
