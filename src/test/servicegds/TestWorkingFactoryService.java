package servicegds;

import controller.dao.impl.DaoClientImpl;
import controller.gds.*;
import model.client.Client;
import model.client.TripPreferences;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;

/**
 * Created by ivan on 30.03.16.
 */
public class TestWorkingFactoryService {

    private TripPreferences tripPreferences;

    @EJB
    FactoryService factoryService;

    @EJB
    DaoClientImpl daoClient;

    @Before
    public void init(){
        tripPreferences = new TripPreferences();
    }

    @Test
    public void test(){
            AirService airService = factoryService.getAirService(NameGDS.Sabre);

        airService.bookFlight(1);
        airService.getFlightsByLengthOfDay(tripPreferences);
        airService.getFlightsByTwoDates(tripPreferences);

        CarService carService = factoryService.getCarService(NameGDS.Sabre);

        carService.bookCar(1);
        carService.getCars(tripPreferences);

        HotelService hotelService = factoryService.getHotelService(NameGDS.Sabre);

        hotelService.bookHotel(1);
        hotelService.getHotels(tripPreferences);
    }
}
