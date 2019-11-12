package com.bawei.cinemademo.view.frag;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.adapter.CenterAdapter;
import com.bawei.cinemademo.adapter.LastAdapter;
import com.bawei.cinemademo.adapter.TopAdapter;
import com.bawei.cinemademo.base.BaseFragment;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.bean.HotMovie;
import com.bawei.cinemademo.bean.MBanner;
import com.bawei.cinemademo.bean.Soon;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.HotMoviePresenter;
import com.bawei.cinemademo.presenter.MbannerPresenter;
import com.bawei.cinemademo.presenter.ReleMoviePresenter;
import com.bawei.cinemademo.presenter.SoonMoviePresenter;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.bawei.cinemademo.view.activity.MoiveDetailActivity;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @describe(描述)：com.bawei.cinemademo.view.frag
 * @data（日期）: 19:2019/11/5
 * @time（时间）: 19:19
 * @author（作者）: 盖磊
 **/
public class ShowMovieFragment extends BaseFragment {


    @BindView(R.id.moview_xbanner)
    XBanner moviewXbanner;
    @BindView(R.id.movie_banner_select)
    TextView movieBannerSelect;
    @BindView(R.id.movie_banner_size)
    TextView movieBannerSize;
    @BindView(R.id.movie_list_top)
    RecyclerView movieListTop;
    @BindView(R.id.movie_list_center)
    RecyclerView movieListCenter;
    @BindView(R.id.movie_list_last)
    RecyclerView movieListLast;
    private MbannerPresenter mbannerPresenter;
    private ReleMoviePresenter releMoviePresenter;
    private TopAdapter topAdapter;
    private HotMoviePresenter hotMoviePresenter;
    private LastAdapter lastAdapter;
    private SoonMoviePresenter soonMoviePresenter;
    private CenterAdapter centerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.show_frag_movie;
    }

    @Override
    protected void initView() {
        mbannerPresenter = new MbannerPresenter(new BannerList());
        mbannerPresenter.getRequestData();
        //上列表
        releMoviePresenter = new ReleMoviePresenter(new HotList());
        releMoviePresenter.getRequestData(1,10);
        movieListTop.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        topAdapter = new TopAdapter();
        movieListTop.setAdapter(topAdapter);
        topAdapter.setOnClickTopItemListener(new TopAdapter.OnClickTopItemListener() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getContext(), MoiveDetailActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });

        //中列表
        soonMoviePresenter = new SoonMoviePresenter(new SoonList());
        soonMoviePresenter.getRequestData(1,4);
        movieListCenter.setLayoutManager(new LinearLayoutManager(getContext()));
        centerAdapter = new CenterAdapter();
        movieListCenter.setAdapter(centerAdapter);

        //下列表
        hotMoviePresenter = new HotMoviePresenter(new ReleList());
        hotMoviePresenter.getRequestData(1,4);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = movieListLast.getAdapter().getItemViewType(position);
                if(type == lastAdapter.TYPE_ONE){
                    return gridLayoutManager.getSpanCount();
                }else{
                    return 1;
                }
            }
        });
        movieListLast.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                //super.getItemOffsets(outRect, view, parent, state);
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();

                int spansize = layoutParams.getSpanSize();
                int spanindex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if(spansize != gridLayoutManager.getSpanCount()){
                    if(spanindex == 1){
                        outRect.left = 10;
                    }else{
                        outRect.right = 10;
                    }
                }
            }
        });
        movieListLast.setLayoutManager(gridLayoutManager);
        lastAdapter = new LastAdapter();
        movieListLast.setAdapter(lastAdapter);

    }

    class SoonList implements CallBackT<Data<List<Soon>>>{

        @Override
        public void onSuccess(Data<List<Soon>> listData) {
            centerAdapter.addAll(listData.result);
            centerAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }

    class ReleList implements CallBackT<Data<List<HotMovie>>>{
        @Override
        public void onSuccess(Data<List<HotMovie>> listData) {
            lastAdapter.addAll(listData.result);
            lastAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }

    class HotList implements CallBackT<Data<List<HotMovie>>>{
        @Override
        public void onSuccess(Data<List<HotMovie>> listData) {
            topAdapter.addAll(listData.result);
            topAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Data data) {

        }
    }

    class BannerList implements CallBackT<Data<List<MBanner>>>{

        @Override
        public void onSuccess(final Data<List<MBanner>> listData) {

            moviewXbanner.setPointsIsVisible(false);
            movieBannerSize.setText("/"+listData.result.size());
            moviewXbanner.setData(listData.result, null);
            moviewXbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    movieBannerSelect.setText(""+listData.result.get(position).rank);
                    Glide.with(getContext()).load(listData.result.get(position).imageUrl).into((ImageView) view);
                }
            });
            moviewXbanner.setPageTransformer(Transformer.Cube);
            moviewXbanner.setPageChangeDuration(1000);
            moviewXbanner.startAutoPlay();
        }

        @Override
        public void onError(Data data) {

        }
    }
}
