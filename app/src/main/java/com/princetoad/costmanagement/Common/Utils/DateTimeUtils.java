package com.princetoad.costmanagement.Common.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by PRINCE D. TOAD on 4/3/2017.
 */

public class DateTimeUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");

    public static boolean checkDateFormat(String date) {
        try {
            formatter.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static Date convertToDate(String date) {
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertToString(Date date) {
        return formatter.format(date);
    }

    public static String convertToString(long date) {
        return formatter.format(new Date(date));
    }

    public static String getCurrentDay() {
        return formatter.format(new Date());
    }

}
