package controller.gds.sabre;

import controller.gds.CarService;
import model.client.TripPreferences;
import model.tour.RentTransport;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless
@LocalBean
public class CarServiceImpl implements CarService {
    public List<RentTransport> getCars(TripPreferences tripPreferences) {
        System.out.println("Hello< I'm CarService for Sabre. getCars");
        return null;
    }

    public <T> boolean bookCar(T id) {
        System.out.println("Hello< I'm CarService for Sabre. bookCar");
        return false;
    }
}
