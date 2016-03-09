package com.var.agregator.dto.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.ejb.Stateless;
/**
 * Created by ivan on 23.12.15.
 */
@Stateless
public class DataTypes {

    private static String[] cuisineTypes;
    private static String[] hotelKinds;
    private static String[] restaurantTypes;
    private static String[] transportKinds;
    private static String[] tripDocumentsTypes;

    static{
        restaurantTypes = new String[]{"Bar","Barbecue","Bistro","Cafe","Coffe house","Fast food restaurant","Pancake","Pizzeria","Pub","Restaurant","Tavern"};
        hotelKinds = new String[]{"Bed and breakfast","Boutique hotel","Business hotel","Hostel","Hotel","Lodge","Motel","Resort hotel","Ski hotel","Spa Hotel"};
        transportKinds = new String[]{"Bus","Car","Plane","Train","Vessel"};
        cuisineTypes = new String[]{"Italian","Korean","Russian"};
        tripDocumentsTypes = new String[]{"International passport","Schengen visa","Visa"};
    }

//    public boolean upDate(){
//        Properties property = new Properties();
//        try {
//            String userDir = System.getProperty("user.dir");
//            String fullPath = System.getProperty("user.dir") + "/../webapps/TourAgregator/src/resources/config/initData.properties";
////            property.load(getClass().getClassLoader().getResourceAsStream("initData.properties"));
//            property.load(new FileInputStream("/src/resources/config/initData.properties"));
//            transportKinds = property.getProperty("TransportKinds").split(",");
//            cuisineTypes = property.getProperty("CuisineTypes").split(",");
//            hotelKinds = property.getProperty("HotelKinds").split(",");
//            restaurantTypes = property.getProperty("RestaurantTypes").split(",");
//            tripDocumentsTypes = property.getProperty("TripDocumentTypes").split(",");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }

    public static String[] getCuisineTypes() {
        return cuisineTypes;
    }

    public static String[] getHotelKinds() {
        return hotelKinds;
    }

    public static String[] getRestaurantTypes() {
        return restaurantTypes;
    }

    public static String[] getTransportKinds() {return transportKinds; }

    public static String[] getTripDocumentsTypes() {
        return tripDocumentsTypes;
    }

}
