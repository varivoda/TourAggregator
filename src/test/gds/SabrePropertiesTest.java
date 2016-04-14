package gds;

import controller.gds.sabre.SabreProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

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
        Assert.assertEquals(EXPECTED_FLIGHTS, sabreProperties.getFlightsURI());
        Assert.assertEquals("",sabreProperties.getCarsURI());
        Assert.assertEquals("",sabreProperties.getHotelsURI());
    }

    @Test
    public void testUpDate() throws Exception {
        sabreProperties = new SabreProperties();

        sabreProperties.upDate();

        Assert.assertEquals(2,sabreProperties.getHeaders().size());
        Assert.assertEquals(EXPECTED_FLIGHTS, sabreProperties.getFlightsURI());
        Assert.assertEquals("",sabreProperties.getCarsURI());
        Assert.assertEquals("",sabreProperties.getHotelsURI());
    }
}