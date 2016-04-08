package controller.gds.sabre;

import controller.gds.TransportationService;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless
@LocalBean
public class TransportationServiceBean implements TransportationService {


    private  @EJB
    SabreProperties sabreProperties;
    private Client client = ClientBuilder.newClient();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public TransportationServiceBean() {
    }

    public List<Transportation> getFlightsByLengthOfDay(DescriptionTransportation dt) throws BadRequestException, Exception {

        WebTarget flightResource = client.target(sabreProperties.getFlightsURI());
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>(sabreProperties.getHeaders());

        Invocation.Builder builder = flightResource.queryParam("origin", dt.getOriginCode()).
                queryParam("destination", dt.getDestinationCode()).
                queryParam("lengthofstay", dt.getLengthOfStay()).
                queryParam("departuredate", sdf.format(dt.getDepartDate())).
                queryParam("pointofsalecountry", dt.getPointOfSaleCode()).
                request(MediaType.TEXT_PLAIN).
                headers(headers);

        String responseStr = builder.get(String.class);

        List<Transportation> resList = getTransportationFromString(responseStr);

        System.out.println("Hello< I'm TransportationService for Sabre. get1");
        return null;
    }

    public List<Transportation> getFlightsByTwoDates(DescriptionTransportation dt) {
        System.out.println("Hello< I'm TransportationService for Sabre. get2");
        return null;
    }

    public <T> boolean bookFlight(T id) {
        System.out.println("Hello< I'm TransportationService for Sabre. book");
        return false;
    }

    private static List<Transportation> getTransportationFromString(String inStr) throws Exception {

        List<Transportation> resList = new LinkedList<Transportation>();
        JSONObject transpJson = (JSONObject) JSONValue.parseWithException(inStr);

        // Parse inString using Json util
        String originCode = (String) transpJson.get("OriginLocation");
        String destinationCode = (String) transpJson.get("DestinationLocation");

        JSONObject fareInfo = (JSONObject)  ((JSONArray) transpJson.get("FareInfo")).get(0);
        String currencyCode = (String) fareInfo.get("CurrencyCode");
        String departureDateStr = (String) fareInfo.get("DepartureDateTime");
        String returnDateStr = (String) fareInfo.get("ReturnDateTime");
        JSONObject lowestFare = (JSONObject) fareInfo.get("LowestFare");

        String airLineCode = (String) ( (JSONArray) lowestFare.get("AirlineCodes")).get(0);
        Double fare = (Double) lowestFare.get("Fare");


        Transportation newTransportation = new Transportation();

        newTransportation.setTransportKind("Plane");
        newTransportation.setChoosen(false);
        newTransportation.setCurrencyCode(currencyCode);
        newTransportation.setDepartureDateTo(sdf.parse(departureDateStr));
        newTransportation.setDepartureDateFrom(sdf.parse(returnDateStr));
        newTransportation.setDestinationLocation(destinationCode);
        newTransportation.setPrice(new BigDecimal(fare));
        newTransportation.setOriginLocation(originCode);
        newTransportation.setAirlineCode(airLineCode);

        resList.add(newTransportation);

        return resList;


    }
}
