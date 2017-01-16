package com.example.ngochieu.myappinternship.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Activity.DetailEventActivity;
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

    RecyclerView recyclerView;
    MyEventDAO myEventDAO;
    TextView txtMonthandYear;
    TextView txtDay;
    TextView txtDayofWeek;
    TextView txtLunarDay;
    TextView txtLunarMonth;

    AdapterFragmentDay adapter;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_day, container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_day);


        myEventDAO = new MyEventDAO(context);



        txtMonthandYear = (TextView) view.findViewById(R.id.txtMonthandYear);
        txtDay = (TextView) view.findViewById(R.id.txtDay);
        txtDayofWeek = (TextView) view.findViewById(R.id.txtDayofWeek);
        txtLunarDay = (TextView) view.findViewById(R.id.txtLunarDay);
        txtLunarMonth = (TextView) view.findViewById(R.id.txtLunarMonth);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        Calendar calendar = Calendar.getInstance();
        final MyDateDAO myDateDAO = new MyDateDAO(context);
        int id_date = myDateDAO.getIdDate(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR));
        MyDate today = myDateDAO.getMyDate(id_date);
        List<MyEvent> data = myEventDAO.getAllDateOfDate(id_date);
       adapter = new AdapterFragmentDay(context,data);

        adapter.setMyOnClick(new AdapterFragmentDay.MyOnClick() {
            @Override
            public void onClick(final MyEvent myEvent) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(myEvent.getNameEvent());
                builder.setMessage(myEvent.getStartTime()+ " - "+ myEvent.getEndTime());
                builder.setPositiveButton("Detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, DetailEventActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("myevent", myEvent);
                        bundle.putParcelable("endDate",myEvent.getEndDate());
                        bundle.putParcelable("startDate",myEvent.getStartDate());
                        intent.putExtra("bundle",bundle);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });

        recyclerView.setAdapter(adapter);
        txtMonthandYear.setText(MyConstant.KEY_MONTH[today.getMonth()]+", "+ today.getYear());
        txtDay.setText(String.valueOf(today.getDay()));
        txtDayofWeek.setText(Support.getFullDayOfWeek(today.getDayOfWeek()));

        txtLunarDay.setText(String.valueOf(today.getLunarDay()));
        txtLunarMonth.setText(MyConstant.KEY_MONTH[today.getLunarMonth()]);
    }


}
