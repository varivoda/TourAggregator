package gds;

import controller.exceptions.RentCarServiceException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.RentTransportService;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by ivan on 25.04.16.
 */
public class FactoryServiceTest {

//    private static final String RETURN_STRING = "";

    @Test
    public void getRentTransportServiceByName() throws NamingException, RentCarServiceException {

        FactoryService factoryService = new FactoryService();

        RentTransportService rentTransportService = factoryService.getRentTransportService(NameGDS.Sabre);

        System.out.println(rentTransportService.bookCar(1));
    }
}
