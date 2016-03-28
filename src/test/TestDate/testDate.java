package TestDate;

import controller.selecttourservice.TourService;
import controller.selecttourservice.TourServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ivan on 09.03.16.
 */
public class testDate {

    @Test
    public void test(){
        Date date = new Date();
        Date date1 = null;
        String strDate = date.toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date1 = simpleDateFormat.parse("2016-03-10 17:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long lenghtDays = (date1.getTime() - date.getTime())/(1000*3600*24);

        strDate = simpleDateFormat.format(date);
        System.out.println();

        TourService ts = new TourServiceImpl();
//        ts.createTour()

    }
}
