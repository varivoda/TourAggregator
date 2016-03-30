package controller.gds;

import model.client.TripPreferences;
import model.tour.RentTransport;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public interface CarService {

    public List<RentTransport> getCars(TripPreferences tripPreferences);

    public <T> boolean bookCar(T id);
}
