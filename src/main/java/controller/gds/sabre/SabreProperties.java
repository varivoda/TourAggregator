package controller.gds.sabre;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ivan on 01.04.16.
 */
class SabreProperties {

    private static Map<String, String> headers;

    private static String flightsURI;
    private static String hotelsURI;
    private static String carsURI;

    static {
        try {
            upDate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Updating initial data
    public static void upDate() throws IOException {

        InputStream inputStream = SabreProperties.class.getClassLoader().getResourceAsStream("src/sabreSettings.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        flightsURI = properties.getProperty("flightsURL");
        hotelsURI = properties.getProperty("hotelsURL");
        carsURI = properties.getProperty("carsURL");

        if (headers == null){
            headers = new HashMap<String, String>();
        }else{
            headers.clear();
        }

        headers.put("Authorization", properties.getProperty("accessToken"));
        headers.put("X-Originating-Ip", properties.getProperty("xOriginatingIp"));
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    static String getFlightsURI() {
        return flightsURI;
    }

    static String getHotelsURI() {
        return hotelsURI;
    }

    static String getCarsURI() {
        return carsURI;
    }
}
