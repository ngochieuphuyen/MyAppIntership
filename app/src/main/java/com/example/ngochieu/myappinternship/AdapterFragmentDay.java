package com.example.ngochieu.myappinternship;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class AdapterFragmentDay extends RecyclerView.Adapter<AdapterFragmentDay.HolderMyEvent> {
    Context context;
    List<MyEvent> data;

    public AdapterFragmentDay(Context context, List<MyEvent> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderMyEvent onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_day, parent,false);
        return new HolderMyEvent(view);
    }

    @Override
    public void onBindViewHolder(HolderMyEvent holder, int position) {
        MyEvent myEvent = data.get(position);
        holder.txtStartAndEnd.setText(myEvent.getStartTime()+" : "+myEvent.getEndTime());
        holder.txtStart.setText(myEvent.getStartTime());
        holder.txtNameEvent.setText(myEvent.getNameEvent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderMyEvent extends RecyclerView.ViewHolder{
        TextView txtStart;
        TextView txtStartAndEnd;
        TextView txtNameEvent;
        public HolderMyEvent(View itemView) {
            super(itemView);
            txtStart = (TextView) itemView.findViewById(R.id.txtStart);
            txtStartAndEnd = (TextView) itemView.findViewById(R.id.txtStartAndEnd);
            txtNameEvent = (TextView) itemView.findViewById(R.id.txtNameEvent);
        }
    }
}
