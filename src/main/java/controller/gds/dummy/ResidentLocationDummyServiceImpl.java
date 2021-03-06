package controller.gds.dummy;

import controller.exceptions.ResidentLocationServiceException;
import controller.gds.ResidentLocationService;
import model.client.DescriptionResidentLocation;
import model.tour.ResidentLocation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Stateless(mappedName = "ResidentLocationDummyServiceImpl")
@LocalBean
public class ResidentLocationDummyServiceImpl implements ResidentLocationService {

    // TODO: 27.01.17 move webserice properties to property
    public static final String RESIDENT_LOCATION_URI = "http://52.34.224.192:8090/webservice/TourService/ResidentLocation";
    public static final String BOOK_URI = "http://52.34.224.192:8090/webservice/TourService/ResidentLocation/book";

    // TODO: 27.01.17 use localDate
    private static SimpleDateFormat simpleDateFormatTo = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat simpleDateFormatFrom = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

    private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    private Client client = ClientBuilder.newClient();

    public List<ResidentLocation> getResidentLocations(DescriptionResidentLocation drl) throws ResidentLocationServiceException {

        WebTarget webTarget = client.target(RESIDENT_LOCATION_URI);

        Invocation.Builder builder = webTarget.
                queryParam("locationCode", drl.getLocationCode()).
                queryParam("orderDate", simpleDateFormatTo.format(drl.getOrderDate())).
                queryParam("departureDate", simpleDateFormatTo.format(drl.getDepartureDate())).
                queryParam("maxFare", drl.getMaxFare()).
                request(" application/xml");

        // Выполняем запрос и получаем статус запроса и ответ в виде строки
        Response response = builder.get();

        int status = response.getStatus();
        String responseStr = response.readEntity(String.class);


        // Если статус не ОК (200) бросаем исключение с описанием ошибки
        if (status != 200) {
            throw new ResidentLocationServiceException("Ошибка при выполнении запроса \n" +
                    "status: " + status +
                    "\nresponse: " + responseStr);
        }

        return parseResidentLocationListFromXMLString(responseStr);
    }

    public boolean bookResidentLocation(ResidentLocation rl) throws ResidentLocationServiceException {

        WebTarget rentTransportResource = client.target(BOOK_URI);

        Invocation.Builder builder = rentTransportResource.queryParam("id", rl.getId()).request(MediaType.TEXT_PLAIN_TYPE);

        Response response = builder.get();

        if (response.getStatus() == 200) {
            return true;
        }

        throw new ResidentLocationServiceException();
    }

    /**
     * Метод принимает на вход строку xml и возвращает
     * список мест проживания
     */
    private static List<ResidentLocation> parseResidentLocationListFromXMLString(String inputStr) {

        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(inputStr));

        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
            documentBuilder = factory.newDocumentBuilder();

            document = documentBuilder.parse(inputSource);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("residentLocation");

        List<ResidentLocation> resultList = new LinkedList<ResidentLocation>();
        ResidentLocation rl = null;

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            Element element = (Element) node;

            rl = new ResidentLocation();

            //Устанавливаем текстовые поля
            rl.setId(i);
            rl.setLocationCode(element.getElementsByTagName("locationCode").item(0).getTextContent());
            rl.setCurrency(element.getElementsByTagName("currency").item(0).getTextContent());
            rl.setHotelName(element.getElementsByTagName("hotelName").item(0).getTextContent());
            rl.setHotelKind(element.getElementsByTagName("hotelKind").item(0).getTextContent());
            rl.setHotelAddress(element.getElementsByTagName("hotelAddress").item(0).getTextContent());

            //Установка времени и даты
            String priceStr = element.getElementsByTagName("price").item(0).getTextContent();
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceStr));
            rl.setPrice(price);

            String departureDateStr = element.getElementsByTagName("departureDate").item(0).getTextContent();
            String orderDateStr = element.getElementsByTagName("orderDate").item(0).getTextContent();
            Date departureDate = null;
            Date orderDate = null;

            try {
                departureDate = simpleDateFormatFrom.parse(departureDateStr);
                orderDate = simpleDateFormatFrom.parse(orderDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            rl.setDepartureDate(departureDate);
            rl.setOrderDate(orderDate);

            resultList.add(rl);
        }

        return resultList;

    }

}
