package controller.gds;

import controller.gds.sabre.TransportationServiceImpl;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Manager GDS systems. Finding the required service with specified type
 */
// TODO: 27.01.17 create interface with implementations for each GDS
@LocalBean
@Singleton
public class FactoryService {

    /**
     * @param name GDS service type
     * @return transport service implementation
     * @throws NamingException if required service is not founded
     */
    public TransportationService getTransportationService(NameGDS name) throws NamingException {
        return (TransportationServiceImpl) new InitialContext().
                lookup("java:global/TourAggregator/TransportationServiceImpl");
    }

    /**
     * @param name GDS service type
     * @return rent transport service implementation
     * @throws NamingException if required service is not founded
     */
    public RentTransportService getRentTransportService(NameGDS name) throws NamingException {
        return (RentTransportService) new InitialContext().
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
