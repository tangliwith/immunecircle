package com.ecuca.immunecircle.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 * MvpActivity基类
 *
 * @param <V>
 * @param <T>
 */
public abstract class BaseMvpFragment<V extends BaseActView, T extends BaseActPresenter<V>> extends Fragment implements BaseActView {

    public T presenter;
    private View mContentView = null;
    protected LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mContentView == null) {
            this.mInflater = inflater;
            inJect();
            presenter = initPresenter();
            presenter.attachView(this);
            mContentView = mInflater.inflate(initRootView(), null);
            ButterKnife.bind(this, mContentView);
            initView();
            bindingEvent();
        }
        return mContentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attach((V) this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        release();
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.dettach();
        }
        super.onDestroy();
    }

    //注册该界面，每个界面都要实现
    public abstract void inJect();

    //初始化协调者
    public abstract T initPresenter();

    //初始化布局文件id
    public abstract int initRootView();

    //初始化View
    public abstract void initView();

    //绑定事件
    public abstract void bindingEvent();

    //释放资源
    public abstract void release();


}
