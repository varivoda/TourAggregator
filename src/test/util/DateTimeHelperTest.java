package util;

import controller.util.DateTimeHelper;
import org.junit.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by ivan on 20.04.16.
 */
public class DateTimeHelperTest {

    @Test
    public void TestToDate() throws ParseException {

        String dateStr1 = "2016-06-01";
        String dateTimeStr1 = "2016-07-02 12:09:10";

        Date date1 = DateTimeHelper.getDateFromString(dateStr1);
        Date dateTime1 = DateTimeHelper.getDateTimeFromString(dateTimeStr1);
//        Date dateTimeFromDate = DateTimeHelper.getDateTimeFromString(dateStr1);
        Date dateFromDateTime = DateTimeHelper.getDateFromString(dateTimeStr1);

        System.out.println("date: " + date1);
        System.out.println("date time: " + dateTime1);
//        System.out.println("date time from date: " + dateTimeFromDate);
        System.out.println("date from date time: " + dateFromDateTime);

        String dateStr1Ret = DateTimeHelper.getStringDate(date1);
        String dateTimeStr1Ret = DateTimeHelper.getStringDateTime(dateTime1);

        assertEquals(dateStr1, dateStr1Ret);
        assertEquals(dateTimeStr1, dateTimeStr1Ret);

    }

    @Test(expected = ParseException.class)
    public void TestParseException() throws ParseException {
        String dateStr1 = "2016-06-01a";
        String dateTimeStr1 = "2016-07-0s2 12:09:10";

        Date date1 = DateTimeHelper.getDateFromString(dateStr1);
        Date dateTime1 = DateTimeHelper.getDateTimeFromString(dateTimeStr1);

        System.out.println("date: " + date1);
        System.out.println("date time: " + dateTime1);

        String dateStr1Ret = DateTimeHelper.getStringDate(date1);
        String dateTimeStr1Ret = DateTimeHelper.getStringDateTime(dateTime1);

        assertEquals(dateStr1, dateStr1Ret);
        assertEquals(dateTimeStr1, dateTimeStr1Ret);
    }
}
