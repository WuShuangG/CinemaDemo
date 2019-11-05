package com.bawei.cinemademo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *@describe(描述)：BaseFragment
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:05
 *@author（作者）: 盖磊
 **/
public abstract class BaseFragment extends Fragment {

    private View inflate;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(getLayoutId(), container, false);
        return inflate;
    }

    protected abstract int getLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
    }

    protected abstract void initView();


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
