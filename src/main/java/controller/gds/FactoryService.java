package controller.gds;

import controller.gds.sabre.TransportationServiceImpl;
import controller.gds.sabre.CarServiceImpl;
import controller.gds.sabre.HotelServiceImpl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Created by ivan on 30.03.16.
 */
@Singleton
@LocalBean
public class FactoryService {

    @EJB
    private TransportationServiceImpl airService;

    @EJB
    private CarServiceImpl carService;

    @EJB
    private HotelServiceImpl hotelService;

    @PostConstruct
    public void init(){}



    public TransportationService getAirService(NameGDS name){
//        Context ctx = null;
//        try {
//            ctx = new InitialContext();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        try {
//            TransportationService airService1 = (TransportationService) ctx.lookup("java:global/TourAgregator/airService");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }

        return airService;
    }

    public CarService getCarService(NameGDS name){
        return carService;
    }

    public HotelService getHotelService(NameGDS name){
        return hotelService;
    }
}
