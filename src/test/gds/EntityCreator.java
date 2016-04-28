package gds;

import model.client.DescriptionRentTransport;

import java.text.ParseException;
import java.util.Date;

import static controller.util.DateTimeHelper.*;
/**
 * Created by ivan on 25.04.16.
 *
 */
public class EntityCreator {

    static DescriptionRentTransport createSimpleDescriptorRentTransport() throws ParseException {

        DescriptionRentTransport drt = new DescriptionRentTransport();


        Date pickUpDateTime = getDateTimeFromString("2016-06-01 12:00:00");
        Date returnDateTime = getDateTimeFromString("2016-06-07 10:30:00");

        drt.setLocationCode("DFW");
        drt.setPickUpDateTime(pickUpDateTime);
        drt.setReturnDateTime(returnDateTime);

        return drt;
    }
}
