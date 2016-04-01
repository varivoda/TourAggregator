package controller.gds.sabre;

import controller.gds.AirService;
import model.client.TripPreferences;
import model.tour.Transportation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless
@LocalBean
public class AirServiceImpl implements AirService {
    public List<Transportation> getFlightsByLengthOfDay(TripPreferences tripPreferences) {
        System.out.println("Hello< I'm AirService for Sabre. get1");
        return null;
    }

    public List<Transportation> getFlightsByTwoDates(TripPreferences tripPreferences) {
        System.out.println("Hello< I'm AirService for Sabre. get2");
        return null;
    }

    public <T> boolean bookFlight(T id) {
        System.out.println("Hello< I'm AirService for Sabre. book");
        return false;
    }
}
