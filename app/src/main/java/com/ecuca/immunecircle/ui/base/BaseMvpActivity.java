package com.ecuca.immunecircle.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecuca.immunecircle.R;
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

    /**
     * 返回该类的对象
     */
    protected Activity getActivity() {
        return this;
    }

    protected void ToastMessage(String Message) {

        Toast.makeText(getActivity(), Message, Toast.LENGTH_SHORT).show();
    }

    protected void ToastMessageLong(String Message) {

        Toast.makeText(getActivity(), Message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 返回上一个界面
     */
    protected void goBack() {
        this.finish();
    }

    /**
     * 获取组建的实例
     */
    protected <T extends View> T getID(int id) {
        return (T) findViewById(id);
    }

    /**
     * 设置程序标题
     */
    protected void setTitleText(String title) {
        TextView mTvTitle = getID(R.id.app_title);
        mTvTitle.setText(title);
    }


    /**
     * 设置title的中间View
     *
     * @param v
     * @return
     */

    protected View setTitleCenter(View v) {
        LinearLayout mCenterLin = getID(R.id.lin_title_center);
        mCenterLin.removeAllViews();
        mCenterLin.addView(v);
        return mCenterLin;
    }

    /**
     * 返回上级界面
     */
    protected void showTitleBack() {
        LinearLayout mLinBack = getID(R.id.lin_title_lelft);
        ImageView mImgBack = getID(R.id.img_title_left);
        mImgBack.setVisibility(View.VISIBLE);
        mLinBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    /**
     * 返回上级界面
     */
    protected void showTitleBack(View.OnClickListener onClickListener) {
        LinearLayout mLinBack = getID(R.id.lin_title_lelft);
        ImageView mImgBack = getID(R.id.img_title_left);
        mImgBack.setImageResource(R.mipmap.icon_title_back);
        mLinBack.setOnClickListener(onClickListener);
    }


    /**
     * 标题右边图片
     */
    protected void setTitleRightImg(int id, View.OnClickListener listener) {
        LinearLayout mLinRight = getID(R.id.lin_title_right);
        ImageView mImgRight = getID(R.id.img_title_right);
        mImgRight.setImageResource(id);
        mLinRight.setOnClickListener(listener);

    }

    /**
     * 设置Title右边的文字 图片 点击事件
     *
     * @param str
     * @param image_id
     * @param listener
     */
    protected void setTitleRightText(String str, int image_id,
                                     View.OnClickListener listener) {
        LinearLayout mLinRight = getID(R.id.lin_title_right);
        TextView mTvRight = getID(R.id.app_title_right);
        ImageView mIvRight = getID(R.id.img_title_right);
        mIvRight.setVisibility(View.VISIBLE);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);
        mIvRight.setBackgroundResource(image_id);
        mLinRight.setOnClickListener(listener);

    }

    /**
     * 设置标题右边文字
     */
    protected void setTitleRightText(String str, View.OnClickListener listener) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);
        mTvRight.setOnClickListener(listener);

    }

    /**
     * 设置标题右边文字
     *
     * @param str
     */
    public void setTitleRightTextName(String str) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);

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
