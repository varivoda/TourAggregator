package com.var.agregator.dto.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ivan on 23.12.15.
 */
public class DataTypes {

    private String[] cuisineTypes;
    private String[] hotelKinds;
    private String[] restaurantTypes;
    private String[] transportKinds;
    private String[] tripDocumentsTypes;

    public DataTypes(){ }

    public boolean upDate() throws IOException {
        Properties property = new Properties();
        property.load(new FileInputStream(System.getProperty("user.dir") + "/src/resources/config/initdata.properties"));

        transportKinds = property.getProperty("TransportKinds").split(",");
        cuisineTypes = property.getProperty("CuisineTypes").split(",");
        hotelKinds = property.getProperty("HotelKinds").split(",");
        restaurantTypes = property.getProperty("RestaurantTypes").split(",");
        tripDocumentsTypes = property.getProperty("TripDocumentTypes").split(",");

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

    public String[] getTransportKinds() {
        return transportKinds;
    }

    public String[] getTripDocumentsTypes() {
        return tripDocumentsTypes;
    }

}
