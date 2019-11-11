package com.bawei.cinemademo.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

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

        // 高级初始化：
        File file = new File(Environment.getExternalStorageDirectory()
                + File.separator+"frescocache");
        Fresco.initialize(this, ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(this)
                                .setBaseDirectoryPath(file) // 注意Android运行时权限。
                                .build()
                )
                .build()
        );
    }
}
