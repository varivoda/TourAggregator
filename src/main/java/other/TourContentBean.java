//package controller.tour;
//
//import controller.gds.*;
//import model.client.DescriptionTransportation;
//import model.client.TripPreferences;
//import model.tour.RentTransport;
//import model.tour.ResidentLocation;
//import model.tour.Transportation;
//
//import javax.ejb.EJB;
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.naming.NamingException;
//import java.util.List;
//
///**
// * Created by ivan on 31.03.16.
// * Getting and booking service
// */
//@Stateless
//@LocalBean
//public class TourContentBean {
//
//    private TransportationService transportationService;
//
////    private CarService carService;
////    private HotelService hotelService;
//
//    public void initServices(NameGDS nameGDS) throws NamingException {
//        transportationService = FactoryService.getTransportationService(nameGDS);
////        carService = FactoryService.getCarService(nameGDS);
////        hotelService = FactoryService.getHotelService(nameGDS);
//    }
//
//    public List<Transportation> getTransportation(DescriptionTransportation dt) throws Exception
//    {
//        return null;
//    }
//
//    public List<ResidentLocation> getHotels(TripPreferences tripPreferences){
//        return null;
//    }
//
//    public List<RentTransport> getCars(TripPreferences tripPreferences){
//        return null;
//    }
//
//    public <T> boolean bookFlight(T id){
//        return true;
//    }
//
//    public <T> boolean bookHotel(T id){
//        return true;
//    }
//
//    public <T> boolean bookCar(T id){
//        return true;
//    }
//}