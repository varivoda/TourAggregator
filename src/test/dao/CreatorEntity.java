package dao;

import controller.util.DateTimeHelper;
import model.tour.RentTransport;
import model.tour.ResidentLocation;
import model.tour.Transportation;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by ivan on 25.04.16.
 */
public class CreatorEntity {

    static Transportation createSimpleTransportation() throws ParseException {

        Transportation transportation = new Transportation();

        String departureDateToStr = "2016-06-10 21:00:00";
        Date departureDateTo = DateTimeHelper.getDateTimeFromString(departureDateToStr);
        transportation.setDepartureDateTo(departureDateTo);

        String deaprtureDateFromStr = "2016-06-15 10:30:00";
        Date departureDateFrom = DateTimeHelper.getDateTimeFromString(deaprtureDateFromStr);
        transportation.setDepartureDateFrom(departureDateFrom);

        BigDecimal price = BigDecimal.valueOf(290.30);
        transportation.setPrice(price);

        String transportKindStr = "Plane";
        transportation.setTransportKind(transportKindStr);

        boolean chosen = false;
        transportation.setChosen(chosen);

        String originLocationStr = "LAX";
        transportation.setOriginLocation(originLocationStr);

        String destinationLocationStr = "FAR";
        transportation.setDestinationLocation(destinationLocationStr);

        String currencyCodeStr = "USD";
        transportation.setCurrencyCode(currencyCodeStr);

        return transportation;
    }

    static ResidentLocation createSimpleResidentLocation() throws ParseException {

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

    static RentTransport createSimpleRentTransport() throws ParseException {

        RentTransport rentTransport = new RentTransport();

        BigDecimal pricePerDay = BigDecimal.valueOf(50.50);
        rentTransport.setPrice(pricePerDay);

        String orderDateStr = "2016-06-10 15:00:00";
        Date orderDate = DateTimeHelper.getDateTimeFromString(orderDateStr);
        rentTransport.setOrderDate(orderDate);

        String returnDateStr = "2016-06-15 09:00:00";
        Date returnDate = DateTimeHelper.getDateTimeFromString(returnDateStr);
        rentTransport.setReturnDate(returnDate);

        String locationCodeStr = "LAX";
        rentTransport.setLocationCode(locationCodeStr);

        return rentTransport;
    }
}
