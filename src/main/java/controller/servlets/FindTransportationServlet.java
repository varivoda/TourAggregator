package controller.servlets;

import controller.exceptions.InvalidDataException;
import controller.exceptions.TransportationServiceException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.TransportationService;
import controller.gds.sabre.TransportationServiceBean;
import model.client.DescriptionTransportation;
import model.tour.Transportation;
import org.hibernate.Session;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Сервлет предназначен для взаимодействия с сервисом приложения для поиска транспортного контента
 * Поиска перелетов по полученным данным из запроса и перенаправления в jsp страничку для вывода
 * полученного результата.
 * При возникновении ошибки с сервисом отправлят на страницу ошибки с соответствующим сообщением
 */
@WebServlet("/FindTransportation")
public class FindTransportationServlet extends HttpServlet {

    // Бин, отвечающий за взаимодействие с сервисом перелетов
//    @EJB
//    TransportationServiceBean transportationService;

    @EJB
    FactoryService factoryService;

    //Сообщения об ошибках
    public static final String INCORRECT_LENGTH_OF_STAY_ERROR_MESSAGE = "Incorrect length of stay value";
    public static final String INCORRECT_DATE_FORMATE = "Incorrect date format";

    /*
    Обрабатывает запрос, если запрос корректный обращается к сервису для получения ответа.
    Если запрос составлен неверно, отпарвляет на страницу ошибки с соответствующим сообщением
      */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //Запрашиваем у фабрики сервис для GDS заданной по имени
            TransportationService transportationService = factoryService.getTransportationService(NameGDS.Sabre);

            //Получение описания перелета из запроса. Если структура запроса нарушена будет сгенерировано исключени
            DescriptionTransportation dt = getDescriptionTransportationFromRequest(req);

            //Вызов сервиса transportationService  и получение списка результов
            List<Transportation> list = transportationService.getTransportationsFromDescriptionTransportation(dt);

            //Добавляем результат в сессию и передаем jsp для показа пользователю
            HttpSession session = req.getSession();

            session.setAttribute("transportationList", list);
            getServletContext().getRequestDispatcher("/tour/ViewTransportations.jspx").forward(req,resp);
        }
        catch (Exception e){
            req.setAttribute("exception", e);
            getServletContext().getRequestDispatcher("/error.jspx").forward(req, resp);
            return;
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
