package com.ecuca.immunecircle.ui.main.fragment.post;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class PostPresenter extends BaseActPresenter {
    //View
    PostView v;

    @Inject
    public PostPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (PostView) actView;
    }
}
