package gds;

import controller.gds.sabre.TransportationServiceBean;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ivan on 04.04.16.
 */
public class TestResponseStringTransportationService {

    private static TransportationServiceBean ts;
    private static SimpleDateFormat sdf;

    @BeforeClass
    public static void init(){
        ts = new TransportationServiceBean();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    }

    @Test
    public void  test(){
        DescriptionTransportation dt = new DescriptionTransportation();

        dt.setOriginCode("JFK");
        dt.setDestinationCode("LAX");
        dt.setLengthOfStay(5);
        dt.setPointOfSaleCode("US");

        try {
            dt.setDepartDate(sdf.parse("2016-05-01 00-00-00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dt.setArrivalDate(null);

        dt.setLocationCountry(null);
        dt.setMinFare(null);
        dt.setMaxFare(null);

        List<Transportation> transportationList = null;

        try {
            transportationList = ts.getFlightsByLengthOfDay(dt);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("System error");
        }

    }
}
