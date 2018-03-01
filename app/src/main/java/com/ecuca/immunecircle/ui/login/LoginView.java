package com.ecuca.immunecircle.ui.login;

/**
 * Created by tangli on 2018/2/11.
 */

public interface LoginView {
    //显示信息
    void showMsg(String msg);
    //成功后跳转
    void jumpToMain();
}
