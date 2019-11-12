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
import com.bawei.cinemademo.bean.Soon;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @describe(描述)：com.bawei.goshopdemo.model.adapter
 * @data（日期）: 14:2019/10/17
 * @time（时间）: 14:13
 * @author（作者）: 盖磊
 **/
public class CenterAdapter extends RecyclerView.Adapter<CenterAdapter.CenterViewHolder> {

    List<Soon> list = new ArrayList<>();

    public void addAll(List<Soon> data){
        this.list = data;
    }

    @NonNull
    @Override
    public CenterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_center_item, viewGroup,false);
        return new CenterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CenterViewHolder holder, final int i) {
        Soon soon = list.get(i);
        FrescoUtils.getInstance().showUrlBlur(holder.image,soon.imageUrl,1,1);
        holder.name.setText(soon.name);
        holder.people.setText(soon.wantSeeNum + "人想看");
        Date date = new Date(soon.releaseTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日上映");
        holder.times.setText(dateFormat.format(date));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CenterViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        TextView name,times,people;
        Button buy;
        public CenterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.movie_center_image);
            name = itemView.findViewById(R.id.movie_center_score);
            times = itemView.findViewById(R.id.movie_center_name);
            people = itemView.findViewById(R.id.movie_center_people);
            buy = itemView.findViewById(R.id.movie_center_btn);
        }
    }


}


