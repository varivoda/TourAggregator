package controller.gds;

import model.client.TripPreferences;
import model.tour.ResidentLocation;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 * Service for getting information about Hotels and booking it
 */
public interface HotelService {

    public List<ResidentLocation> getHotels(TripPreferences tripPreferences);

    public <T> boolean bookHotel(T id);
}
