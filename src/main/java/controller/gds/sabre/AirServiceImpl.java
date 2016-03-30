package controller.gds.sabre;

import controller.gds.AirService;
import model.client.TripPreferences;
import model.tour.Transportation;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public class AirServiceImpl implements AirService {
    public List<Transportation> getFlightsByLengthOfDay(TripPreferences tripPreferences) {
        return null;
    }

    public List<Transportation> getFlightsByTwoDates(TripPreferences tripPreferences) {
        return null;
    }

    public <T> boolean bookFlight(T id) {
        return false;
    }
}
