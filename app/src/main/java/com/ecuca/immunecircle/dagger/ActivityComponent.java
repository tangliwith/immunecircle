package com.ecuca.immunecircle.dagger;


import com.ecuca.immunecircle.ui.forget.ForgetPasswordActivity;
import com.ecuca.immunecircle.ui.login.LoginActivity;
import com.ecuca.immunecircle.ui.main.MainActivity;
import com.ecuca.immunecircle.ui.register.RegisterActivity;
import com.ecuca.immunecircle.ui.splash.SplashAct;
import com.ecuca.immunecircle.ui.user.UserProtocolAct;
import com.ecuca.immunecircle.ui.wellcome.WelcomeGuideActivity;

import dagger.Subcomponent;

/**
 * 注册。
 * Created by ChenxiHu on 2016/12/15.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    //在这里提供注册方法
    //首页
    void inJect(MainActivity act);

    //加载界面
    void inJect(SplashAct act);

    //注册界面
    void inJect(RegisterActivity act);

    //登录界面
    void inJect(LoginActivity act);

    //忘记密码页面
    void inJect(ForgetPasswordActivity act);

    //用户协议页面
    void inJect(UserProtocolAct act);

    //引导页面
    void inJect(WelcomeGuideActivity act);
}
