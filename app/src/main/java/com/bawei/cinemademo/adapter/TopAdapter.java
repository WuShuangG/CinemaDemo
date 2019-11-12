package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.HotMovie;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe(描述)：com.bawei.goshopdemo.model.adapter
 * @data（日期）: 14:2019/10/17
 * @time（时间）: 14:13
 * @author（作者）: 盖磊
 **/
public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopViewHolder> {

    List<HotMovie> list = new ArrayList<>();

    public void addAll(List<HotMovie> data){
        this.list = data;
    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_top_hot_item, viewGroup,false);
        return new TopViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, final int i) {
        final HotMovie movie = list.get(i);
        FrescoUtils.getInstance().showUrlBlur(holder.image,movie.imageUrl,1,1);
        holder.name.setText(movie.name);
        holder.score.setText(movie.score+"分");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTopItemListener.onClick(movie.movieId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TopViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView name, score;
        Button buy;
        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_hot_image);
            name = itemView.findViewById(R.id.movie_hot_name);
            score = itemView.findViewById(R.id.movie_hot_score);
            buy = itemView.findViewById(R.id.movie_hot_btn);
        }
    }

    private OnClickTopItemListener onClickTopItemListener;

    public void setOnClickTopItemListener(OnClickTopItemListener onClickTopItemListener) {
        this.onClickTopItemListener = onClickTopItemListener;
    }

    public interface OnClickTopItemListener{
        void onClick(int movieId);
    }
}


