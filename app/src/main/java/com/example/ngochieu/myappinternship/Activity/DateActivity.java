package com.example.ngochieu.myappinternship.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Adapter.AdapterFragmentDay;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyConstant;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;
import com.example.ngochieu.myappinternship.Support.Support;

import java.util.List;

/**
 * Created by NgocHieu on 1/16/2017.
 */

public class DateActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyEventDAO myEventDAO;
    TextView txtMonthandYear;
    TextView txtDay;
    TextView txtDayofWeek;
    TextView txtLunarDay;
    TextView txtLunarMonth;

    AdapterFragmentDay adapter;

    MyDate myDate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_day);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        myDate = bundle.getParcelable("mydate");

        recyclerView = (RecyclerView) findViewById(R.id.list_day);
        myEventDAO = new MyEventDAO(this);
        txtMonthandYear = (TextView) findViewById(R.id.txtMonthandYear);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtDayofWeek = (TextView) findViewById(R.id.txtDayofWeek);
        txtLunarDay = (TextView) findViewById(R.id.txtLunarDay);
        txtLunarMonth = (TextView) findViewById(R.id.txtLunarMonth);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<MyEvent> data = myEventDAO.getAllDateOfDate(myDate.getId());
        adapter = new AdapterFragmentDay(this,data);

        adapter.setMyOnClick(new AdapterFragmentDay.MyOnClick() {
            @Override
            public void onClick(final MyEvent myEvent) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DateActivity.this);
                builder.setTitle(myEvent.getNameEvent());
                builder.setMessage(myEvent.getStartTime()+ " - "+ myEvent.getEndTime());
                builder.setPositiveButton("Detail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(DateActivity.this, DetailEventActivity.class);
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
        txtMonthandYear.setText(MyConstant.KEY_MONTH[myDate.getMonth()]+", "+ myDate.getYear());
        txtDay.setText(String.valueOf(myDate.getDay()));
        txtDayofWeek.setText(Support.getFullDayOfWeek(myDate.getDayOfWeek()));

        txtLunarDay.setText(String.valueOf(myDate.getLunarDay()));
        txtLunarMonth.setText(MyConstant.KEY_MONTH[myDate.getLunarMonth()]);
    }
}
