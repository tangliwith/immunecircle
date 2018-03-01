package com.ecuca.immunecircle.ui.login;

import com.ecuca.immunecircle.HttpUtils.AllCallback;
import com.ecuca.immunecircle.HttpUtils.HttpUtils;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.entity.LoginEntity;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseActView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.Call;

/**
 * Created by tangli on 2018/2/11.
 */

public class LoginPresenter extends BaseActPresenter {
    //view
    LoginView v;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void attachView(BaseActView actView) {
        this.v = (LoginView) actView;
    }

    public void doLogin(String phone, String pwd) {
        Map<String, String> m = new HashMap<>();
        m.put("mobile", phone);
        m.put("password", pwd);
        HttpUtils.getInstance().post(m, "/api/user/login/", new AllCallback<LoginEntity>(LoginEntity.class) {
            @Override
            public void onError(Call call, Exception e) {
                v.showMsg("网络异常");
            }
            @Override
            public void onResponse(LoginEntity response) {
                if (response != null) {
                    if (response.getCode() == 200) {
                        MyApplication.app.saveUserInfo(response.getData());
                        v.showMsg(response.getMsg());
                        v.jumpToMain();
                    } else {
                        v.showMsg(response.getMsg());
                    }
                } else {
                    v.showMsg("服务器异常");
                }
            }
        });
    }
}
