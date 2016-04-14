package controller.gds;

import model.client.TripPreferences;
import model.tour.RentTransport;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public interface CarService {

    List<RentTransport> getCars(TripPreferences tripPreferences);

    <T> boolean bookCar(T id);
}
