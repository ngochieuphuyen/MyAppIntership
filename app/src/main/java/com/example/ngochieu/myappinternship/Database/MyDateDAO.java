package com.example.ngochieu.myappinternship.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ngochieu.myappinternship.Support.MyDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgocHieu on 1/12/2017.
 */

public class MyDateDAO {
    Context context;
    DatabaseHandler databaseHandler;

    public MyDateDAO(Context context, DatabaseHandler databaseHandler) {
        this.context = context;
        this.databaseHandler = databaseHandler;
    }

    public void addMyDate(MyDate myDate){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.MyDateColumn.KEY_DAY,myDate.getDay());
        values.put(DatabaseHandler.MyDateColumn.KEY_DAYOFWEEK,myDate.getDayOfWeek());
        values.put(DatabaseHandler.MyDateColumn.KEY_MONTH,myDate.getMonth());
        values.put(DatabaseHandler.MyDateColumn.KEY_YEAR,myDate.getYear());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARDAY,myDate.getLunarDay());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARMONTH,myDate.getLunarMonth());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARYEAR,myDate.getLunarYear());

        db.insert(DatabaseHandler.TABLE_MYDATES, null, values);
        db.close();
    }
    public MyDate getMyDate(int id){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.query(DatabaseHandler.TABLE_MYDATES, new String[] { DatabaseHandler.MyDateColumn._ID,
                        DatabaseHandler.MyDateColumn.KEY_DAY, DatabaseHandler.MyDateColumn.KEY_DAYOFWEEK,
                        DatabaseHandler.MyDateColumn.KEY_MONTH,DatabaseHandler.MyDateColumn.KEY_YEAR,
                        DatabaseHandler.MyDateColumn.KEY_LUNARDAY,DatabaseHandler.MyDateColumn.KEY_LUNARMONTH,
                        DatabaseHandler.MyDateColumn.KEY_LUNARYEAR}, DatabaseHandler.MyDateColumn._ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        MyDate myDate = new MyDate(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), cursor.getString(2),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)));

        return myDate;
    }
    public List<MyDate> getAllMyDate(){
        List<MyDate> listMyDate = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        String sql =" select * form "+DatabaseHandler.TABLE_MYDATES;
        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()) {
            do {
                MyDate myDate = new MyDate();

                myDate.setId(Integer.parseInt(cursor.getString(0)));
                myDate.setDay(Integer.parseInt(cursor.getString(1)));
                myDate.setDayOfWeek(cursor.getString(2));
                myDate.setMonth(Integer.parseInt(cursor.getString(3)));
                myDate.setYear(Integer.parseInt(cursor.getString(4)));
                myDate.setLunarDay(Integer.parseInt(cursor.getString(5)));
                myDate.setLunarMonth(Integer.parseInt(cursor.getString(6)));
                myDate.setLunarYear(Integer.parseInt(cursor.getString(7)));

                // Adding contact to list
                listMyDate.add(myDate);
            } while (cursor.moveToNext());
        }

        return listMyDate;
    }
    public int getMyDatesCount() {
        String countQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_MYDATES;
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public int updateMyDate(MyDate myDate) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.MyDateColumn.KEY_DAY, myDate.getDay());
        values.put(DatabaseHandler.MyDateColumn.KEY_DAYOFWEEK, myDate.getDayOfWeek());
        values.put(DatabaseHandler.MyDateColumn.KEY_MONTH, myDate.getMonth());
        values.put(DatabaseHandler.MyDateColumn.KEY_YEAR, myDate.getYear());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARDAY, myDate.getLunarDay());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARMONTH, myDate.getLunarMonth());
        values.put(DatabaseHandler.MyDateColumn.KEY_LUNARYEAR, myDate.getLunarYear());

        // updating row
        return db.update(DatabaseHandler.TABLE_MYDATES, values, DatabaseHandler.MyDateColumn._ID + " = ?",
                new String[] { String.valueOf(myDate.getId()) });
    }
    public void deleteMyDate(MyDate myDate) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(DatabaseHandler.TABLE_MYDATES, DatabaseHandler.MyDateColumn._ID + " = ?",
                new String[] { String.valueOf(myDate.getId()) });
        db.close();
    }
    public int getIdDate(int day, int month, int year){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        String sql =" select * form "+DatabaseHandler.TABLE_MYDATES
                + "where " + DatabaseHandler.MyDateColumn.KEY_DAY + "=" + day
                + " and " + DatabaseHandler.MyDateColumn.KEY_MONTH + "=" + month
                + " and " + DatabaseHandler.MyDateColumn.KEY_YEAR + "=" + year;
        Cursor cursor = db.rawQuery(sql,null);
        MyDate myDate = new MyDate();
        if (cursor.moveToFirst()) {
            do {
                myDate.setId(Integer.parseInt(cursor.getString(0)));
            } while (cursor.moveToNext());
        } else {
            MyDate date = new MyDate(day,month,year);
            addMyDate(date);
            Cursor cursorAgain = db.rawQuery(sql,null);
            if (cursorAgain.moveToFirst()) {
                do {
                    myDate.setId(Integer.parseInt(cursorAgain.getString(0)));
                } while (cursorAgain.moveToNext());}
        }



        return myDate.getId();
    }

}
