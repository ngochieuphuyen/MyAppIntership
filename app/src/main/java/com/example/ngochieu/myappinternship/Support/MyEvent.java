package com.example.ngochieu.myappinternship.Support;

/**
 * Created by NgocHieu on 1/8/2017.
 */

public class MyEvent {
    int id;
    String nameEvent;
    String address;
    String startTime;
    String endTime;
    MyDate startDate;
    MyDate endDate;
    String guest;
    String description;

    public MyEvent() {
    }

    public MyEvent(int id, String nameEvent, String address, String startTime, String endTime, MyDate startDate, MyDate endDate, String guest, String description) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.description = description;
    }

    public MyEvent(String nameEvent, String address, String startTime, String endTime, MyDate startDate, MyDate endDate) {
        this.nameEvent = nameEvent;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MyEvent(int id, String nameEvent, String address, String startTime, String endTime, MyDate startDate, MyDate endDate) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MyEvent(int id, String nameEvent, String startTime,String endTime ,  MyDate startDate, MyDate endDate ) {
        this.endTime = endTime;
        this.id = id;
        this.startTime = startTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameEvent = nameEvent;
    }

    public MyEvent(int id, String nameEvent, String startTime, String endTime, MyDate startDate, MyDate endDate, String description) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public MyDate getStartDate() {
        return startDate;
    }

    public void setStartDate(MyDate startDate) {
        this.startDate = startDate;
    }

    public MyDate getEndDate() {
        return endDate;
    }

    public void setEndDate(MyDate endDate) {
        this.endDate = endDate;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
