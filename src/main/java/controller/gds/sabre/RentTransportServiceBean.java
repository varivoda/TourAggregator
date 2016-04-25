package controller.gds.sabre;

import controller.exceptions.RentCarServiceException;
import controller.gds.RentTransportService;
import model.client.DescriptionRentTransport;
import model.tour.RentTransport;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 * Класс предназначен для взаимодействия с сервисом по аренде автомобилей
 */
@Stateless(mappedName = "RentTransportServiceBean")
@LocalBean
public class RentTransportServiceBean implements RentTransportService {

    //For test
//    @EJB
//    SabreProperties sabreProperties;


    //Клиент для взаимодействия с RESTfull сервисами
    private Client client = ClientBuilder.newClient();

    //Формат времени для сервиса по бронированию транспорта Sabre
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd'T'hh:mm");

    //Сообщение об ошибке при взаимодейтсвии с Sabre
    public static final String SABRE_ERROR = "Error was appeared with Sabre";
    public static final int STATUS_OK = 200;

    public List<RentTransport> getRentTransport(DescriptionRentTransport descriptionRentTransport) throws RentCarServiceException {

        //Test
        SabreProperties sabreProperties = null;
        try {
            sabreProperties = new SabreProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //?Test

         /*
        Создаем экземпляр, соответствующий URI для сервиса
        Получаем карту заголовков из бина sabreProperties
         */
        String webTargetURI = sabreProperties.getRentTransportServiceURI();
        WebTarget rentTransportResource = client.target(webTargetURI);
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>(sabreProperties.getHeaders());

        //Конвертируем в Json экземпляр descriptionRentTransport
        JSONObject rentJson = getRentTransportJson(descriptionRentTransport);

        //Выполняем запрос к сервису
        Invocation.Builder builder =  rentTransportResource.request(MediaType.TEXT_PLAIN_TYPE).headers(headers);
        Response response = builder.post(Entity.json(rentJson.toJSONString()));

        //Получаем статус и содердимое ответа от сервиса
        int status = response.getStatus();
        String responseStr = response.readEntity(String.class);

        // Если статус не ОК (200) бросаем исключение с описанием ошибки
        if (status != STATUS_OK){
            throw new RentCarServiceException("Ошибка при выполнении запроса \n" +
                    "status: " + status +
                    "\nresponse: " + responseStr);
        }

        //Получаем список транспорта из стоки ответа
        try {
            List<RentTransport> rentTransportList = getRentTransportListFromString(responseStr);
        } catch (ParseException e) {
            throw new RentCarServiceException(SABRE_ERROR);
        }

        System.out.println();

        return null;
    }

    public <T> boolean bookCar(T id) throws RentCarServiceException {
        System.out.println("Hello< I'm RentTransportService for Sabre. bookCar");
        return false;
    }

    private List<RentTransport> getRentTransportListFromString(String inputStr) throws ParseException {

        //Парсим входную строку в JSON
        JSONObject inputJson = (JSONObject) JSONValue.parseWithException(inputStr);
        System.out.println();

        /*
        Зная структуру возвращаемого JSON от сервиса Sabre
        парсим его и достаем необходимую информацию для создания списка Transportation
         */

        //TODO здесь закончил


        return null;
    }

    // Метод формирует Json для запроса к серверу по поределенным правилам
    private JSONObject getRentTransportJson(DescriptionRentTransport drt){

        String pickUpDateTimeStr = simpleDateFormat.format(drt.getPickUpDateTime());
        String returnDateTimeStr = simpleDateFormat.format(drt.getReturnDateTime());

        JSONObject pickUpLocation = new JSONObject();
        pickUpLocation.put("LocationCode", drt.getLocationCode());

        JSONObject vehRentalCore = new JSONObject();
        vehRentalCore.put("PickUpDateTime", pickUpDateTimeStr);
        vehRentalCore.put("ReturnDateTime", returnDateTimeStr);
        vehRentalCore.put("PickUpLocation", pickUpLocation);

        JSONObject vehAvailRQCore = new JSONObject();
        vehAvailRQCore.put("QueryType", "Shop");
        vehAvailRQCore.put("VehRentalCore", vehRentalCore);

        JSONObject oTA_VehAvailRateRQ = new JSONObject();
        oTA_VehAvailRateRQ.put("VehAvailRQCore", vehAvailRQCore);

        JSONObject returnObject = new JSONObject();
        returnObject.put("OTA_VehAvailRateRQ", oTA_VehAvailRateRQ);

        return returnObject;

    }

}
