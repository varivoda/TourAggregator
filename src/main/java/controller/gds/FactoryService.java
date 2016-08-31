package controller.gds;

import controller.gds.sabre.TransportationServiceImpl;
import model.tour.ResidentLocation;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by ivan on 30.03.16.
 * Класс предназначен для продоставления нужной реализации одного
 * из сервисов по названию GDS
 */
@LocalBean
@Singleton
public class FactoryService {

    /*
    Предоставляет реализацию сервиса для работы с транспортным контентом
    Генерирует исключение NamingException, если в jndi нет бина с запрашиваемым именем
     */
    public TransportationService getTransportationService(NameGDS name) throws NamingException {

        Context ctx = new InitialContext();
        TransportationService transportationService = (TransportationServiceImpl) ctx.
                lookup("java:global/TourAggregator/TransportationServiceImpl");

        return transportationService;
    }

    public RentTransportService getRentTransportService(NameGDS name) throws NamingException {

        Context ctx = new InitialContext();
        RentTransportService rentTransportService = (RentTransportService) ctx.
                lookup("java:global/TourAggregator/RentTransportServiceImpl");

        return rentTransportService;
    }

    public ResidentLocationService getResidentLocationService(NameGDS name) throws NamingException {

        Context ctx = new InitialContext();

        switch (name){
            case SABRE:
                 return (ResidentLocationService) ctx.lookup("java:global/TourAggregator/ResidentLocationSabreServiceImpl");
            case MY_WEB_SERVICE:
                 return  (ResidentLocationService) ctx.lookup("java:global/TourAggregator/ResidentLocationDummyServiceImpl");

            default:
                return null;
        }
    }
}
