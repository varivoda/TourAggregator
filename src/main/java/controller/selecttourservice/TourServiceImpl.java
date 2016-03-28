package controller.selecttourservice;

import model.client.TripPreferences;
import model.tour.ResidentLocation;
import model.tour.Tour;
import model.tour.Transportation;
import controller.utils.JsonUtil;
import controller.utils.JsonUtilImpl;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivan on 03.03.16.
 */
public class TourServiceImpl implements TourService {

    private static String URL = "https://api.test.sabre.com/v2/shop/flights/fares";

    private JsonUtil jsonUtil;
    private SimpleDateFormat sdf;

    {
        jsonUtil = new JsonUtilImpl();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public Tour createTour(TripPreferences tripPreferences) {
        return null;
    }

    public Transportation createTransportation(TripPreferences tripPreferences){

        Map<String,String> parameters = new HashMap<String, String>();
        parameters.put("origin", tripPreferences.getOriginAirportCode());
        parameters.put("destination", tripPreferences.getDestinationAirportCode());
        parameters.put("departuredate", sdf.format(tripPreferences.getDepartureDate()));
        parameters.put("lengthofstay", Long.toString((tripPreferences.getArrivalDate().getTime() - tripPreferences.getDepartureDate().getTime())/(1000*3600*24)));
        parameters.put("pointofsalecountry", "US");

        try {
            jsonUtil.getJson(URL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResidentLocation serachResidentLocation(TripPreferences tripPreferences) {
        return null;
    }
}
