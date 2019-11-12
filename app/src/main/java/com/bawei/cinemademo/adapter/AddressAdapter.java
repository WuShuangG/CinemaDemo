package com.bawei.cinemademo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bawei.cinemademo.R;
import com.bawei.cinemademo.bean.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * @describe(描述)：com.bawei.gailei20191105.adapter
 * @data（日期）: 09:2019/11/5
 * @time（时间）: 9:41
 * @author（作者）: 盖磊
 **/
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.HomeViewHolder> {

    List<Address> list = new ArrayList<>();

    public void addAll(List<Address> data){
        list.addAll(data);
    }

    public void clear() {
        list.clear();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_dress, viewGroup, false);
        return new HomeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int i) {
        Address address = list.get(i);
        holder.mDress.setText(address.name);
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClick(v,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView mDress;
        LinearLayout mLayout;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mDress = itemView.findViewById(R.id.text_address);
            mLayout = itemView.findViewById(R.id.address_layout);
        }
    }

    private OnClickItemListener onClickItemListener;


    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public interface OnClickItemListener{
        void onClick(View view, int position);
    }

}
