package controller.servlets;

import controller.exceptions.InvalidDataException;
import controller.gds.sabre.TransportationServiceBean;
import model.client.DescriptionTransportation;
import model.tour.Transportation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 08.04.16.
 */
@WebServlet("/FindTransportation")
public class FindTransportationServlet extends HttpServlet {

    @EJB
    TransportationServiceBean transportationService;

    public static final String INCORRECT_LENGTH_OF_STAY_ERROR_MESSAGE = "Incorrect length of stay value";
    public static final String INCORRECT_DATE_FORMATE = "Incorrect date format";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DescriptionTransportation dt = getDescriptionTransportationFromRequest(req);
            System.out.println("ops");

            List<Transportation> list = transportationService.getTransportationsFromDescriptionTransportation(dt);
            System.out.println();

        } catch (InvalidDataException e) {
            req.setAttribute("exception", e);
            try {
                getServletContext().getRequestDispatcher("/error.jspx").forward(req, resp);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    /**

     * @param req
     * @return DescriptionTransportation
     * @throws InvalidDataException
     *
     * Метод получает на вход экземпляр запроса и создает по нему экземпляр
     * класса DescriptionTransportation.
     * Данные на вход поступают корректные. Проверяется скриптами на jsp.
     */
    private DescriptionTransportation getDescriptionTransportationFromRequest(HttpServletRequest req) throws InvalidDataException {

        // Получение параметров из запроса в виде строк
        String originCode  = req.getParameter("originCode");
        String destinationCode = req.getParameter("destinationCode");
        String pointOfSaleCode  = req.getParameter("pointOfSaleCode");
        String departureDateStr = req.getParameter("departureDate");
        String maxFareStr = req.getParameter("maxFare");
        String lengthOfStayStr = req.getParameter("lengthOfStay");

        /*
        Парсинг количества дней при возникновении исключений
        Генерируется InvalidDataException с сообщением об ошибке
        */
        Integer lengthOfStay;
        try {
            lengthOfStay = Integer.parseInt(lengthOfStayStr);
        }
        catch (NumberFormatException e){
            throw new InvalidDataException(INCORRECT_LENGTH_OF_STAY_ERROR_MESSAGE);
        }

        /*
        Парсинг даты отправления
        */
        Date departDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            departDate = sdf.parse(departureDateStr);
        } catch (ParseException e) {
            throw new InvalidDataException("Departure date parsing error \n" +
                    "departureDate: " + departureDateStr + "\n SimpleDateFormat: " + "MM/dd/yyyy");
        }

        /*
        Создание экземпляра и устаовка полей
         */
        DescriptionTransportation dt = new DescriptionTransportation();

        dt.setOriginCode(originCode);
        dt.setDestinationCode(destinationCode);
        dt.setPointOfSaleCode(pointOfSaleCode);
        dt.setLengthOfStay(lengthOfStay);
        dt.setDepartDate(departDate);

        /*
        Проверка и установка дополнительных полей
         */
        if (maxFareStr != null && !maxFareStr.isEmpty()) {
            BigDecimal maxFare = new BigDecimal(maxFareStr);
            dt.setMaxFare(maxFare);
        }

        return dt;
    }
}
