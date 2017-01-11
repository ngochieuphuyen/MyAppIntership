package com.example.ngochieu.myappinternship.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.R;

import java.util.List;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class AdapterCalenderView extends RecyclerView.Adapter<AdapterCalenderView.HolderCalenderView> {

    Context context;
    List<MyDate> data;

    public AdapterCalenderView(Context context, List<MyDate> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderCalenderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calender_view,parent,false);

        return new HolderCalenderView(view);
    }

    @Override
    public void onBindViewHolder(HolderCalenderView holder, int position) {
        MyDate myDate = data.get(position);
        holder.txtDayOfSun.setText(String.valueOf(myDate.getDay()));
//        holder.txtDayOfmoon.setText(myDate.dayOfMoon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderCalenderView extends RecyclerView.ViewHolder{
        TextView txtDayOfSun;
//        TextView txtDayOfmoon;
        public HolderCalenderView(View itemView) {
            super(itemView);
            txtDayOfSun = (TextView) itemView.findViewById(R.id.txtDayOfSun);
//            txtDayOfmoon = (TextView) itemView.findViewById(R.id.txtDayOfMoon);
        }
    }
}
