package com.ecuca.immunecircle.app;

import android.app.Application;

/**
 * Created by tangli on 2018/2/11.
 */

public class MyApplication extends Application {
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
