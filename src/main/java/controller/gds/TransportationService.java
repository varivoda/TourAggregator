package controller.gds;

import model.client.DescriptionTransportation;
import model.client.TripPreferences;
import model.tour.Transportation;
import org.json.simple.parser.ParseException;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
public interface TransportationService {

    public List<Transportation> getFlightsByLengthOfDay(DescriptionTransportation dt) throws Exception;

    public List<Transportation> getFlightsByTwoDates(DescriptionTransportation dt);

    public <T> boolean bookFlight(T id);

}
