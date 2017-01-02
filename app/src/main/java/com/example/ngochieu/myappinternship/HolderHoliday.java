package com.example.ngochieu.myappinternship;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class HolderHoliday extends RecyclerView.ViewHolder {
    TextView txtHolidayName;
    TextView txtHolidayTime;
    TextView txtHolidayDescribe;
    public HolderHoliday(View itemView) {
        super(itemView);
        txtHolidayName = (TextView) itemView.findViewById(R.id.txtNameHoliday);
        txtHolidayTime = (TextView) itemView.findViewById(R.id.txtTimeHoliday);
        txtHolidayDescribe = (TextView) itemView.findViewById(R.id.DescribeOfHoliday);
    }
}
