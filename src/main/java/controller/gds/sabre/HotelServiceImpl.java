package controller.gds.sabre;

import controller.gds.HotelService;
import model.client.TripPreferences;
import model.tour.ResidentLocation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless
@LocalBean
public class HotelServiceImpl implements HotelService {
    public List<ResidentLocation> getHotels(TripPreferences tripPreferences) {
        System.out.println("Hello< I'm HotelService for Sabre. getHotels");
        return null;
    }

    public <T> boolean bookHotel(T id) {
        System.out.println("Hello< I'm AirService for Sabre. bookHotel");
        return false;
    }
}
