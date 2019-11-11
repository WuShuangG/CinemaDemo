package com.bawei.cinemademo.presenter;

import com.bawei.cinemademo.base.BasePresenter;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.model.IRequest;

import io.reactivex.Observable;

/**
 * @describe(描述)：com.bawei.cinemademo.presenter
 * @data（日期）: 19:2019/11/6
 * @time（时间）: 19:00
 * @author（作者）: 盖磊
 **/
public class HotMoviePresenter extends BasePresenter {
    public HotMoviePresenter(CallBackT callBackT) {
        super(callBackT);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findHotMovieList((int)args[0],(int)args[1]);
    }
}
