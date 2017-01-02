package com.example.ngochieu.myappinternship;

/**
 * Created by NgocHieu on 1/2/2017.
 */

public class Holiday {
    private String HolidayName;
    private String HolidayTime;
    private String HolidayDescribe;

    public Holiday(String holidayName, String holidayTime, String holidayDescribe) {
        HolidayName = holidayName;
        HolidayTime = holidayTime;
        HolidayDescribe = holidayDescribe;
    }

    public String getHolidayName() {
        return HolidayName;
    }

    public void setHolidayName(String holidayName) {
        HolidayName = holidayName;
    }

    public String getHolidayTime() {
        return HolidayTime;
    }

    public void setHolidayTime(String holidayTime) {
        HolidayTime = holidayTime;
    }

    public String getHolidayDescribe() {
        return HolidayDescribe;
    }

    public void setHolidayDescribe(String holidayDescribe) {
        HolidayDescribe = holidayDescribe;
    }
}
