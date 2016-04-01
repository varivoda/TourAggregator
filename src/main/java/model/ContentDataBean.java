package model;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ivan on 23.12.15.
 */
@Singleton
@LocalBean
public class ContentDataBean {

    private String[] cuisineTypes;
    private String[] hotelKinds;
    private String[] restaurantTypes;
    private String[] transportKinds;
    private String[] tripDocumentsTypes;

//    static{
//        restaurantTypes = new String[]{"Bar","Barbecue","Bistro","Cafe","Coffe house","Fast food restaurant","Pancake","Pizzeria","Pub","Restaurant","Tavern"};
//        hotelKinds = new String[]{"Bed and breakfast","Boutique hotel","Business hotel","Hostel","Hotel","Lodge","Motel","Resort hotel","Ski hotel","Spa Hotel"};
//        transportKinds = new String[]{"Bus","Car","Plane","Train","Vessel"};
//        cuisineTypes = new String[]{"Italian","Korean","Russian"};
//        tripDocumentsTypes = new String[]{"International passport","Schengen visa","Visa"};
//    }
    public ContentDataBean() throws IOException, ClassNotFoundException {
        upDate();
    }

    // Updating initial data
    public boolean upDate() throws ClassNotFoundException, IOException {

        Class<ContentDataBean> dataTypesClass = (Class<ContentDataBean>) Class.forName("model.ContentDataBean");
        InputStream inputStream = dataTypesClass.getClassLoader().getResourceAsStream("initData.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        transportKinds = properties.getProperty("TransportKinds").split(",");
        cuisineTypes = properties.getProperty("CuisineTypes").split(",");
        hotelKinds = properties.getProperty("HotelKinds").split(",");
        restaurantTypes = properties.getProperty("RestaurantTypes").split(",");
        tripDocumentsTypes = properties.getProperty("TripDocumentTypes").split(",");

        return true;
    }

    public String[] getCuisineTypes() {
        return cuisineTypes;
    }

    public String[] getHotelKinds() {
        return hotelKinds;
    }

    public String[] getRestaurantTypes() {
        return restaurantTypes;
    }

    public String[] getTransportKinds() {return transportKinds; }

    public String[] getTripDocumentsTypes() {
        return tripDocumentsTypes;
    }

}
