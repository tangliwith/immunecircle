package com.ecuca.immunecircle.ui.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置页面
 */
public class SettingActivity extends BaseMvpActivity implements SettingView {

    @Inject
    SettingPresenter presenter;
    @BindView(R.id.img_title_left)
    ImageView imgTitleLeft;
    @BindView(R.id.lin_title_lelft)
    LinearLayout linTitleLelft;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.lin_title_center)
    LinearLayout linTitleCenter;
    @BindView(R.id.img_title_right)
    ImageView imgTitleRight;
    @BindView(R.id.app_title_right)
    TextView appTitleRight;
    @BindView(R.id.lin_title_right)
    LinearLayout linTitleRight;
    @BindView(R.id.layout_title_rel)
    LinearLayout layoutTitleRel;
    @BindView(R.id.title_bg)
    LinearLayout titleBg;
    @BindView(R.id.rel_change_pwd)
    RelativeLayout relChangePwd;
    @BindView(R.id.rel_change_pay)
    RelativeLayout relChangePay;
    @BindView(R.id.rel_change_mobile)
    RelativeLayout relChangeMobile;
    @BindView(R.id.rel_change_gesture)
    RelativeLayout relChangeGesture;
    @BindView(R.id.rel_change_add_friend)
    RelativeLayout relChangeAddFriend;
    @BindView(R.id.rel_change_msg_hint)
    RelativeLayout relChangeMsgHint;
    @BindView(R.id.rel_change_group_pass)
    RelativeLayout relChangeGroupPass;
    @BindView(R.id.app_text_bottom)
    TextView appTextBottom;

    @Override
    public void inJect() {
        MyApplication.app.createActivityComponent(this);
        MyApplication.app.getActivityComponent().inJect(this);
    }

    @Override
    public BaseActPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int initRootView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        showTitleBack();
        setBottomTextName("退出登录");
        setTitleText("意见反馈");
        setTitleRightImg(R.mipmap.ic_top_right, v -> {
            //按钮点击事件处理

        });
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }

    @OnClick({R.id.rel_change_pwd, R.id.rel_change_pay, R.id.rel_change_mobile, R.id.rel_change_gesture, R.id.rel_change_add_friend, R.id.rel_change_msg_hint, R.id.rel_change_group_pass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_change_pwd:
                break;
            case R.id.rel_change_pay:
                break;
            case R.id.rel_change_mobile:
                break;
            case R.id.rel_change_gesture:
                break;
            case R.id.rel_change_add_friend:
                break;
            case R.id.rel_change_msg_hint:
                break;
            case R.id.rel_change_group_pass:
                break;
        }
    }
}
