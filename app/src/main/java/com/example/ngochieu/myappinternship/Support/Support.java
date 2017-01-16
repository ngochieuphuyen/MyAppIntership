package com.example.ngochieu.myappinternship.Support;

import android.content.Context;
import android.util.Log;

import com.example.ngochieu.myappinternship.Database.MyDateDAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by NgocHieu on 1/13/2017.
 */

public class Support {
    public static void addMonth(int month, int year, Context context){
        int maxDay = getMaxDay(month, year);
        MyDateDAO myDateDAO = new MyDateDAO(context);
        for (int i = 1; i <maxDay+1 ; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month-1,i);
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
    public static List<MyDate> getDateOfMonth(int month, int year, Context context){
        MyDateDAO myDateDAO = new MyDateDAO(context);
        int index = 0; // max la 42
        ArrayList<MyDate> listDate = new ArrayList<>();
        int maxDate = getMaxDay(month, year);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        int theFirstDay = calendar.get(Calendar.DAY_OF_WEEK);

        int nextMonth, nextYear;
        if (month == 12){
            nextMonth =1;
            nextYear = year+1;
        } else {
            nextMonth = month+1;
            nextYear = year;
        }
        int lastMonth = month -1, lastYear = year;
        if (month == 1){
            lastMonth =12; lastYear = year -1;
        }
        int maxDayOfLastMonth = getMaxDay(lastMonth,lastYear);

        int so_ngay = theFirstDay - 1;

            // lay 7 ngay thang truoc

            for (int i = maxDayOfLastMonth-so_ngay+1; i <= maxDayOfLastMonth ; i++) {
                int id_dateLast = myDateDAO.getIdDate(i,lastMonth,lastYear);
                listDate.add(myDateDAO.getMyDate(id_dateLast));
                index++;
            }
            // lay trong thang
            for (int i = 1; i <= maxDate ; i++) {
                int id_date = myDateDAO.getIdDate(i,month,year);
                listDate.add(myDateDAO.getMyDate(id_date));
                index++;
            }
            // lay phan con lai cua thang sau
            int nextDay =1;
            while (index<42){
                int id_next_date = myDateDAO.getIdDate(nextDay,nextMonth,nextYear);
                listDate.add(myDateDAO.getMyDate(id_next_date));
                nextDay++;
                index++;
            }


        return listDate;
    }
    public static String getFullDayOfWeek(String dayOfWeek){
        switch (dayOfWeek){
            case "Sun":
                return MyConstant.KEY_SUNDAY;
            case "Mon":
                return MyConstant.KEY_MONDAY;
            case "Tue":
                return MyConstant.KEY_TUESDAY;
            case "Wed":
                return MyConstant.KEY_WEDNESDAY;
            case "Thu":
                return MyConstant.KEY_THUDAY;
            case "Fri":
                return MyConstant.KEY_FRIDAY;
            case "Sat":
                return MyConstant.KEY_SATURDAY;
        }
        return null;
    }
    public static List<MyDate> getListDateWeek(Context context){
        ArrayList<MyDate> listWeek = new ArrayList<>();
        int index =0;
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


        return listWeek;
    }
}
