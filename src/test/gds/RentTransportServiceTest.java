package gds;

import controller.exceptions.RentCarServiceException;
import controller.gds.RentTransportService;
import controller.gds.sabre.RentTransportServiceImpl;
import model.client.DescriptionRentTransport;
import static gds.EntityCreator.*;

import model.tour.RentTransport;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

/**
 * Created by ivan on 25.04.16.
 */
public class RentTransportServiceTest {

    private static RentTransportService rentTransportService = new RentTransportServiceImpl();

    @Test
    public void test() throws ParseException, RentCarServiceException {

        DescriptionRentTransport drt = createSimpleDescriptorRentTransport();

        List<RentTransport> rentTransportList =  rentTransportService.getRentTransport(drt);

    }
}
