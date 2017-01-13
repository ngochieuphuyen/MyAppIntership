package com.example.ngochieu.myappinternship.Support;

import java.util.ArrayList;

/**
 * Created by NgocHieu on 1/7/2017.
 */

public class MyDate {
    int id;
    int day;
    String  dayOfWeek;
    int month;
    int year;
    int lunarDay;
    int lunarMonth;
    int lunarYear;

    public MyDate() {
    }

    public MyDate(int id, int day, int month, int lunarDay, int lunarMonth, String dayOfWeek) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.lunarDay = lunarDay;
        this.lunarMonth = lunarMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public MyDate(int id, int day, String dayOfWeek, int month, int year) {// khi co trong co csdl
        this.id = id;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
        // auto set lunar
        autoSetLunar(day, month, year);
    }

    public MyDate( int day, String dayOfWeek, int month, int year) {// set khi chua co trong csdl
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
        // auto set lunar
        autoSetLunar(day, month, year);
    }

    public MyDate(int id, int day, String dayOfWeek, int month, int year, int lunarDay, int lunarMonth, int lunarYear) {// set full
        this.id = id;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
        this.lunarDay = lunarDay;
        this.lunarMonth = lunarMonth;
        this.lunarYear = lunarYear;
    }

    public MyDate(int id, int day, int lunarDay) {
        this.id = id;
        this.day = day;
        this.lunarDay = lunarDay;
    }

    public MyDate(int id, int day) {
        this.id = id;
        this.day = day;
    }

    public MyDate(int id, int day, String dayOfWeek, int month) {
        this.id = id;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
    }

    public MyDate(int id, int day,  int month, int year) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        // auto set attributes remain
        autoSetLunar(day, month, year);


    }
    private void autoSetLunar(int day, int month, int year){
        Lunar lunar = new Lunar();
        ArrayList list = lunar.convertSolar2Lunar(day, month, year);
        this.lunarDay = (int) list.get(0);
        this.lunarMonth = (int) list.get(1);
        this.lunarYear = (int) list.get(2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLunarDay() {
        return lunarDay;
    }

    public void setLunarDay(int lunarDay) {
        this.lunarDay = lunarDay;
    }

    public int getLunarMonth() {
        return lunarMonth;
    }

    public void setLunarMonth(int lunarMonth) {
        this.lunarMonth = lunarMonth;
    }

    public int getLunarYear() {
        return lunarYear;
    }

    public void setLunarYear(int lunarYear) {
        this.lunarYear = lunarYear;
    }

}

