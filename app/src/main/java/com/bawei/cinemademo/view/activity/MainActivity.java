package com.bawei.cinemademo.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;
import com.bawei.cinemademo.view.frag.MainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/11/5
 * @time（时间）: 17:04
 * @author（作者）: 盖磊
 **/
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.main_viewPager)
    ViewPager mainViewPager;
    @BindView(R.id.main_group)
    RadioGroup mainGroup;
    private List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        list.add(new MainFragment(R.layout.main_frag_di));
        list.add(new MainFragment(R.layout.main_frag_kan));
        list.add(new MainFragment(R.layout.main_frag_jing));
        list.add(new MainFragment(R.layout.main_frag_ba));
        list.add(new MainFragment(R.layout.main_frag_ti));

        mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mainGroup.check(mainGroup.getChildAt(0).getId());
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i!=list.size()-1) {
                    mainGroup.check(mainGroup.getChildAt(i).getId());
                }else {
                    mainGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mainGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radioBtn_one:
                mainViewPager.setCurrentItem(0);
                break;
            case R.id.radioBtn_two:
                mainViewPager.setCurrentItem(1);
                break;
            case R.id.radioBtn_three:
                mainViewPager.setCurrentItem(2);
                break;
            case R.id.radioBtn_four:
                mainViewPager.setCurrentItem(3);
                break;
        }
    }
}
