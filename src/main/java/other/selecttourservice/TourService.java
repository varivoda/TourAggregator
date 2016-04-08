package other.selecttourservice;

import model.client.TripPreferences;
import model.tour.ResidentLocation;
import model.tour.Tour;

/**
 * Created by ivan on 03.03.16.
 */
public interface TourService {

    public Tour createTour(TripPreferences tripPreferences);
    public ResidentLocation serachResidentLocation(TripPreferences tripPreferences);
}
