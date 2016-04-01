package controller.gds;

import controller.gds.sabre.AirServiceImpl;
import controller.gds.sabre.CarServiceImpl;
import controller.gds.sabre.HotelServiceImpl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by ivan on 30.03.16.
 */
@Singleton
@LocalBean
public class FactoryService {

    @EJB
    private AirServiceImpl airService;

    @EJB
    private CarServiceImpl carService;

    @EJB
    private HotelServiceImpl hotelService;

    @PostConstruct
    public void init(){}



    public AirService getAirService(NameGDS name){
//        Context ctx = null;
//        try {
//            ctx = new InitialContext();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        try {
//            AirService airService1 = (AirService) ctx.lookup("java:global/TourAgregator/airService");
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
