package com.ecuca.immunecircle.app;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import com.ecuca.immunecircle.dagger.ActivityComponent;
import com.ecuca.immunecircle.dagger.ActivityModule;
import com.ecuca.immunecircle.dagger.AppModule;
import com.ecuca.immunecircle.dagger.ApplicationComponent;
import com.ecuca.immunecircle.dagger.DaggerApplicationComponent;
import com.ecuca.immunecircle.entity.LoginEntity;
import com.google.gson.Gson;

/**
 * Created by tangli on 2018/2/11.
 */

public class MyApplication extends Application {
    public static MyApplication app;
    //Dagger2配置相关
    private static ApplicationComponent applicationComponent;
    private ActivityComponent activityComponent;
    private SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化Dagger2
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
        sp = getSharedPreferences("sp_info", MODE_PRIVATE);
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

    public String getSharedPreferences(String name, String deflaut) {
        return sp.getString(name, deflaut);

    }

    public void setSharedPreferences(String name, String values) {
        sp.edit().putString(name, values).commit();

    }

    public LoginEntity.DataBean getUserInfo(){
        LoginEntity.DataBean bean=null;
        try{
            bean=new Gson().fromJson(getSharedPreferences("user_info",""),LoginEntity.DataBean.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 存放用户信息
     * @param bean
     */
    public void saveUserInfo(LoginEntity.DataBean bean){
        setSharedPreferences("user_info","");
        setSharedPreferences("user_info",new Gson().toJson(bean));
    }

    /**
     *  清除用户信息
     */
    public void removeUserInfo(){
        setSharedPreferences("user_info","");
    }

    /**
     * 获取用户是否登陆
     * @return
     */
    public boolean getUserIsLogin(){

        LoginEntity.DataBean bean=getUserInfo();
        if(bean!=null){

            return true;
        }
        else{
            return false;
        }
    }
}
