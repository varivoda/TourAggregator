package controller.gds.sabre;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ivan on 01.04.16.
 */
@Singleton
@LocalBean
class SabrePropertiesBean {

    private String accessToken;
    private String xOriginatingIp;
    private String flightsURL;
    private String hotelsURL;
    private String carsURL;

    public SabrePropertiesBean() throws IOException {
        upDate();
    }

    // Updating initial data
    public boolean upDate() throws IOException {

        InputStream inputStream = SabrePropertiesBean.class.getClassLoader().getResourceAsStream("sabreSettings.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        accessToken = properties.getProperty("accessToken");
        xOriginatingIp = properties.getProperty("xOriginatingIp");
        flightsURL = properties.getProperty("flightsURL");
        hotelsURL = properties.getProperty("hotelsURL");
        carsURL = properties.getProperty("carsURL");
        return true;
    }

    String getAccessToken() {
        return accessToken;
    }

    String getxOriginatingIp() {
        return xOriginatingIp;
    }

    String getFlightsURL() {
        return flightsURL;
    }

    String getHotelsURL() {
        return hotelsURL;
    }

    String getCarsURL() {
        return carsURL;
    }
}
