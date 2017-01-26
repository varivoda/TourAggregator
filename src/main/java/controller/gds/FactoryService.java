package controller.gds;

import controller.gds.sabre.TransportationServiceImpl;

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

    /**
     * @param name GDS service type
     * @return transport service implementation
     * @throws NamingException if required service is not founded
     */
    public TransportationService getTransportationService(NameGDS name) throws NamingException {
        Context ctx = new InitialContext();
        return (TransportationServiceImpl) ctx.
                lookup("java:global/TourAggregator/TransportationServiceImpl");
    }

    /**
     * @param name GDS service type
     * @return rent transport service implementation
     * @throws NamingException if required service is not founded
     */
    public RentTransportService getRentTransportService(NameGDS name) throws NamingException {
        Context ctx = new InitialContext();
        return (RentTransportService) ctx.
                lookup("java:global/TourAggregator/RentTransportServiceImpl");
    }

    /**
     * @param name GDS service type
     * @return resident location service implementation
     * @throws NamingException if required service is not founded
     */
    public ResidentLocationService getResidentLocationService(NameGDS name) throws NamingException {
        Context ctx = new InitialContext();
        switch (name) {
            case SABRE:
                return (ResidentLocationService) ctx.lookup("java:global/TourAggregator/ResidentLocationSabreServiceImpl");
            case MY_WEB_SERVICE:
                return (ResidentLocationService) ctx.lookup("java:global/TourAggregator/ResidentLocationDummyServiceImpl");

            default:
                return null;
        }
    }
}
