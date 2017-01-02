package com.example.ngochieu.myappinternship;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class HolderMyEvent extends RecyclerView.ViewHolder {
    TextView txtEventName;
    TextView txtEventTime;
    TextView txtEventAddress;
    ImageView imgMap;
    public HolderMyEvent(View itemView) {
        super(itemView);
        txtEventName = (TextView) itemView.findViewById(R.id.txtNameEvent);
        txtEventTime = (TextView) itemView.findViewById(R.id.txtTimeEvent);
        txtEventAddress = (TextView) itemView.findViewById(R.id.txtAddressEvent);
        imgMap = (ImageView) itemView.findViewById(R.id.imgMap);

    }

}
