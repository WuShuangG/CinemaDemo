package com.bawei.cinemademo.view.frag;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.AddressAdapter;
import com.bawei.cinemademo.adapter.CinemaAdapter;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.bean.Address;
import com.bawei.cinemademo.bean.CinemaName;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.AddressPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @describe(描述)：com.bawei.gailei20191105.view.frag
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:26
 * @author（作者）: 盖磊
 **/
public class FragmentMy extends BaseFragment {
    @BindView(R.id.my_RectCler_dress)
    RecyclerView myRectClerDress;
    @BindView(R.id.my_RectCler_name)
    RecyclerView myRectClerName;
    private List<Address> addList;
    private AddressAdapter addressAdapter;
    private CinemaAdapter cinemaAdapter;
    private AddressPresenter addressPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_my;
    }

    @Override
    protected void initView() {
        addList = new ArrayList<>();
        addList.add(new Address("海淀区",1));
        addList.add(new Address("朝阳区",2));
        addList.add(new Address("东城区",3));
        addList.add(new Address("西城区",4));

        addressPresenter = new AddressPresenter(new AddressList());

        myRectClerName.setVisibility(View.GONE);
        myRectClerDress.setLayoutManager(new LinearLayoutManager(getContext()));
        addressAdapter = new AddressAdapter();
        myRectClerDress.setAdapter(addressAdapter);
        addressAdapter.addAll(addList);
        addressAdapter.notifyDataSetChanged();
        addressAdapter.setOnClickItemListener(new AddressAdapter.OnClickItemListener() {
            @Override
            public void onClick(View view, int position) {
                myRectClerName.setVisibility(View.VISIBLE);
                addressPresenter.getRequestData(addList.get(position).addressId);
            }
        });

        myRectClerName.setLayoutManager(new LinearLayoutManager(getContext()));
        cinemaAdapter = new CinemaAdapter();
        myRectClerName.setAdapter(cinemaAdapter);

    }

    class AddressList implements CallBackT<Data<List<CinemaName>>> {
        @Override
        public void onSuccess(Data<List<CinemaName>> data) {
            cinemaAdapter.addAll(data.result);
            cinemaAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }
}
