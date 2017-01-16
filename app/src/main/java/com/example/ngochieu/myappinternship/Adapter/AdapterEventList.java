package com.example.ngochieu.myappinternship.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;

import java.util.List;

/**
 * Created by NgocHieu on 1/13/2017.
 */

public class AdapterEventList extends RecyclerView.Adapter<AdapterEventList.HolderEvent> {
    Context context;
    List<MyEvent> data;
    MyEventOnClickListener myEventOnClickListener;

    public void setMyEventOnClickListener(MyEventOnClickListener myEventOnClickListener) {
        this.myEventOnClickListener = myEventOnClickListener;
    }

    public AdapterEventList(Context context, List<MyEvent> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public HolderEvent onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_list,parent,false);
        return new HolderEvent(view);
    }

    @Override
    public void onBindViewHolder(HolderEvent holder, int position) {
            MyEvent myEvent = data.get(position);
        holder.txtNameEvent.setText(myEvent.getNameEvent());
        holder.txtTime.setText(myEvent.getStartTime());
        MyDate myDate = myEvent.getStartDate();
        holder.txtStartDate.setText(myDate.getDay()+"/"+myDate.getMonth()+" : "+myDate.getDayOfWeek());
        holder.txtTime.setText(myEvent.getStartTime()+" - "+myEvent.getEndTime());
        holder.txtStartTime.setText(myEvent.getStartTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HolderEvent extends RecyclerView.ViewHolder {
        TextView txtStartDate;
        TextView txtTime;
        TextView txtNameEvent;
        TextView txtStartTime;
        public HolderEvent(View itemView) {
            super(itemView);
            txtStartDate = (TextView) itemView.findViewById(R.id.txtStartDate);
            txtStartTime = (TextView) itemView.findViewById(R.id.txtStartTime);
            txtNameEvent = (TextView) itemView.findViewById(R.id.txtNameEvent);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myEventOnClickListener.myOnClick(data.get(getAdapterPosition()));
                }
            });
        }
    }
    public interface MyEventOnClickListener{
        void myOnClick(MyEvent myEvent);
    }
}
