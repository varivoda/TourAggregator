package controller.gds;

import model.client.TripPreferences;
import model.tour.Transportation;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public interface AirService {

    public List<Transportation> getFlightsByLengthOfDay(TripPreferences tripPreferences);

    public List<Transportation> getFlightsByTwoDates(TripPreferences tripPreferences);

    public <T> boolean bookFlight(T id);
}
