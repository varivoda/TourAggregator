package controller.gds;

import controller.gds.sabre.TransportationServiceBean;

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
        TransportationService transportationService = (TransportationServiceBean) ctx.
                lookup("java:global/TransportationServiceBean");

        return transportationService;
    }

    public RentTransportService getRentTransportService(NameGDS name) throws NamingException {

        Context ctx = new InitialContext();
        RentTransportService rentTransportService = (RentTransportService) ctx.
                lookup("java:global/RentTransportServiceBean");

        return rentTransportService;
    }

//    public HotelService getHotelService(NameGDS name){
//        return hotelService;
//    }
}
