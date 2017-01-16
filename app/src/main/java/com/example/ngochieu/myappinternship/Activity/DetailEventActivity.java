package com.example.ngochieu.myappinternship.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ngochieu.myappinternship.Database.MyDateDAO;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;

/**
 * Created by NgocHieu on 1/16/2017.
 */

public class DetailEventActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = DetailEventActivity.class.getSimpleName();
    TextView txtNameEvent;
    TextView txtAddressOfEvent;
    TextView txtStartDate;
    TextView txtStartTime;
    TextView txtEndDate;
    TextView txtEndTime;
    TextView txtGuests;
    TextView txtDescribe;

    Button btnDelete;
    Button btnEdit;
    Button btnClose;

    MyEvent myEvent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_event);

        txtNameEvent = (TextView) findViewById(R.id.txtNameEvent);
        txtAddressOfEvent = (TextView) findViewById(R.id.txtAddressOfEvent);
        txtStartDate = (TextView) findViewById(R.id.txtStartDate);
        txtStartTime = (TextView) findViewById(R.id.txtStartTime);
        txtEndDate = (TextView) findViewById(R.id.txtEndDate);
        txtEndTime = (TextView) findViewById(R.id.txtEndTime);
        txtGuests = (TextView) findViewById(R.id.txtGuests);
        txtDescribe = (TextView) findViewById(R.id.txtDescribe);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        myEvent = (MyEvent) bundle.getParcelable("myevent");

        txtNameEvent.setText(myEvent.getNameEvent());
        txtAddressOfEvent.setText(myEvent.getAddress());
        MyDate startDate = bundle.getParcelable("startDate");
        MyDate endDate = bundle.getParcelable("endDate");
        txtStartDate.setText(startDate.toStringSun());
        txtStartTime.setText(myEvent.getStartTime());
        txtEndDate.setText(endDate.toStringSun());
        txtEndTime.setText(myEvent.getEndTime());
        txtGuests.setText(myEvent.getGuest());
        txtDescribe.setText(myEvent.getDescription());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDelete:
                MyEventDAO myEventDAO = new MyEventDAO(DetailEventActivity.this);
                myEventDAO.deleteEvent(myEvent);
                finish();
                break;
            case R.id.btnEdit:

                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }
}
