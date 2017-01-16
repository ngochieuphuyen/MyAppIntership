package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Adapter.AdapterFragmentDay;
import com.example.ngochieu.myappinternship.Database.MyDateDAO;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.Support.MyConstant;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.Support;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class FragmentDay extends Fragment{
    Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_day, container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_day);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        Calendar calendar = Calendar.getInstance();
        MyDateDAO myDateDAO = new MyDateDAO(context);
        int id_date = myDateDAO.getIdDate(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR));
        MyDate today = myDateDAO.getMyDate(id_date);

        MyEventDAO myEventDAO = new MyEventDAO(context);

        List<MyEvent> data = myEventDAO.getAllDateOfDate(id_date);
        AdapterFragmentDay adapter = new AdapterFragmentDay(context,data);
        recyclerView.setAdapter(adapter);

        TextView txtMonthandYear = (TextView) view.findViewById(R.id.txtMonthandYear);
        TextView txtDay = (TextView) view.findViewById(R.id.txtDay);
        TextView txtDayofWeek = (TextView) view.findViewById(R.id.txtDayofWeek);
        TextView txtLunarDay = (TextView) view.findViewById(R.id.txtLunarDay);
        TextView txtLunarMonth = (TextView) view.findViewById(R.id.txtLunarMonth);

        txtMonthandYear.setText(MyConstant.KEY_MONTH[today.getMonth()]+", "+ today.getYear());
        txtDay.setText(String.valueOf(today.getDay()));
        txtDayofWeek.setText(Support.getFullDayOfWeek(today.getDayOfWeek()));

        txtLunarDay.setText(String.valueOf(today.getLunarDay()));
        txtLunarMonth.setText(MyConstant.KEY_MONTH[today.getLunarMonth()]);

        return view;
    }
}
