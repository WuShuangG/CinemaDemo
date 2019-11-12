package com.bawei.cinemademo.base;

import android.widget.Toast;

import com.bawei.cinemademo.app.App;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.model.IRequest;
import com.bawei.cinemademo.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 *@describe(描述)：BasePresenter
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:05
 *@author（作者）: 盖磊
 **/
public abstract class BasePresenter {
    CallBackT callBackT;

    public BasePresenter(CallBackT callBackT) {
        this.callBackT = callBackT;
    }

    public void getRequestData(Object...args){
        final boolean netWork = HttpUtils.getInstance().isNetWork(App.context);
        IRequest iRequest = HttpUtils.getInstance().create(IRequest.class);
        getModel(iRequest,args).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data d) throws Exception {
                        if (callBackT != null) {
                            if (netWork){
                                if (d.status.equals("0000")){
                                    callBackT.onSuccess(d);
                                }else {
                                    callBackT.onError(d);
                                }
                            }else {
                                Toast.makeText(App.context, "无网络连接", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBackT != null) {
                            callBackT.onError(new Data(throwable.getMessage()));
                        }
                    }
                });
    }

    protected abstract Observable getModel(IRequest iRequest, Object... args);

}
