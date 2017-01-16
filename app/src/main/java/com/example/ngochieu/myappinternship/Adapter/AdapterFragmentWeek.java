package com.example.ngochieu.myappinternship.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;
import com.example.ngochieu.myappinternship.Support.Support;

import java.util.List;

/**
 * Created by NgocHieu on 1/14/2017.
 */

public class AdapterFragmentWeek extends RecyclerView.Adapter<AdapterFragmentWeek.HolderWeek> {
    Context context;
    List<MyDate> data;

    public AdapterFragmentWeek(Context context, List<MyDate> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderWeek onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_week,parent,false);
        return new HolderWeek(view);
    }

    @Override
    public void onBindViewHolder(HolderWeek holder, int position) {
        MyDate myDate = data.get(position);
        holder.txtDayofWeek.setText(Support.getFullDayOfWeek(myDate.getDayOfWeek()));
        holder.txtDayAndMonth.setText(myDate.getDay()+"/"+myDate.getMonth());
        MyEventDAO myEventDAO = new MyEventDAO(context);
        List<MyEvent> listEvent = myEventDAO.getAllDateOfDate(myDate.getId());
        String task ="";
        for (int i = 0; i <listEvent.size()-1 ; i++) {
            task.concat(listEvent.get(i).getNameEvent()+", ");
        }
        if (listEvent.size()>0){
            task.concat(listEvent.get(listEvent.size()-1).getNameEvent()+", ");
        }
        Log.d("12345", "onBindViewHolder: "+task);
        holder.txtTask.setText(task);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderWeek extends RecyclerView.ViewHolder {
        TextView txtDayofWeek;
        TextView txtDayAndMonth;
        TextView txtTask;
        public HolderWeek(View itemView) {
            super(itemView);
            txtDayofWeek = (TextView) itemView.findViewById(R.id.txtDayofWeek);
            txtDayAndMonth = (TextView) itemView.findViewById(R.id.txtDayAndMonth);
            txtTask = (TextView) itemView.findViewById(R.id.txtTask);
        }
    }
}
