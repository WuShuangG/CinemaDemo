package com.bawei.cinemademo.view.frag;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.HomeAdapter;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.bean.Cinemas;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.HomePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * @describe(描述)：com.bawei.gailei20191105.view.frag
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:26
 * @author（作者）: 盖磊
 **/
public class FragmentHome extends BaseFragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.home_mXRectcler)
    XRecyclerView mXRectcler;
    private HomePresenter homePresenter;
    private HomeAdapter homeAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void initView() {
        homePresenter = new HomePresenter(new HomeList());
        homePresenter.getRequestData();

        mXRectcler.setLayoutManager(new LinearLayoutManager(getContext()));
        homeAdapter = new HomeAdapter();
        mXRectcler.setAdapter(homeAdapter);
        mXRectcler.setLoadingListener(this);
    }

    @Override
    public void onRefresh() {
        homeAdapter.clear();
        homeAdapter.notifyDataSetChanged();
        homePresenter.setPage(true);
        homePresenter.getRequestData();
    }

    @Override
    public void onLoadMore() {
        homePresenter.setPage(false);
        homePresenter.getRequestData();
    }

    class HomeList implements CallBackT<Data<List<Cinemas>>> {
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
