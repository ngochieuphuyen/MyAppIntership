package com.example.ngochieu.myappinternship;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class HolderWeek extends RecyclerView.ViewHolder {
    TextView txtName;
    TextView txtContent;
    public HolderWeek(View itemView) {
        super(itemView);
        txtName = (TextView) itemView.findViewById(R.id.txtWeekName);
        txtContent = (TextView) itemView.findViewById(R.id.contentWeek);

    }
}
