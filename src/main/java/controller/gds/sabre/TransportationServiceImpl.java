package controller.gds.sabre;

import controller.exceptions.TransportationServiceException;
import controller.gds.TransportationService;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import javax.ejb.EJB;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 * Данный класс реализует интерфейс TransportationService и предназначен для работы
 * с транспортным контентом посредством взаимодействия с GDS SABRE
 */
@Stateless(mappedName = "TransportationServiceImpl")
@LocalBean
public class TransportationServiceImpl implements TransportationService {

    //предоставляет информацию необходимую для взаимодействия с SABRE

    //TEST BEGIN
    @EJB
    SabreProperties sabreProperties; //TODO TEST
    // TEST END


    //Клиент для взаимодействия с RESTfull сервисами
    private Client client = ClientBuilder.newClient();
    //Предназначен для конвертирования строк и даты
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //Сообщение об ошибке при взаимодейтсвии с SABRE
    public static final String SABRE_ERROR = "Error was appeared with SABRE";
    public static final int STATUS_OK = 200;


    public TransportationServiceImpl() {
    }

    /*
    Метод получает на вход описание транспортного контента в виде экзмемпляра класса DescriptionTransportation
    Подключается к сервису, запрашивает информацию по данному набору данных и возвращает список даных, описывающих
    параметры поездки.
    Если ничего не найдено или возникла ошибка при взаимодействии с сревсисом выкидывает TransportationServiceException
    с описанием проблемы
     */
    public List<Transportation> getTransportationsFromDescriptionTransportation(DescriptionTransportation dt) throws TransportationServiceException {

        // TEST BEGIN
//        SabreProperties sabreProperties = null;
//        try {
//            sabreProperties = new SabreProperties();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // TEST END

        /*
        Создаем экземпляр, соответствующий URI для сервиса
        Получаем карту заголовков из бина sabreProperties
         */
        String webTargetURI = sabreProperties.getTransportationServiceURI();
        WebTarget flightResource = client.target(webTargetURI);
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>(sabreProperties.getHeaders());
        System.out.println();

        /*
        Устанавливем параметры запроса. Тип запроса и заголовки
         */

        flightResource =  flightResource.
                queryParam("origin", dt.getOriginCode()).
                queryParam("destination", dt.getDestinationCode()).
                queryParam("lengthofstay", dt.getLengthOfStay()).
                queryParam("departuredate", sdf.format(dt.getDepartDate())).
                queryParam("pointofsalecountry", dt.getPointOfSaleCode());

        if (dt.getMaxFare() != null){
            flightResource = flightResource.queryParam("maxfare", dt.getMaxFare().toString());
        }
        Invocation.Builder builder = flightResource.
                request(MediaType.TEXT_PLAIN).
                headers(headers);

        // Выполняем запрос и получаем статус запроса и ответ в виде строки
        Response response = builder.get();
        int status = response.getStatus();
        String responseStr = response.readEntity(String.class);

        // Если статус не ОК (200) бросаем исключение с описанием ошибки
        if (status != STATUS_OK){
            throw new TransportationServiceException("Ошибка при выполнении запроса \n" +
                                                     "status: " + status +
                                                     "\nresponse: " + responseStr);
        }

        /*
        Парсим ответ в список Transportation.
         При возникновении ошибок парсеров генерируем исключение с описанием ошибки
        */
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

    /*
    Метод парсит полученную строку от сервиса SABRE к списку Transportation
    зная структуру получеенного json
     */
    private static List<Transportation> getTransportationFromString(String inStr) throws ParseException, org.json.simple.parser.ParseException {

        //Парсим входную строку в JSON
        JSONObject transpJson = (JSONObject) JSONValue.parseWithException(inStr);

        /*
        Зная структуру возвращаемого JSON от сервиса SABRE
        парсим его и достаем необходимую информацию для создания списка Transportation
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
        newTransportation.setId(0);
        newTransportation.setTransportKind("Plane");
        newTransportation.setChosen(false);
        newTransportation.setCurrencyCode(currencyCode);
        newTransportation.setDestinationLocation(destinationCode);
        newTransportation.setPrice(BigDecimal.valueOf(fare));
        newTransportation.setOriginLocation(originCode);
        newTransportation.setAirlineCode(airLineCode);

        // Парсим дату
        newTransportation.setDepartureDateTo(sdf.parse(departureDateStr));
        newTransportation.setDepartureDateFrom(sdf.parse(returnDateStr));

        resList.add(newTransportation);

        return resList;
    }

    public boolean bookTransportation(Transportation transportation) throws TransportationServiceException {

        String webTargetURI = sabreProperties.getTransportationBookServiceURI();
        WebTarget transportResource = client.target(webTargetURI);

        Invocation.Builder builder = transportResource.queryParam("id", transportation.getId()).request(MediaType.TEXT_PLAIN_TYPE);

        Response response = builder.get();

        if (response.getStatus() == 200){
            return true;
        }

        throw new TransportationServiceException();
    }
}
