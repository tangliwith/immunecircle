package com.ecuca.immunecircle.ui.splash;

import android.text.TextUtils;

import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by tangli on 2018/2/11.
 */

public class SplashPresenter extends BaseActPresenter {
    //view
    SplashView v;

    @Inject
    public SplashPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (SplashView) actView;
    }

    /**
     * 延迟跳转
     */
    public void jumpActivity() {
        Observable.timer(1300, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    if (TextUtils.isEmpty(MyApplication.app.getSharedPreferences("is_first", ""))) {
                        v.jumpToGuide();
                    } else {
                        if (MyApplication.app.getUserIsLogin()) {
                            v.jumpToMain();
                        } else {
                            v.jumpToLogin();
                        }
                    }
                });
    }
}
