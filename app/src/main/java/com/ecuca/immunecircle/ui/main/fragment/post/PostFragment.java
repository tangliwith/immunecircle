package com.ecuca.immunecircle.ui.main.fragment.post;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpFragment;

import javax.inject.Inject;

/**
 * 发帖
 */
public class PostFragment extends BaseMvpFragment implements PostView{
    @Inject
    PostPresenter presenter;

    @Override
    public void inJect() {
        MyApplication.app.createActivityComponent(getActivity());
        MyApplication.app.getActivityComponent().inJect(this);
    }

    @Override
    public BaseActPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int initRootView() {
        return R.layout.fragment_post;
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
