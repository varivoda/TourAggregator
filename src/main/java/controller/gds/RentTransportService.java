package controller.gds;

import controller.exceptions.RentCarServiceException;
import model.client.DescriptionRentTransport;
import model.client.TripPreferences;
import model.tour.RentTransport;

import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public interface RentTransportService {

    List<RentTransport> getRentTransport(DescriptionRentTransport descriptionRentTransport) throws RentCarServiceException;

    <T> boolean bookRentTransport(T id) throws RentCarServiceException;
}
