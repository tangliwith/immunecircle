package com.ecuca.immunecircle.ui.userinfo;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends BaseMvpActivity implements UserInfoView {

    @Inject
    UserInfoPresenter presenter;
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
    @BindView(R.id.img_head)
    CircleImageView imgHead;
    @BindView(R.id.rel_choose_head)
    RelativeLayout relChooseHead;
    @BindView(R.id.et_nick_name)
    EditText etNickName;
    @BindView(R.id.rb_sex_man)
    RadioButton rbSexMan;
    @BindView(R.id.rb_sex_woman)
    RadioButton rbSexWoman;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.rel_choose_birthday)
    RelativeLayout relChooseBirthday;
    @BindView(R.id.tv_address_111)
    TextView tvAddress111;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rel_choose_address)
    RelativeLayout relChooseAddress;
    @BindView(R.id.et_address_details)
    EditText etAddressDetails;
    @BindView(R.id.et_real_name)
    EditText etRealName;
    @BindView(R.id.et_idcard)
    EditText etIdcard;
    @BindView(R.id.tv_idcard_111)
    TextView tvIdcard111;
    @BindView(R.id.iv_idcard)
    ImageView ivIdcard;
    @BindView(R.id.rel_idcard_photo)
    RelativeLayout relIdcardPhoto;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.rel_email)
    RelativeLayout relEmail;
    @BindView(R.id.tv_social_account)
    TextView tvSocialAccount;
    @BindView(R.id.rel_social_account)
    RelativeLayout relSocialAccount;
    @BindView(R.id.et_job)
    EditText etJob;
    @BindView(R.id.et_position)
    EditText etPosition;
    @BindView(R.id.rel_hint_to_stranger)
    RelativeLayout relHintToStranger;
    @BindView(R.id.rel_hint_to_friend)
    RelativeLayout relHintToFriend;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
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
        return R.layout.activity_user_info;
    }

    @Override
    public void initView() {
        showTitleBack();
        setTitleText("账号");
        setBottomTextName("保存");
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

    @OnClick({R.id.rel_choose_birthday, R.id.rel_choose_address, R.id.rel_idcard_photo, R.id.rel_email, R.id.rel_social_account, R.id.rel_hint_to_stranger, R.id.rel_hint_to_friend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_choose_birthday:
                break;
            case R.id.rel_choose_address:
                break;
            case R.id.rel_idcard_photo:
                break;
            case R.id.rel_email:
                break;
            case R.id.rel_social_account:
                break;
            case R.id.rel_hint_to_stranger:
                break;
            case R.id.rel_hint_to_friend:
                break;
        }
    }
}
