package com.ecuca.immunecircle.app;

import android.app.Activity;
import android.app.Application;

import com.ecuca.immunecircle.dagger.ActivityComponent;
import com.ecuca.immunecircle.dagger.ActivityModule;
import com.ecuca.immunecircle.dagger.AppModule;
import com.ecuca.immunecircle.dagger.ApplicationComponent;
import com.ecuca.immunecircle.dagger.DaggerApplicationComponent;

/**
 * Created by tangli on 2018/2/11.
 */

public class MyApplication extends Application {
    public static MyApplication app;
    //Dagger2配置相关
    private static ApplicationComponent applicationComponent;
    private ActivityComponent activityComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化Dagger2
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
    }

    public void createActivityComponent(Activity activity) {
        activityComponent = applicationComponent.bind(new ActivityModule(activity));
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void releaseActivityComponent() {
        activityComponent = null;
    }

}
