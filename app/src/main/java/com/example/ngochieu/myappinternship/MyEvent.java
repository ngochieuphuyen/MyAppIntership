package com.example.ngochieu.myappinternship;

import android.support.v7.widget.RecyclerView;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class MyEvent {
    private String EventName;
    private String EventTime;
    private String EventAddress;

    public MyEvent(String eventName, String eventTime, String eventAddress) {
        EventName = eventName;
        EventTime = eventTime;
        EventAddress = eventAddress;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public String getEventAddress() {
        return EventAddress;
    }

    public void setEventAddress(String eventAddress) {
        EventAddress = eventAddress;
    }
}
