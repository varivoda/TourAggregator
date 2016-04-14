package controller.gds.sabre;

import controller.exceptions.TransportationServiceException;
import controller.gds.TransportationService;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless(mappedName = "TransportationServiceBean")
@LocalBean
public class TransportationServiceBean implements TransportationService {

    @EJB
    SabreProperties sabreProperties;

    private Client client = ClientBuilder.newClient();

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static final String SABRE_ERROR = "Error was appeared with Sabre";


    public TransportationServiceBean() {
    }

    public List<Transportation> getTransportationsFromDescriptionTransportation(DescriptionTransportation dt) throws TransportationServiceException {

        /*
        Создаем экземпляр, соответствующий URI для сервиса
        Получаем карту заголовков из бина sabreProperties
         */
        String webTargetURI = sabreProperties.getFlightsURI();
        WebTarget flightResource = client.target(webTargetURI);
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>(sabreProperties.getHeaders());
        System.out.println();

        /*
        Устанавливем параметры запроса
        Тип запроса и заголовки
         */

        Invocation.Builder builder = flightResource.
                queryParam("origin", dt.getOriginCode()).
                queryParam("destination", dt.getDestinationCode()).
                queryParam("lengthofstay", dt.getLengthOfStay()).
                queryParam("departuredate", sdf.format(dt.getDepartDate())).
                queryParam("pointofsalecountry", dt.getPointOfSaleCode()).
                request(MediaType.TEXT_PLAIN).
                headers(headers);

        // Получаем ответ от сервиса в виде строки
        String responseStr = builder.get(String.class);

        //Парсим ответ в список Transportation
        List<Transportation> resList = null;
        try {
            resList = getTransportationFromString(responseStr);
        } catch (ParseException e) {
            throw new TransportationServiceException(SABRE_ERROR);
        } catch (org.json.simple.parser.ParseException e) {
            throw new TransportationServiceException(SABRE_ERROR);
        }

        return resList;
    }

//    public List<Transportation> getFlightsByTwoDates(DescriptionTransportation dt) {
//        System.out.println("Hello< I'm TransportationService for Sabre. get2");
//        return null;
//    }
//
//    public <T> boolean bookFlight(T id) {
//        System.out.println("Hello< I'm TransportationService for Sabre. book");
//        return false;
//    }

    private static List<Transportation> getTransportationFromString(String inStr) throws ParseException, org.json.simple.parser.ParseException {

        /*

        Парсим входную строку в JSON
         */

        JSONObject transpJson = (JSONObject) JSONValue.parseWithException(inStr);

        /*
        Зная структуру возвращаемого JSON от сервиса Sabre
        парсим его и достаем необходимую информацию для создания
        списка Transportation
         */
        String originCode = (String) transpJson.get("OriginLocation");
        String destinationCode = (String) transpJson.get("DestinationLocation");

        JSONObject fareInfo = (JSONObject)  ((JSONArray) transpJson.get("FareInfo")).get(0);

        String currencyCode = (String) fareInfo.get("CurrencyCode");
        String departureDateStr = (String) fareInfo.get("DepartureDateTime");
        String returnDateStr = (String) fareInfo.get("ReturnDateTime");

        JSONObject lowestFare = (JSONObject) fareInfo.get("LowestFare");
        String airLineCode = (String) ( (JSONArray) lowestFare.get("AirlineCodes")).get(0);
        Double fare = (Double) lowestFare.get("Fare");

        // Создаем список для возврата результата и Transportation

        List<Transportation> resList = new LinkedList<Transportation>();
        Transportation newTransportation = new Transportation();

        // Заполняем поля возвращаемого объекта
        newTransportation.setTransportKind("Plane");
        newTransportation.setChoosen(false);
        newTransportation.setCurrencyCode(currencyCode);
        newTransportation.setDestinationLocation(destinationCode);
        newTransportation.setPrice(new BigDecimal(fare));
        newTransportation.setOriginLocation(originCode);
        newTransportation.setAirlineCode(airLineCode);

        // Парсим дату
        newTransportation.setDepartureDateTo(sdf.parse(departureDateStr));
        newTransportation.setDepartureDateFrom(sdf.parse(returnDateStr));

        resList.add(newTransportation);

        return resList;


    }

    public boolean bookTransportation(Transportation transportation) throws TransportationServiceException {
        return false;
    }
}
