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

import java.util.regex.Pattern;

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

    public LoginEntity.DataBean getUserInfo() {
        LoginEntity.DataBean bean = null;
        try {
            bean = new Gson().fromJson(getSharedPreferences("user_info", ""), LoginEntity.DataBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 存放用户信息
     *
     * @param bean
     */
    public void saveUserInfo(LoginEntity.DataBean bean) {
        setSharedPreferences("user_info", "");
        setSharedPreferences("user_info", new Gson().toJson(bean));
    }

    /**
     * 清除用户信息
     */
    public void removeUserInfo() {
        setSharedPreferences("user_info", "");
    }

    /**
     * 获取用户是否登陆
     *
     * @return
     */
    public boolean getUserIsLogin() {

        LoginEntity.DataBean bean = getUserInfo();
        if (bean != null) {

            return true;
        } else {
            return false;
        }
    }


    public boolean isMobileNO(String mobiles) {

        return match(PHONE_PATTERN, mobiles);
    }

    /**
     * 136.     * 匹配函数
     * 137.     * @param regex
     * 138.     * @param input
     * 139.     * @return
     * 140.
     */
    private static boolean match(String regex, String input) {
        return Pattern.matches(regex, input);
    }

    /**
     * 11.     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173
     * 12.     *
     **/
    private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|7[37]|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /**
     * 16.     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1707,1708,1709
     * 17.     *
     **/
    private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^170[7-9]\\d{7}$)";

    /**
     * 21.     * 中国移动号码格式验证
     * 22.     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
     * 23.     * ,187,188,147,178,1705
     * 24.     *
     * 25.
     **/
    private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /**
     * 29.     * 仅手机号格式校验
     * 30.
     */
    private static final String PHONE_PATTERN = new StringBuilder(300).append(CHINA_MOBILE_PATTERN)
            .append("|")
            .append(CHINA_TELECOM_PATTERN)
            .append("|")
            .append(CHINA_UNICOM_PATTERN)
            .toString();

}
