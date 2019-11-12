package com.bawei.cinemademo.model;


import com.bawei.cinemademo.bean.CinemaName;
import com.bawei.cinemademo.bean.Cinemas;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.bean.Detail;
import com.bawei.cinemademo.bean.MBanner;
import com.bawei.cinemademo.bean.HotMovie;
import com.bawei.cinemademo.bean.Soon;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *@describe(描述)：IRequest
 *@data（日期）: 2019/11/5
 *@time（时间）: 17:06
 *@author（作者）: 盖磊
 **/
public interface IRequest {
    //轮播图
    @GET("tool/v2/banner")
    Observable<Data<List<MBanner>>> banner();
    //热门电影
    @GET("movie/v2/findHotMovieList")
    Observable<Data<List<HotMovie>>> findHotMovieList(@Query("page")int page,@Query("count")int count);
    //正在热映
    @GET("movie/v2/findReleaseMovieList")
    Observable<Data<List<HotMovie>>> findReleaseMovieList(@Query("page")int page,@Query("count")int count);
    //即将上映
    @GET("movie/v2/findComingSoonMovieList")
    Observable<Data<List<Soon>>> findComingSoonMovieList(@Query("page")int page, @Query("count")int count);
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<Data<List<Cinemas>>> findRecommendCinemas(@Header("userId")String userId,
                                                         @Header("sessionId")String sessionId,
                                                         @Query("page") int page,
                                                         @Query("count") int count);

    //附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<Data<List<Cinemas>>> findNearbyCinemas(@Query("page") int page,
                                                      @Query("count") int count);

    //影院区域查询
    @GET("cinema/v2/findCinemaByRegion")
    Observable<Data<List<CinemaName>>> findCinemaByRegion(@Query("regionId") int regionId);


    //电影详情
    @GET("movie/v2/findMoviesDetail")
    Observable<Data<Detail>> findMoviesDetail(@Query("movieId") int movieId);



}
