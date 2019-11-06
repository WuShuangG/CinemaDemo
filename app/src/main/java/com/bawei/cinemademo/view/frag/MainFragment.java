package com.bawei.cinemademo.view.frag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：com.bawei.cinemademo.view.frag
 * @data（日期）: 19:2019/11/5
 * @time（时间）: 19:19
 * @author（作者）: 盖磊
 **/
@SuppressLint("ValidFragment")
public class MainFragment extends BaseFragment {
    int layoutId;
    private SharedPreferences sp;

    public MainFragment(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected int getLayoutId() {
        return layoutId;
    }

    @Override
    protected void initView() {
        if (layoutId == R.layout.main_frag_ti) {
            View view = getActivity().findViewById(R.id.main_onAction);
            sp = getActivity().getSharedPreferences("mySP", Context.MODE_PRIVATE);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("frist",true);
                    edit.commit();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();
                }
            });
        }
    }
}
