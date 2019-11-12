package com.bawei.cinemademo.presenter;

import com.bawei.cinemademo.base.BasePresenter;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.model.IRequest;

import io.reactivex.Observable;

/**
 * @describe(描述)：com.bawei.gailei20191105.presenter
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:37
 * @author（作者）: 盖磊
 **/
public class AddressPresenter extends BasePresenter {
    public AddressPresenter(CallBackT callBackT) {
        super(callBackT);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findCinemaByRegion((int)args[0]);
    }
}
