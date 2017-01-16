package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngochieu.myappinternship.Adapter.AdapterCalenderMonth;
import com.example.ngochieu.myappinternship.Adapter.AdapterEventList;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyEvent;
import com.example.ngochieu.myappinternship.Support.Support;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by NgocHieu on 1/7/2017.
 */

public class FragmentMonth extends Fragment implements AdapterCalenderMonth.MyOnClick {
    Context context;
    RecyclerView recyclerViewEvent;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_month,container,false);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        List<MyDate> data = Support.getDateOfMonth(month,year,context);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_month);
        recyclerView.setLayoutManager(new GridLayoutManager(context,7));

        AdapterCalenderMonth adapterCalenderMonth = new AdapterCalenderMonth(context,data);
        adapterCalenderMonth.setMyOnClick(this);
        recyclerView.setAdapter(adapterCalenderMonth);

        recyclerViewEvent = (RecyclerView) view.findViewById(R.id.list_event_month);



        return view;
    }

    @Override
    public void onClick(MyDate myDate) {
        recyclerViewEvent.setLayoutManager(new LinearLayoutManager(context));
        MyEventDAO myEventDAO = new MyEventDAO(context);
        List<MyEvent> dataEvent = myEventDAO.getAllDateOfDate(myDate.getId());
        AdapterEventList adapterEventList = new AdapterEventList(context,dataEvent);
        recyclerViewEvent.setAdapter(adapterEventList);
    }
}
