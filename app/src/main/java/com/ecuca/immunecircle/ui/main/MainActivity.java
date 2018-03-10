package com.ecuca.immunecircle.ui.main;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.adapter.FragmentTabAdapter;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;
import com.ecuca.immunecircle.ui.main.fragment.address.AddressListFragment;
import com.ecuca.immunecircle.ui.main.fragment.hot.HotListFragment;
import com.ecuca.immunecircle.ui.main.fragment.message.MessageFragment;
import com.ecuca.immunecircle.ui.main.fragment.my.MyFragment;
import com.ecuca.immunecircle.ui.main.fragment.post.PostFragment;
import com.ecuca.immunecircle.ui.view.MyRadioButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 主页
 */
public class MainActivity extends BaseMvpActivity implements MainView {
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.main_hot)
    MyRadioButton mainHot;
    @BindView(R.id.main_address)
    MyRadioButton mainAddress;
    @BindView(R.id.main_post)
    MyRadioButton mainPost;
    @BindView(R.id.main_message)
    MyRadioButton mainMessage;
    @BindView(R.id.main_my)
    MyRadioButton mainMy;
    @BindView(R.id.main_bottom_tabs)
    RadioGroup mainBottomTabs;
    private List<Fragment> fragments;
    FragmentTabAdapter tabAdapter;
    @Inject
    MainPresenter presenter;

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
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragments = new ArrayList<>();
        fragments.add(new HotListFragment());
        fragments.add(new AddressListFragment());
        fragments.add(new PostFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MyFragment());

        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.main_content, mainBottomTabs);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener() {
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {

            }
        });
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {

    }
}
