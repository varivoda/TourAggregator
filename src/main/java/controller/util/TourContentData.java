package controller.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ivan on 23.12.15.
 * The class Represents information about content of tourism
 */
public class TourContentData {

    private static String[] cuisineTypes;
    private static String[] hotelKinds;
    private static String[] restaurantTypes;
    private static String[] transportKinds;
    private static String[] tripDocumentsTypes;

    static {
        try {
            upDate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TourContentData(){
    }

    // Updating initial data
    public static void upDate() throws ClassNotFoundException, IOException {

        Class<TourContentData> dataTypesClass = (Class<TourContentData>) Class.forName("controller.util.TourContentData");
        InputStream inputStream = dataTypesClass.getClassLoader().getResourceAsStream("initData.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        transportKinds = properties.getProperty("TransportKinds").split(",");
        cuisineTypes = properties.getProperty("CuisineTypes").split(",");
        hotelKinds = properties.getProperty("HotelKinds").split(",");
        restaurantTypes = properties.getProperty("RestaurantTypes").split(",");
        tripDocumentsTypes = properties.getProperty("TripDocumentTypes").split(",");
    }

    public static String[] getCuisineTypesAsArray() {
        return cuisineTypes;
    }

    public static String[] getHotelKindsAsArray() {
        return hotelKinds;
    }

    public static String[] getRestaurantTypesAsArray() {
        return restaurantTypes;
    }

    public static String[] getTransportKindsAsArray() {return transportKinds; }

    public static String[] getTripDocumentsTypesAsArray() {
        return tripDocumentsTypes;
    }

}
