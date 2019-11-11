package com.bawei.cinemademo.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;
import com.bawei.cinemademo.view.frag.MainFragment;
import com.bawei.cinemademo.view.frag.ShowMovieFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.show_myViewPager)
    ViewPager mViewPager;
    @BindView(R.id.show_checkGroup)
    RadioGroup mCheckGroup;
    private List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        list.add(new ShowMovieFragment());
        list.add(new MainFragment(R.layout.main_frag_kan));
        list.add(new MainFragment(R.layout.main_frag_jing));

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mCheckGroup.check(mCheckGroup.getChildAt(0).getId());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mCheckGroup.check(mCheckGroup.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mCheckGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.show_checkBtn_movie:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.show_checkBtn_cimene:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.show_checkBtn_my:
                mViewPager.setCurrentItem(2);
                break;
        }
    }
}
