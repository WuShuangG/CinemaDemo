package com.bawei.cinemademo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;
import com.bawei.cinemademo.bean.Data;
import com.bawei.cinemademo.bean.Detail;
import com.bawei.cinemademo.model.CallBackT;
import com.bawei.cinemademo.presenter.DetailPresenter;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.bawei.cinemademo.view.frag.FragmentMovies;
import com.bawei.cinemademo.view.frag.MainFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoiveDetailActivity extends BaseActivity {


    @BindView(R.id.detail_image)
    SimpleDraweeView detailImage;
    @BindView(R.id.detail_score)
    TextView detailScore;
    @BindView(R.id.detail_commentNum)
    TextView detailCommentNum;
    @BindView(R.id.detail_name)
    TextView detailName;
    @BindView(R.id.detail_typeAndtimes)
    TextView detailTypeAndtimes;
    @BindView(R.id.detail_releaseTime)
    TextView detailReleaseTime;
    @BindView(R.id.detail_mTablayout)
    TabLayout mTablayout;
    @BindView(R.id.detail_mViewPage)
    ViewPager mViewPage;
    private DetailPresenter detailPresenter;
    private List<String> title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_moive_detail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        detailPresenter = new DetailPresenter(new DetailBack());
        detailPresenter.getRequestData(movieId);

        title = new ArrayList<>();
        title.add("介绍");
        title.add("预告");
        title.add("剧照");
        title.add("影评");

        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTablayout.addTab(mTablayout.newTab().setText(title.get(0)));
        mTablayout.addTab(mTablayout.newTab().setText(title.get(1)));
        mTablayout.addTab(mTablayout.newTab().setText(title.get(2)));
        mTablayout.addTab(mTablayout.newTab().setText(title.get(3)));


    }

    @OnClick({R.id.detail_back, R.id.detail_btn_comment, R.id.detail_btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.detail_back:
                finish();
                break;
            case R.id.detail_btn_comment:
                break;
            case R.id.detail_btn_buy:
                break;
        }
    }

    class DetailBack implements CallBackT<Data<Detail>> {
        @Override
        public void onSuccess(Data<Detail> data) {
            FrescoUtils.getInstance().showUrlBlur(detailImage, data.result.imageUrl, 1, 1);
            detailCommentNum.setText("评论   " + data.result.commentNum + "万条");
            detailScore.setText("评分   " + data.result.score + "分");
            detailName.setText(data.result.name);
            detailTypeAndtimes.setText(data.result.movieType + "   " + data.result.duration);
            Date date = new Date(data.result.releaseTime);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd   中国大陆上映");
            detailReleaseTime.setText(dateFormat.format(date));

        }

        @Override
        public void onError(Data data) {

        }
    }
}
