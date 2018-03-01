package com.ecuca.immunecircle.HttpUtils;


import android.text.TextUtils;
import android.util.Log;

import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.utils.LogPrint;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by THL on 2016/7/4.
 * 网络缓存 实体类必须实现 继承 Serializable类
 */
public class HttpUtils {

    String tag = HttpUtils.class.getSimpleName();

    private final static String ANDROID_SECRET_HOST = "93815901723878268553752158041856";

    private HttpUtils() {
    }

    private static HttpUtils instance;

    public static HttpUtils getInstance() {
        if (instance == null)
            instance = new HttpUtils();
        return instance;
    }

    public String Url = "http://10051.demoby.com";

    public void post(Map<String, String> params, final String act, AllCallback a) {

        if (params == null) {
            params = new HashMap<>();
        }
        String tokenStr = "";
        if (MyApplication.app.getUserIsLogin()) {
            if (MyApplication.app.getUserInfo() != null) {
                long timestamp = System.currentTimeMillis() / 1000;
                tokenStr = "?token=" + MyApplication.app.getUserInfo().getToken() + "&sign="
                        + getSign(MyApplication.app.getUserInfo().getToken(), String.valueOf(timestamp)) + "&timestamp=" + timestamp;
            }

        }
        LogPrint.d("Url:" + Url + "" + act + "/");
        LogPrint.d("params:" + params.toString());
        LogPrint.d("tokenStr:" + tokenStr);

        OkHttpUtils.post().url(Url + "/api/" + act + "/" + tokenStr).params(params).build().execute(a);
    }

    /**
     * 上传文件和数据
     *
     * @param params
     * @param
     * @param act
     * @param a
     */
    public void postFile(Map<String, String> params, HashMap<String, File> fileParams, final String act, AllCallback a) {

        if (params == null) {
            params = new HashMap<>();
        }

        String tokenStr = "";
        if (MyApplication.app.getUserIsLogin()) {
            if (MyApplication.app.getUserInfo() != null) {
                long timestamp = System.currentTimeMillis() / 1000;
                tokenStr = "?token=" + MyApplication.app.getUserInfo().getToken() + "&sign="
                        + getSign(MyApplication.app.getUserInfo().getToken(), String.valueOf(timestamp)) + "&timestamp=" + timestamp;
            }

        }
        LogPrint.d("Url:" + Url + "" + act + "/");
        LogPrint.d("params:" + params.toString());
        LogPrint.d("tokenStr:" + tokenStr);

        PostFormBuilder builder = OkHttpUtils.post();

        if (fileParams != null) {


            Iterator iter = fileParams.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, File> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                File val = entry.getValue();
                Log.e("Test", "file_name:" + key);
                builder.addFile(key, val.getName(), val);
            }
        }

        builder.url(Url + "/api/" + act + "/" + tokenStr).params(params).build().execute(a);


    }

    public void get(Map<String, String> params, final String act, AllCallback t) {
        if (params == null) {
            params = new HashMap<>();
        }
        String tokenStr = "";
        if (MyApplication.app.getUserIsLogin()) {
            if (MyApplication.app.getUserInfo() != null) {
                long timestamp = System.currentTimeMillis() / 1000;
                tokenStr = "?token=" + MyApplication.app.getUserInfo().getToken() + "&sign="
                        + getSign(MyApplication.app.getUserInfo().getToken(), String.valueOf(timestamp)) + "&timestamp=" + timestamp;
            }

        }
        LogPrint.d("Url:" + Url + "" + act + "/");
        LogPrint.d("params:" + params.toString());
        LogPrint.d("tokenStr:" + tokenStr);

        OkHttpUtils.get().url(Url + "/api/" + act + "/").params(params).build().execute(t);
    }


    public String getSign(String token, String time) {

        return EncoderByMd5(token + ANDROID_SECRET_HOST + time);
    }

    /**
     * md5 加密
     *
     * @param string
     * @return
     */
    public String EncoderByMd5(String string) {
        //确定计算方法
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


}
