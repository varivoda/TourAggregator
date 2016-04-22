package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ivan on 20.04.16.
 */
public class DateTimeHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATE_TIME_FORMAT);

    public static Date getDateFromString(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

    public static Date getDateTimeFromString(String dateTimeStr) throws ParseException {
        return dateTimeFormat.parse(dateTimeStr);
    }

    public static String getStringDate(Date date){
        return dateFormat.format(date);
    }

    public static String getStringDateTime(Date dateTime){
        return dateTimeFormat.format(dateTime);
    }



}
