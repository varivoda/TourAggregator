package gds;

import controller.gds.sabre.SabreProperties;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ivan on 14.04.16.
 */
public class SabrePropertiesTest {

    static SabreProperties sabreProperties;

    public static final String EXPECTED_FLIGHTS = "https://api.test.sabre.com/v2/shop/flights/fares";

    @Test
    public void testInit() throws IOException {
        sabreProperties = new SabreProperties();

        Assert.assertEquals(2, sabreProperties.getHeaders().size());
        Assert.assertEquals(EXPECTED_FLIGHTS, sabreProperties.getTransportationServiceURI());
        Assert.assertEquals("",sabreProperties.getRentTransportServiceURI());
        Assert.assertEquals("",sabreProperties.getResidentLocationServiceURI());
    }

    @Test
    public void testUpDate() throws Exception {
        sabreProperties = new SabreProperties();

        sabreProperties.upDate();

        Assert.assertEquals(2,sabreProperties.getHeaders().size());
        Assert.assertEquals(EXPECTED_FLIGHTS, sabreProperties.getTransportationServiceURI());
        Assert.assertEquals("",sabreProperties.getRentTransportServiceURI());
        Assert.assertEquals("",sabreProperties.getResidentLocationServiceURI());
    }
}