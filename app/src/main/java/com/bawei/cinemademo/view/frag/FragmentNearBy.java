package com.bawei.cinemademo.view.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.HomeAdapter;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.bean.Cinemas;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.NearPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * @describe(描述)：com.bawei.cinemademo.view.frag
 * @data（日期）: 19:2019/11/11
 * @time（时间）: 19:06
 * @author（作者）: 盖磊
 **/
public class FragmentNearBy extends BaseFragment implements XRecyclerView.LoadingListener {
    @BindView(R.id.near_mXRectcler)
    XRecyclerView mXRectcler;
    private HomeAdapter homeAdapter;
    private NearPresenter nearPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_near;
    }

    @Override
    protected void initView() {
        nearPresenter = new NearPresenter(new NearBack());
        nearPresenter.getRequestData();

        mXRectcler.setLayoutManager(new LinearLayoutManager(getContext()));
        homeAdapter = new HomeAdapter();
        mXRectcler.setAdapter(homeAdapter);
        mXRectcler.setLoadingListener(this);
    }

    @Override
    public void onRefresh() {
        homeAdapter.clear();
        homeAdapter.notifyDataSetChanged();
        nearPresenter.setPage(true);
        nearPresenter.getRequestData();
    }

    @Override
    public void onLoadMore() {
        nearPresenter.setPage(false);
        nearPresenter.getRequestData();
    }

    class NearBack implements CallBackT<Data<List<Cinemas>>>{
        @Override
        public void onSuccess(Data<List<Cinemas>> data) {
            mXRectcler.refreshComplete();
            mXRectcler.loadMoreComplete();
            homeAdapter.addAll(data.result);
            homeAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }
}
