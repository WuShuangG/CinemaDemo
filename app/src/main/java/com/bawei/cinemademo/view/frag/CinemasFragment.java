package com.bawei.cinemademo.view.frag;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @describe(描述)：com.bawei.cinemademo.view.frag
 * @data（日期）: 18:2019/11/11
 * @time（时间）: 18:44
 * @author（作者）: 盖磊
 **/
public class CinemasFragment extends BaseFragment {

    @BindView(R.id.home_mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.home_mViewPager)
    ViewPager mViewPager;
    private List<String> title;
    private List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_cinemas;
    }

    @Override
    protected void initView() {
        title = new ArrayList<>();
        title.add("推荐影院");
        title.add("附近影院");
        title.add("海淀区 ▼");
        list = new ArrayList<>();
        list.add(new FragmentHome());
        list.add(new FragmentNearBy());
        list.add(new FragmentMy());

        mViewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(2)));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
