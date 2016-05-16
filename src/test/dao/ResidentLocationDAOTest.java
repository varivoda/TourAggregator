package dao;

import controller.util.DateTimeHelper;
import controller.dao.ResidentLocationDAO;
import controller.dao.impl.ResidentLocationDAOImpl;
import model.tour.ResidentLocation;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

/**
 * Created by ivan on 20.04.16.
 */
public class ResidentLocationDAOTest  {

    private static ResidentLocationDAO residentLocationDAO = new ResidentLocationDAOImpl();

    static ResidentLocation getResidentLocation() throws ParseException {

        ResidentLocation rl = new ResidentLocation();

        BigDecimal pricePerDay = BigDecimal.valueOf(100.21);
        rl.setPrice(pricePerDay);

        String hotelKind = "hotel";
        rl.setHotelKind(hotelKind);

        String orderDateStr = "2016-06-10 00:00:00";
        rl.setOrderDate(DateTimeHelper.getDateTimeFromString(orderDateStr));

        String departureDateStr = "2016-06-17 00:00:00";
        rl.setDepartureDate(DateTimeHelper.getDateTimeFromString(departureDateStr));

        String locationCode = "LAX";
        rl.setLocationCode(locationCode);

        return rl;
    }

    @Test
    public void TestDeleteAllPersistFindAll() throws ParseException {

        residentLocationDAO.deleteAll();

        ResidentLocation rl = getResidentLocation();

        residentLocationDAO.persist(rl);

        List<ResidentLocation> residentLocations = residentLocationDAO.findAll();

        assertEquals(1, residentLocations.size());

        ResidentLocation rlReturned = residentLocations.get(0);

        System.out.println(DateTimeHelper.getStringDateTime(rlReturned.getDepartureDate()));

        assertEquals(rl.getDepartureDate(), rlReturned.getDepartureDate());
        assertEquals(rl.getLocationCode(), rlReturned.getLocationCode());
        assertEquals(rl.getOrderDate(), rlReturned.getOrderDate());
        assertEquals(rl.getPrice(), rlReturned.getPrice());
        assertEquals(rl.getHotelKind(), rlReturned.getHotelKind());

//        residentLocationDAO.deleteAll();
        residentLocationDAO.delete(rlReturned);

        residentLocations = residentLocationDAO.findAll();

        assertEquals(0, residentLocations.size());
    }


}
