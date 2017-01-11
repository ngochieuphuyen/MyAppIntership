package com.example.ngochieu.myappinternship.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.R;

import java.util.List;

/**
 * Created by NgocHieu on 1/7/2017.
 */

public class AdapterCalenderMonth extends RecyclerView.Adapter<AdapterCalenderMonth.HolderMyDate> {
    Context context;
    List<MyDate> data;

    public AdapterCalenderMonth(Context context, List<MyDate> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderMyDate onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_month,parent,false);

        return new HolderMyDate(view);
    }

    @Override
    public void onBindViewHolder(HolderMyDate holder, int position) {
        MyDate myDate = data.get(position);
        holder.txtDayOfSun.setText(String.valueOf(myDate.getDay()));
        holder.txtDayOfmoon.setText(String.valueOf(myDate.getLunarDay()));


    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    class HolderMyDate extends RecyclerView.ViewHolder{
        TextView txtDayOfSun;
        TextView txtDayOfmoon;
        LinearLayout itemListMonth;
        public HolderMyDate(View itemView) {
            super(itemView);
            txtDayOfSun = (TextView) itemView.findViewById(R.id.txtDayOfSun);
            txtDayOfmoon = (TextView) itemView.findViewById(R.id.txtDayOfMoon);
            itemListMonth = (LinearLayout) itemView.findViewById(R.id.item_list_month);
        }
    }
}
