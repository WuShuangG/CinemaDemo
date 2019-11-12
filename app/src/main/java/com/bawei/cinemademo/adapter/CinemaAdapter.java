package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.CinemaName;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe(描述)：com.bawei.gailei20191105.adapter
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:41
 * @author（作者）: 盖磊
 **/
public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder> {

    List<CinemaName> list = new ArrayList<>();

    public void addAll(List<CinemaName> data){
        if (list != null) {
            list.clear();
            list.addAll(data);
        }
    }
    @NonNull
    @Override
    public CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_cinemas, viewGroup, false);
        return new CinemaViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaViewHolder holder, final int i) {
        CinemaName name = list.get(i);
        holder.mName.setText(name.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //1704B gailei 2019.11.5
    class CinemaViewHolder extends RecyclerView.ViewHolder{
        TextView mName;
        public CinemaViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_cinemas);
        }
    }

}
