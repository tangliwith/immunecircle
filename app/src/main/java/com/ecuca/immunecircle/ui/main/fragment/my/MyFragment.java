package com.ecuca.immunecircle.ui.main.fragment.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.about.AboutActivity;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpFragment;
import com.ecuca.immunecircle.ui.feedback.FeedbackActivity;
import com.ecuca.immunecircle.ui.setting.SettingActivity;
import com.ecuca.immunecircle.ui.userinfo.UserInfoActivity;
import com.ecuca.immunecircle.utils.ActivitySwitcher;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 */
public class MyFragment extends BaseMvpFragment implements MyView {
    @Inject
    MyPresenter presenter;
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
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_experience)
    TextView tvExperience;
    @BindView(R.id.tv_my_login_time)
    TextView tvMyLoginTime;
    @BindView(R.id.tv_acer)
    TextView tvAcer;
    @BindView(R.id.tv_post)
    TextView tvPost;
    @BindView(R.id.tv_essence)
    TextView tvEssence;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.rl_my_integral)
    RelativeLayout rlMyIntegral;
    @BindView(R.id.rl_my_collection)
    RelativeLayout rlMyCollection;
    @BindView(R.id.rl_menber_center)
    RelativeLayout rlMenberCenter;
    @BindView(R.id.rl_setting)
    RelativeLayout rlSetting;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.ll_userinfo)
    LinearLayout llUserinfo;

    @Override
    public void inJect() {
        MyApplication.app.createActivityComponent(getActivity());
        MyApplication.app.getActivityComponent().inJect(this);
    }

    @Override
    public BaseActPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int initRootView() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }

    @OnClick({R.id.rl_my_integral, R.id.rl_my_collection, R.id.rl_menber_center, R.id.rl_setting, R.id.rl_feedback, R.id.rl_about, R.id.ll_userinfo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_my_integral:
                break;
            case R.id.rl_my_collection:
                break;
            case R.id.rl_menber_center:
                break;
            case R.id.rl_setting:
                ActivitySwitcher.start(getActivity(), SettingActivity.class, false);
                break;
            case R.id.rl_feedback:
                ActivitySwitcher.start(getActivity(), FeedbackActivity.class, false);
                break;
            case R.id.rl_about:
                ActivitySwitcher.start(getActivity(), AboutActivity.class, false);
                break;
            case R.id.ll_userinfo:
                ActivitySwitcher.start(getActivity(), UserInfoActivity.class, false);
                break;
        }
    }
}
