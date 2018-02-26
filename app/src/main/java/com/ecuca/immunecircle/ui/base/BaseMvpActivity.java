package com.ecuca.immunecircle.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ecuca.immunecircle.utils.ActivitySwitcher;

import butterknife.ButterKnife;


/**
 * MvpActivity基类
 *
 * @param <V>
 * @param <T>
 */
public abstract class BaseMvpActivity<V extends BaseActView, T extends BaseActPresenter<V>> extends Activity implements BaseActView {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySwitcher.addActivity(this);
        initConfig();
        inJect();
        presenter = initPresenter();
        presenter.attachView(this);
        setContentView(initRootView());
        ButterKnife.bind(this);
        initView();
        bindingEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attach((V) this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        release();
    }

    @Override
    protected void onDestroy() {
        ActivitySwitcher.removeActivity(this);
        if (presenter != null) {
            presenter.dettach();
        }
        super.onDestroy();
    }

    /**
     * 配置窗体
     */
    private void initConfig() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    //注册该界面，每个界面都要实现
    public abstract void inJect();

    //初始化协调者
    public abstract T initPresenter();

    //初始化布局文件id
    public abstract int initRootView();

    //初始化View
    public abstract void initView();

    //绑定事件
    public abstract void bindingEvent();

    //释放资源
    public abstract void release();


}
