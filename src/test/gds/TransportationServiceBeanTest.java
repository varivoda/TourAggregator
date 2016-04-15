package gds;

import controller.exceptions.TransportationServiceException;
import controller.gds.sabre.TransportationServiceBean;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ivan on 14.04.16.
 */
public class TransportationServiceBeanTest {

    private static TransportationServiceBean ts;
    private static SimpleDateFormat sdf;

    @Before
    public void setUp() throws Exception {
        ts = new TransportationServiceBean();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetTransportationsFromDescriptionTransportation() throws Exception {

        DescriptionTransportation dt = new DescriptionTransportation();

        dt.setOriginCode("JFK");
        dt.setDestinationCode("LAX");
        dt.setLengthOfStay(5);
        dt.setPointOfSaleCode("US");

        try {
            dt.setDepartDate(sdf.parse("2016-06-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dt.setArrivalDate(null);
        dt.setLocationCountry(null);
        dt.setMinFare(null);
        dt.setMaxFare(null);

        List<Transportation> transportationList = null;

        transportationList = ts.getTransportationsFromDescriptionTransportation(dt);

        Assert.assertEquals(1,transportationList.size());

    }

    @Test(expected = TransportationServiceException.class)
    public void testThrowTransportationServiceExceptionBecauseIncorrectDate() throws TransportationServiceException{
        DescriptionTransportation dt = new DescriptionTransportation();

        dt.setOriginCode("JFK");
        dt.setDestinationCode("LAX");
        dt.setLengthOfStay(5);
        dt.setPointOfSaleCode("US");

        try {
            dt.setDepartDate(sdf.parse("2016-04-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dt.setArrivalDate(null);
        dt.setLocationCountry(null);
        dt.setMinFare(null);
        dt.setMaxFare(null);

        List<Transportation> transportationList = null;

        transportationList = ts.getTransportationsFromDescriptionTransportation(dt);
    }

    @Test(expected = TransportationServiceException.class)
    public void testThrowTransportationServiceExceptionBecauseIncorrectCode() throws TransportationServiceException{
        DescriptionTransportation dt = new DescriptionTransportation();

        dt.setOriginCode("JFK");
        dt.setDestinationCode("LA");
        dt.setLengthOfStay(5);
        dt.setPointOfSaleCode("US");

        try {
            dt.setDepartDate(sdf.parse("2016-06-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dt.setArrivalDate(null);
        dt.setLocationCountry(null);
        dt.setMinFare(null);
        dt.setMaxFare(new BigDecimal(10));

        List<Transportation> transportationList = null;

        transportationList = ts.getTransportationsFromDescriptionTransportation(dt);

    }
}