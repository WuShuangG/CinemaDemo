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
public class NearPresenter extends BasePresenter {
    private int page = 1;
    public NearPresenter(CallBackT callBackT) {
        super(callBackT);
    }

    public void setPage(boolean b){
        if (b==true){
            page=1;
        }else {
            page++;
        }
    };

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findNearbyCinemas(page,10);
    }
}
