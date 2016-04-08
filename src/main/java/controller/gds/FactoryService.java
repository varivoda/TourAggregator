package controller.gds;

import controller.gds.sabre.TransportationServiceBean;
import controller.gds.sabre.CarServiceImpl;
import controller.gds.sabre.HotelServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by ivan on 30.03.16.
 */
public class FactoryService {

    public static TransportationService getTransportationService(NameGDS name) throws NamingException {

        Context ctx = null;
        ctx = new InitialContext();
        TransportationService transportationService = (TransportationService) ctx.
                lookup("java:global/TourAggregator/TransportationServiceBean");

        return transportationService;
    }

//    public CarService getCarService(NameGDS name){
//        return carService;
//    }

//    public HotelService getHotelService(NameGDS name){
//        return hotelService;
//    }
}
