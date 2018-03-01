package com.ecuca.immunecircle.HttpUtils;

import com.ecuca.immunecircle.utils.LogPrint;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;


/**
 * OkHttp 自定义回调
 * Created by Theron on 2017/4/11.
 */
public abstract class AllCallback<T> extends Callback<T> {
    String tag = AllCallback.class.getSimpleName();
    Class c;

    public AllCallback(Class c) {
        this.c = c;
    }

    @Override
    public T parseNetworkResponse(Response response) {
        try {
            String content = response.body().string();
            LogPrint.d(content);
            return (T) new Gson().fromJson(content, c);
        } catch (Exception e) {
            LogPrint.d(e.getMessage());
            return null;
        }

    }
}
