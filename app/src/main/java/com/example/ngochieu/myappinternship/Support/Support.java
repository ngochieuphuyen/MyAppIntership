package com.example.ngochieu.myappinternship.Support;

import android.content.Context;

import com.example.ngochieu.myappinternship.Database.MyDateDAO;

import java.util.Calendar;

/**
 * Created by NgocHieu on 1/13/2017.
 */

public class Support {
    public static void addMonth(int month, int year, Context context){
        int maxDay = getMaxDay(month, year);
        MyDateDAO myDateDAO = new MyDateDAO(context);
        for (int i = 1; i <maxDay+1 ; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month,i);
            int dow = calendar.get(Calendar.DAY_OF_WEEK);
            String dayOfWeek = getDayOfWeek(dow);
            MyDate myDate = new MyDate(i,dayOfWeek,month,year);
            myDateDAO.addMyDate(myDate);
        }
    }

    private static String getDayOfWeek(int dow) {
        String dayOfWeek[] = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        return dayOfWeek[dow];
    }

    private static int getMaxDay(int month, int year) {
        int maxday[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};// january to december
        if (month != 2){
            return maxday[month];
        } else {
            if (year%400 == 0 || (year%4 == 0 && year % 100 != 0)) return 29;
            else return maxday[month];
        }
    }
}
