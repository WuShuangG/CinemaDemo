package com.bawei.cinemademo.bean;

/**
 *@describe(描述)：Data
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:09
 *@author（作者）: 盖磊
 **/
public class Data<T> {

    public T result;
    public String message;
    public String status = "0000";

    public Data(){}

    public Data(String message) {
        this.message = message;
    }

    public Data(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
