package com.example.ngochieu.myappinternship;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class RecycleViewWeek extends RecyclerView.Adapter<HolderWeek> {
    List<Week> data;
    Context context;

    public RecycleViewWeek( Context context,List<Week> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public HolderWeek onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_week, parent, false);
        HolderWeek holderWeek = new HolderWeek(view);
        return holderWeek;
    }

    @Override
    public void onBindViewHolder(HolderWeek holder, int position) {
       final Week week = data.get(position);
        holder.txtName.setText(week.getName());
        holder.txtContent.setText(week.getContent());
        holder.txtContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"print ",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
