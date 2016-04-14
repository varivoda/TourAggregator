//package servicegds;
//
//import controller.dao.impl.ClientDAOImpl;
//import controller.gds.*;
//import model.client.TripPreferences;
//import org.junit.Before;
//import org.junit.Test;
//
//import javax.ejb.EJB;
//
///**
// * Created by ivan on 30.03.16.
// */
//public class TestWorkingFactoryService {
//
//    private TripPreferences tripPreferences;
//
//    @EJB
//    FactoryService factoryService;
//
//    @EJB
//    ClientDAOImpl daoClient;
//
//    @Before
//    public void init(){
//        tripPreferences = new TripPreferences();
//    }
//
//    @Test
//    public void test(){
//            TransportationService transportationService = factoryService.getTransportationService(NameGDS.Sabre);
//
//        transportationService.bookTransportation(1);
//        transportationService.getTransportationsFromDescriptionTransportation(tripPreferences);
//        transportationService.getFlightsByTwoDates(tripPreferences);
//
//        CarService carService = factoryService.getCarService(NameGDS.Sabre);
//
//        carService.bookCar(1);
//        carService.getCars(tripPreferences);
//
//        HotelService hotelService = factoryService.getHotelService(NameGDS.Sabre);
//
//        hotelService.bookHotel(1);
//        hotelService.getHotels(tripPreferences);
//    }
//}
