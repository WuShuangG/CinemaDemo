package com.bawei.cinemademo.bean;


import java.util.List;

/**
 * @describe(描述)：com.bawei.cinemademo.bean
 * @data（日期）: 10:2019/11/12
 * @time（时间）: 10:38
 * @author（作者）: 盖磊
 **/
public class Detail {
    //"commentNum": 30,
    //        "duration": "148分钟",
    //        "imageUrl": "http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg",
    //        "movieActor":"movieId": 16,
    //        "movieType": "动作 / 冒险 / 惊悚",
    //        "name": "碟中谍6：全面瓦解",
    //        "placeOrigin": "美国",
    //        "posterList""releaseTime": 1600704000000,
    //        "score": 8.9,
    //        "shortFilmList":

    public int commentNum;
    public String duration;
    public String imageUrl;
    public List<Movies> movieActor;
    public List<Movies> movieDirector;
    public String movieId;
    public String movieType;
    public String name;
    public String placeOrigin;
    public List<String> posterList;
    public Long releaseTime;
    public double score;
    public List<ShortFilm> shortFilmList;
    public String summary;
    public int whetherFollow;

}
