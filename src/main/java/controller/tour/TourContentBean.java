package controller.tour;

import controller.gds.*;
import model.client.TripPreferences;
import model.tour.RentTransport;
import model.tour.ResidentLocation;
import model.tour.Transportation;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 31.03.16.
 * Getting and booking service
 */
@Stateless
@LocalBean
public class TourContentBean {

    private TransportationService transportationService;
    private CarService carService;
    private HotelService hotelService;
    @EJB private FactoryService factoryService;

    public void initServices(NameGDS nameGDS){
        transportationService = factoryService.getAirService(nameGDS);
        carService = factoryService.getCarService(nameGDS);
        hotelService = factoryService.getHotelService(nameGDS);
    }

    public List<Transportation> getFlights(TripPreferences tripPreferences){
        return null;
    }

    public List<ResidentLocation> getHotels(TripPreferences tripPreferences){
        return null;
    }

    public List<RentTransport> getCars(TripPreferences tripPreferences){
        return null;
    }

    public <T> boolean bookFlight(T id){
        return true;
    }

    public <T> boolean bookHotel(T id){
        return true;
    }

    public <T> boolean bookCar(T id){
        return true;
    }
}
