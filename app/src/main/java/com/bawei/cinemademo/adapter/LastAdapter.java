package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.HotMovie;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe(描述)：com.bawei.goshopdemo.model.adapter
 * @data（日期）: 14:2019/10/17
 * @time（时间）: 14:13
 * @author（作者）: 盖磊
 **/
public class LastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE =0;
    public static final int TYPE_TWO =1;

    List<HotMovie> list = new ArrayList<>();

    public void addAll(List<HotMovie> data){
        this.list = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_last_re_item, viewGroup,false);
            return new LastOneViewHolder(view);
        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_last_two_item, viewGroup,false);
            return new LastTwoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int i) {
        HotMovie movie = list.get(i);
        if (holder instanceof LastOneViewHolder){
            FrescoUtils.getInstance().showUrlBlur(((LastOneViewHolder) holder).image,movie.horizontalImage,1,1);
            ((LastOneViewHolder) holder).name.setText(movie.name);
            ((LastOneViewHolder) holder).score.setText(movie.score+"分");
        }else if (holder instanceof LastTwoViewHolder){
            FrescoUtils.getInstance().showUrlBlur(((LastTwoViewHolder) holder).image,movie.imageUrl,1,1);
            ((LastTwoViewHolder) holder).name.setText(movie.name);
            ((LastTwoViewHolder) holder).score.setText(movie.score+"分");
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LastOneViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView name, score;
        Button buy;
        public LastOneViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_release_image);
            name = itemView.findViewById(R.id.movie_release_name);
            score = itemView.findViewById(R.id.movie_release_score);
            buy = itemView.findViewById(R.id.movie_release_btn);
        }
    }

    class LastTwoViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView name, score;
        Button buy;
        public LastTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_release_two_image);
            name = itemView.findViewById(R.id.movie_release_two_name);
            score = itemView.findViewById(R.id.movie_release_two_score);
            buy = itemView.findViewById(R.id.movie_release_two_btn);
        }
    }

}


