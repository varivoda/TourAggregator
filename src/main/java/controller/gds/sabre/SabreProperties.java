package controller.gds.sabre;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ivan on 01.04.16.
 */
@Singleton
@LocalBean
public class SabreProperties {

    private Map<String, String> headers;

    private String flightsURI;
    private String hotelsURI;
    private String carsURI;

    public SabreProperties() throws IOException {
        upDate();
    }

    // Updating initial data
    public void upDate() throws IOException {

        Class saClass = SabreProperties.class;
        ClassLoader classLoader = saClass.getClassLoader();
        InputStream inputStream = SabreProperties.class.getClassLoader().getResourceAsStream("sabreSettings.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        flightsURI = properties.getProperty("flightsURL");
        hotelsURI = properties.getProperty("hotelsURL");
        carsURI = properties.getProperty("carsURL");

        if (headers == null){
            headers = new HashMap<String, String >();
        }else{
            headers.clear();
        }

        headers.put("Authorization", properties.getProperty("accessToken"));
        headers.put("X-Originating-Ip", properties.getProperty("xOriginatingIp"));
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getFlightsURI() {
        return flightsURI;
    }

    public String getHotelsURI() {
        return hotelsURI;
    }

    public String getCarsURI() {
        return carsURI;
    }
}
