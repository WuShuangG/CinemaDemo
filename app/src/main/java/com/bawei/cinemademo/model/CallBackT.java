package com.bawei.cinemademo.model;

import com.bawei.cinemademo.bean.Data;

/**
 *@describe(描述)：CallBackT
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:06
 *@author（作者）: 盖磊
 **/
public interface CallBackT<T> {
    void onSuccess(T t);
    void onError(Data data);
}
