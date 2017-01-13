package com.example.ngochieu.myappinternship.Activity;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TimePicker;

import com.example.ngochieu.myappinternship.Database.MyDateDAO;
import com.example.ngochieu.myappinternship.Database.MyEventDAO;
import com.example.ngochieu.myappinternship.R;
import com.example.ngochieu.myappinternship.Support.MyDate;
import com.example.ngochieu.myappinternship.Support.MyEvent;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editNameEvent;
    EditText editAddress;
    EditText editStartDate;
    EditText editEndDate;
    EditText editStartTime;
    EditText editEndTime;
    EditText editGuests;
    EditText editDescribe;
    Button btnDone;
    Button btnCancel;
    ImageView imgBack;
    Switch switchAllDay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        editNameEvent = (EditText) findViewById(R.id.editNameEvent);
        editAddress = (EditText) findViewById(R.id.editAddressOfEvent);
        editGuests = (EditText) findViewById(R.id.editGuests);
        editDescribe = (EditText) findViewById(R.id.editDescribe);


        editStartDate = (EditText) findViewById(R.id.editStartDate);
        editStartDate.setOnClickListener(this);
        editEndDate = (EditText) findViewById(R.id.editEndDate);
        editEndDate.setOnClickListener(this);
        editStartTime = (EditText) findViewById(R.id.editStartTime);
        editStartTime.setOnClickListener(this);
        editEndTime = (EditText) findViewById(R.id.editEndTime);
        editEndTime.setOnClickListener(this);


        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);

        switchAllDay = (Switch) findViewById(R.id.SwitchAllDay);

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AddEventActivity.this);
        final View picker = getLayoutInflater().inflate(R.layout.dialog_date,null);
        switch (v.getId()){
            case R.id.editStartDate:
                dialog.setView(picker);

                dialog.setTitle("Select date");
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatePicker dateStart = (DatePicker) picker.findViewById(R.id.datePicker1);
                        editStartDate.setText(dateStart.getDayOfMonth()+"/"+(dateStart.getMonth()+1)+"/"+dateStart.getYear());
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;
            case R.id.editEndDate:
                dialog.setView(picker);

                dialog.setTitle("Select date");
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatePicker dateEnd = (DatePicker) picker.findViewById(R.id.datePicker1);
                        editEndDate.setText(dateEnd.getDayOfMonth()+"/"+(dateEnd.getMonth()+1)+"/"+dateEnd.getYear());
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;
            case R.id.editStartTime:
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                editStartTime.setText(hourOfDay + ":" + minute);
                            }
                        }, 0, 0, false);
                timePickerDialog.show();
                break;
            case R.id.editEndTime:
                TimePickerDialog timePickerDialogEnd = new TimePickerDialog(AddEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                editEndTime.setText(hourOfDay + ":" + minute);
                            }
                        }, 0, 0, false);
                timePickerDialogEnd.show();
                break;
            case R.id.btnDone:
                MyEvent myEvent = new MyEvent();
                MyDateDAO myDateDAO = new MyDateDAO(AddEventActivity.this);
                MyEventDAO myEventDAO = new MyEventDAO(AddEventActivity.this);
                if (editNameEvent.getText().toString() != null){
                    myEvent.setNameEvent(editNameEvent.getText().toString());
                }
                if (editAddress.getText().toString() != null){
                    myEvent.setAddress(editAddress.getText().toString());
                }
                if (editStartDate.getText().toString() != null){
                    String mString = editStartDate.getText().toString();
                    String[] StringDate = mString.split("/");
                    int day = Integer.parseInt(StringDate[0]);
                    int month = Integer.parseInt(StringDate[1]);
                    int year = Integer.parseInt(StringDate[2]);
                    int id_date = myDateDAO.getIdDate(day,month,year);
                    MyDate myDate = myDateDAO.getMyDate(id_date);
                    myEvent.setStartDate(myDate);
                }
                if (editEndDate.getText().toString() != null){
                    String mString = editEndDate.getText().toString();
                    String[] StringDate = mString.split("/");
                    int day = Integer.parseInt(StringDate[0]);
                    int month = Integer.parseInt(StringDate[1]);
                    int year = Integer.parseInt(StringDate[2]);
                    int id_date = myDateDAO.getIdDate(day,month,year);
                    MyDate myDate = myDateDAO.getMyDate(id_date);
                    myEvent.setEndDate(myDate);
                }
                if (editStartTime.getText().toString() != null){
                    myEvent.setStartTime(editStartTime.getText().toString());
                }
                if (editEndTime.getText().toString() != null){
                    myEvent.setEndTime(editEndTime.getText().toString());
                }
                if (editGuests.getText().toString() != null){
                    myEvent.setGuest(editGuests.getText().toString());
                }
                if (editDescribe.getText().toString() != null){
                    myEvent.setDescription(editDescribe.getText().toString());
                }
                myEventDAO.AddEvent(myEvent);
                finish();
                break;
            case R.id.btnCancel:
                finish();
                break;
            case R.id.imgBack:
                finish();
                break;
        }
    }
}
