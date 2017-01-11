package com.example.ngochieu.myappinternship.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by NgocHieu on 1/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "databaseManager";
    public static final String TABLE_MYDATES = "mydates";
    public static final String TABLE_EVENTS = "events";

    // SUPER
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // declare column the tables
    class MyDateColumn implements BaseColumns {
        static final String KEY_DAY = "day";
        static final String KEY_DAYOFWEEK = "day_of_week";
        static final String KEY_MONTH = "month";
        static final String KEY_YEAR = "year";
        static final String KEY_LUNARDAY = "lunar_day";
        static final String KEY_LUNARMONTH = "lunar_year";
        static final String KEY_LUNARYEAR = "lunar_yaer";
    }

    class EventColumn implements BaseColumns {
        static final String KEY_NAME = "name";
        static final String KEY_ADDRESS = "address";
        static final String KEY_STARTTIME = "start_time";
        static final String KEY_ENDTIME = "end_time";
        static final String KEY_STARTDATE = "start_date";
        static final String KEY_ENDDATE = "end_date";
        static final String KEY_DESCRIPTION = "desciption";
        static final String KEY_GUEST = "guest";
    }

    private static final String CREATE_MYDATES_TABLE = "CREATE TABLE " + TABLE_MYDATES + "("
            + MyDateColumn._ID + " INTEGER PRIMARY KEY," + MyDateColumn.KEY_DAY + " INTEGER,"
            + MyDateColumn.KEY_DAYOFWEEK + "TEXT,"  + MyDateColumn.KEY_MONTH + "INTEGER,"
            + MyDateColumn.KEY_YEAR + "INTEGER,"  + MyDateColumn.KEY_LUNARDAY + "INTEGER,"
            + MyDateColumn.KEY_LUNARMONTH + "INTEGER,"
            + MyDateColumn.KEY_LUNARYEAR + " INTEGER" + ")";
    private static final String DROP_MYDATES_TABLE = "DROP TABLE IF EXISTS " + TABLE_MYDATES;


    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_EVENTS + "("
            + EventColumn._ID + " INTEGER PRIMARY KEY," + EventColumn.KEY_NAME + " TEXT,"
            + EventColumn.KEY_ADDRESS + "TEXT,"  + EventColumn.KEY_STARTTIME + "TEXT,"
            + EventColumn.KEY_ENDTIME + "TEXT,"  + EventColumn.KEY_STARTDATE + "INTEGER,"
            + EventColumn.KEY_ENDDATE + "INTEGER,"  + EventColumn.KEY_GUEST + "TEXT,"
            + EventColumn.KEY_DESCRIPTION + " TEXT" + ")";
    private static final String DROP_EVENTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENTS;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_MYDATES_TABLE);
        sqLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_MYDATES_TABLE);
        sqLiteDatabase.execSQL(DROP_EVENTS_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

}
