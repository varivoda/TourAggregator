package controller.gds.sabre;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ivan on 01.04.16.
 */
@Singleton
@LocalBean
class SabrePropertiesBean {

    private Map<String, String> headers;

    private String flightsURI;
    private String hotelsURI;
    private String carsURI;

    public SabrePropertiesBean() throws IOException {
        upDate();
    }

    // Updating initial data
    public boolean upDate() throws IOException {

        InputStream inputStream = SabrePropertiesBean.class.getClassLoader().getResourceAsStream("sabreSettings.properties");
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
        return true;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    String getFlightsURI() {
        return flightsURI;
    }

    String getHotelsURI() {
        return hotelsURI;
    }

    String getCarsURI() {
        return carsURI;
    }
}
