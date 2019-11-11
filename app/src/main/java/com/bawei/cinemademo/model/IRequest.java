package com.bawei.cinemademo.model;


import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.bean.MBanner;
import com.bawei.cinemademo.bean.HotMovie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *@describe(描述)：IRequest
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:06
 *@author（作者）: 盖磊
 **/
public interface IRequest {

    @GET("tool/v2/banner")
    Observable<Data<List<MBanner>>> banner();

    @GET("movie/v2/findHotMovieList")
    Observable<Data<List<HotMovie>>> findHotMovieList(@Query("page")int page,@Query("count")int count);

    @GET("movie/v2/findReleaseMovieList")
    Observable<Data<List<HotMovie>>> findReleaseMovieList(@Query("page")int page,@Query("count")int count);


}
