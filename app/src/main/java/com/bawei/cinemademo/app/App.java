package com.bawei.cinemademo.app;

import android.app.Application;
import android.content.Context;

/**
 *@describe(描述)：App
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:04
 *@author（作者）: 盖磊
 **/
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
