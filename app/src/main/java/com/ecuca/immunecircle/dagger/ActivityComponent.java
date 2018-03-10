package com.ecuca.immunecircle.dagger;


import com.ecuca.immunecircle.ui.about.AboutActivity;
import com.ecuca.immunecircle.ui.feedback.FeedbackActivity;
import com.ecuca.immunecircle.ui.forget.ForgetPasswordActivity;
import com.ecuca.immunecircle.ui.login.LoginActivity;
import com.ecuca.immunecircle.ui.main.MainActivity;
import com.ecuca.immunecircle.ui.main.fragment.address.AddressListFragment;
import com.ecuca.immunecircle.ui.main.fragment.hot.HotListFragment;
import com.ecuca.immunecircle.ui.main.fragment.message.MessageFragment;
import com.ecuca.immunecircle.ui.main.fragment.my.MyFragment;
import com.ecuca.immunecircle.ui.main.fragment.post.PostFragment;
import com.ecuca.immunecircle.ui.register.RegisterActivity;
import com.ecuca.immunecircle.ui.register.end.RegistEndActivity;
import com.ecuca.immunecircle.ui.register.input.RegistInputCodeActivity;
import com.ecuca.immunecircle.ui.setting.SettingActivity;
import com.ecuca.immunecircle.ui.splash.SplashAct;
import com.ecuca.immunecircle.ui.user.UserProtocolAct;
import com.ecuca.immunecircle.ui.userinfo.UserInfoActivity;
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

    //注册-输入验证码页面
    void inJect(RegistInputCodeActivity act);

    //注册完成页面
    void inJect(RegistEndActivity act);

    //热榜页面
    void inJect(HotListFragment act);

    //通讯录页面
    void inJect(AddressListFragment act);

    //发帖页面
    void inJect(PostFragment act);

    //我的页面
    void inJect(MyFragment act);

    //消息页面
    void inJect(MessageFragment act);

    //意见反馈页面
    void inJect(FeedbackActivity act);

    //关于我们页面
    void inJect(AboutActivity act);

    //设置页面
    void inJect(SettingActivity act);

    //用户信息页面
    void inJect(UserInfoActivity act);
}
