package com.example.ngochieu.myappinternship;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class MyEvent {
    int id;
    MyDate date;
    String name;
    String address;
    String start;
    String end;

    public MyEvent(int id, MyDate date, String name, String address, String start, String end) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.start = start;
        this.end = end;
    }

    public MyEvent(int id, MyDate date, String name, String start, String end) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.start = start;
        this.end = end;
    }
}
