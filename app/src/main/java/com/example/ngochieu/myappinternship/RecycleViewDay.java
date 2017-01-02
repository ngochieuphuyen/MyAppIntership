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

public class RecycleViewDay extends RecyclerView.Adapter<HolderMyEvent> {
    Context context;
    List<MyEvent> data;

    public RecycleViewDay(Context context, List<MyEvent> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public HolderMyEvent onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_event, parent, false);

        HolderMyEvent holderMyEvent = new HolderMyEvent(view);
        return holderMyEvent;
    }

    @Override
    public void onBindViewHolder(final HolderMyEvent holder, int position) {
        final MyEvent myEvent = data.get(position);
        holder.txtEventName.setText(myEvent.getEventName());
        holder.txtEventTime.setText(myEvent.getEventTime());
        holder.txtEventAddress.setText(myEvent.getEventAddress());
        holder.imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get address of event
                String address = myEvent.getEventAddress();
                Toast.makeText(context,address,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
