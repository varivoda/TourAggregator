package controller.gds;

import controller.gds.sabre.AirServiceImpl;
import controller.gds.sabre.CarServiceImpl;
import controller.gds.sabre.HotelServiceImpl;

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
    private AirServiceImpl airService;

    @EJB
    private CarServiceImpl carService;

    @EJB
    private HotelServiceImpl hotelService;

    public AirService getAirService(NameGDS name){
        return airService;
    }

    public CarService getCarService(NameGDS name){
        return carService;
    }

    public HotelService getHotelService(NameGDS name){
        return hotelService;
    }
}
