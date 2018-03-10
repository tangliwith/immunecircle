package com.ecuca.immunecircle.ui.main.fragment.hot;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class HotListPresenter extends BaseActPresenter {
    //View
    HotListView v;

    @Inject
    public HotListPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (HotListView) actView;
    }
}
