package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.Cinemas;
import com.bawei.cinemademo.utils.FrescoUtils;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe(描述)：com.bawei.gailei20191105.adapter
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:41
 * @author（作者）: 盖磊
 **/
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    List<Cinemas> list = new ArrayList<>();

    public void addAll(List<Cinemas> data){
        list.addAll(data);
    }

    public void clear() {
        list.clear();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_item, viewGroup, false);
        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int i) {
        Cinemas cinemas = list.get(i);
        FrescoUtils.getInstance().showUrlBlur(holder.mIV,cinemas.logo,1,1);
        holder.mName.setText(cinemas.name);
        holder.mDress.setText(cinemas.address);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView mIV;
        TextView mName,mDress;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mIV = itemView.findViewById(R.id.home_image);
            mDress = itemView.findViewById(R.id.home_dress);
            mName = itemView.findViewById(R.id.home_name);
        }
    }
}
