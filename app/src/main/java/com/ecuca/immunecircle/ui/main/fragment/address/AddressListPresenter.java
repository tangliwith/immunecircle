package com.ecuca.immunecircle.ui.main.fragment.address;

import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import javax.inject.Inject;

/**
 * Created by tangli on 2018/2/11.
 */

public class AddressListPresenter extends BaseActPresenter {
    //View
    AddressListView v;

    @Inject
    public AddressListPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (AddressListView) actView;
    }
}
