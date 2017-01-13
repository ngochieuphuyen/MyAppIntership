package com.example.ngochieu.myappinternship.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ngochieu.myappinternship.Support.MyEvent;

import java.util.ArrayList;
import java.util.List;

import static com.example.ngochieu.myappinternship.Database.DatabaseHandler.TABLE_EVENTS;
import static com.example.ngochieu.myappinternship.Database.DatabaseHandler.TABLE_MYDATES;

/**
 * Created by NgocHieu on 1/12/2017.
 */

public class MyEventDAO {
    Context context;
    DatabaseHandler databaseHandler;

    public MyEventDAO(Context context) {
        this.context = context;
        this.databaseHandler = new DatabaseHandler(context);
    }
    public void AddEvent(MyEvent event){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.EventColumn.KEY_NAME,event.getNameEvent());
        values.put(DatabaseHandler.EventColumn.KEY_ADDRESS,event.getAddress());
        values.put(DatabaseHandler.EventColumn.KEY_STARTTIME,event.getStartTime());
        values.put(DatabaseHandler.EventColumn.KEY_ENDTIME,event.getEndTime());
        values.put(DatabaseHandler.EventColumn.KEY_STARTDATE,event.getStartDate().getId());
        values.put(DatabaseHandler.EventColumn.KEY_ENDDATE,event.getEndDate().getId());
        values.put(DatabaseHandler.EventColumn.KEY_GUEST,event.getGuest());
        values.put(DatabaseHandler.EventColumn.KEY_DESCRIPTION,event.getDescription());

        db.insert(DatabaseHandler.TABLE_EVENTS, null, values);
        db.close();
    }
    public MyEvent getEvent(int id){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.query(DatabaseHandler.TABLE_EVENTS, new String[] { DatabaseHandler.EventColumn._ID,
                        DatabaseHandler.EventColumn.KEY_NAME, DatabaseHandler.EventColumn.KEY_ADDRESS,
                        DatabaseHandler.EventColumn.KEY_STARTTIME,DatabaseHandler.EventColumn.KEY_ENDTIME,
                        DatabaseHandler.EventColumn.KEY_STARTDATE,DatabaseHandler.EventColumn.KEY_ENDDATE,
                        DatabaseHandler.EventColumn.KEY_GUEST, DatabaseHandler.EventColumn.KEY_GUEST},
                DatabaseHandler.EventColumn._ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        MyDateDAO myDateDAO = new MyDateDAO(context);
        MyEvent event = new MyEvent(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),myDateDAO.getMyDate(Integer.parseInt(cursor.getString(5))),
                myDateDAO.getMyDate(Integer.parseInt(cursor.getString(6))), cursor.getString(7),
                cursor.getString(8));

        return event;
    }
    public List<MyEvent> getAllEvent(){
        List<MyEvent> listEvent = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        String sql =" select * from "+DatabaseHandler.TABLE_EVENTS;
        Cursor cursor = db.rawQuery(sql,null);
        MyDateDAO myDateDAO = new MyDateDAO(context);
        if (cursor.moveToFirst()) {
            do {
                MyEvent event = new MyEvent();
                event.setId(Integer.parseInt(cursor.getString(0)));
                event.setNameEvent(cursor.getString(1));
                event.setAddress(cursor.getString(2));
                event.setStartTime(cursor.getString(3));
                event.setEndTime(cursor.getString(4));
                event.setStartDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(5))));
                event.setEndDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(6))));
                event.setGuest(cursor.getString(7));
                event.setDescription(cursor.getString(8));


                // Adding contact to list
                listEvent.add(event);
            } while (cursor.moveToNext());
        }

        return listEvent;
    }
    public int getEventCount() {
        String countQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_EVENTS;
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public int updateEvent(MyEvent event) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.EventColumn.KEY_NAME, event.getNameEvent());
        values.put(DatabaseHandler.EventColumn.KEY_ADDRESS, event.getAddress());
        values.put(DatabaseHandler.EventColumn.KEY_STARTTIME, event.getStartTime());
        values.put(DatabaseHandler.EventColumn.KEY_ENDTIME, event.getEndTime());
        values.put(DatabaseHandler.EventColumn.KEY_STARTDATE, event.getStartDate().getId());
        values.put(DatabaseHandler.EventColumn.KEY_ENDDATE, event.getEndDate().getId());
        values.put(DatabaseHandler.EventColumn.KEY_GUEST, event.getGuest());
        values.put(DatabaseHandler.EventColumn.KEY_DESCRIPTION, event.getDescription());

        // updating row
        return db.update(DatabaseHandler.TABLE_MYDATES, values, DatabaseHandler.EventColumn._ID + " = ?",
                new String[] { String.valueOf(event.getId()) });
    }
    public void deleteEvent(MyEvent event) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(DatabaseHandler.TABLE_EVENTS, DatabaseHandler.EventColumn._ID + " = ?",
                new String[] { String.valueOf(event.getId()) });
        db.close();
    }
    public List<MyEvent> getListEventDate(int idOfDate){
        List<MyEvent> listEvent = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        String sql =" select * from "+DatabaseHandler.TABLE_EVENTS + " where "+ DatabaseHandler.EventColumn._ID + " = " + idOfDate;

        Cursor cursor = db.rawQuery(sql,null);
        MyDateDAO myDateDAO = new MyDateDAO(context);
        if (cursor.moveToFirst()) {
            do {
                MyEvent event = new MyEvent();
                event.setId(Integer.parseInt(cursor.getString(0)));
                event.setNameEvent(cursor.getString(1));
                event.setAddress(cursor.getString(2));
                event.setStartTime(cursor.getString(3));
                event.setEndTime(cursor.getString(4));
                event.setStartDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(5))));
                event.setEndDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(6))));
                event.setGuest(cursor.getString(7));
                event.setDescription(cursor.getString(8));


                // Adding contact to list
                listEvent.add(event);
            } while (cursor.moveToNext());
        }

        return listEvent;
    }
    public List<MyEvent> getAllDateOfDate(int idStartDate){
        List<MyEvent> eventList = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        String sql ="select * from "+ TABLE_EVENTS
                + " where " + DatabaseHandler.EventColumn.KEY_STARTDATE + " = " + idStartDate;
        Cursor cursor = db.rawQuery(sql,null);
        MyDateDAO myDateDAO = new MyDateDAO(context);
        if (cursor.moveToFirst()) {
            do {
                MyEvent event = new MyEvent();
                event.setId(Integer.parseInt(cursor.getString(0)));
                event.setNameEvent(cursor.getString(1));
                event.setAddress(cursor.getString(2));
                event.setStartTime(cursor.getString(3));
                event.setEndTime(cursor.getString(4));
                event.setStartDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(5))));
                event.setEndDate(myDateDAO.getMyDate(Integer.parseInt(cursor.getString(6))));
                event.setGuest(cursor.getString(7));
                event.setDescription(cursor.getString(8));


                // Adding contact to list
                eventList.add(event);
            } while (cursor.moveToNext());
        }
        return eventList;
    }
}
