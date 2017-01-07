package com.example.ngochieu.myappinternship;

/**
 * Created by NgocHieu on 1/7/2017.
 */

public class MyDate {
    int id;
    String dayOfSun;
    String dayOfMoon;
    String dayOfWeek;
    int month;
    int year;

    public MyDate(int id, String day, String dayOfWeek, int month, int year) {// day of sun
        this.id = id;
        this.dayOfSun = day;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
    }

    public MyDate(int id, String day, String dayOfMoon, String dayOfWeek, int month, int year) { //both day of sun and day of moon
        this.id = id;
        this.dayOfSun = day;
        this.dayOfMoon = dayOfMoon;
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.year = year;
    }
}

