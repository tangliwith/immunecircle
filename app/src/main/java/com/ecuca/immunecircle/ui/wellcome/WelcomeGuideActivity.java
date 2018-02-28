package com.ecuca.immunecircle.ui.wellcome;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ecuca.immunecircle.R;
import com.ecuca.immunecircle.app.MyApplication;
import com.ecuca.immunecircle.ui.adapter.GuideViewPagerAdapter;
import com.ecuca.immunecircle.ui.base.BaseActPresenter;
import com.ecuca.immunecircle.ui.base.BaseMvpActivity;
import com.ecuca.immunecircle.ui.login.LoginActivity;
import com.ecuca.immunecircle.utils.ActivitySwitcher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 引导页
 */
public class WelcomeGuideActivity extends BaseMvpActivity implements WellcomeGuideView, View.OnClickListener {
    @Inject
    WellcomeGuidePresenter presenter;
    @BindView(R.id.vp_guide)
    ViewPager vpGuide;
    private GuideViewPagerAdapter adapter;
    private List<View> views;
    // 引导页图片资源
    private static final int[] pics = {R.layout.guide_view1,
            R.layout.guide_view2};

    // 底部小点图片
    private ImageView[] dots;

    // 记录当前选中位置
    private int currentIndex;
    private Button startBtn;

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
        return R.layout.activity_welcome_guide;
    }

    @Override
    public void initView() {
        views = new ArrayList<View>();
        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            if (i == pics.length - 1) {
                startBtn = view.findViewById(R.id.start_btn);
                startBtn.setTag("enter");
                startBtn.setOnClickListener(this);
            }
            views.add(view);
        }

        adapter = new GuideViewPagerAdapter(views);
        vpGuide.setAdapter(adapter);
        vpGuide.addOnPageChangeListener(new PageChangeListener());
    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vpGuide.setCurrentItem(position);
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            ActivitySwitcher.start(this, LoginActivity.class);
        } else {
            int position = (Integer) v.getTag();
            setCurView(position);
        }
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int position) {
        }

        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
        }
    }

    @Override
    public void bindingEvent() {

    }

    @Override
    public void release() {
        MyApplication.app.setSharedPreferences("is_first", "yyyy");
    }


}
