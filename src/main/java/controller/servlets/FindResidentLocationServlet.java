package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.ResidentLocationService;
import model.client.DescriptionResidentLocation;
import model.tour.ResidentLocation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import static controller.util.DateTimeHelper.*;

/**
 * Created by ivan on 29.04.16.
 */
@WebServlet("/FindResidentLocation")
public class FindResidentLocationServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Запрашиваем у фабрики сервис для заказа места проживания по имени GDS
            ResidentLocationService residentLocationService = factoryService.getResidentLocationService(NameGDS.MY_WEB_SERVICE);

            //Получение описания перелета из запроса. Если структура запроса нарушена будет сгенерировано исключени
            DescriptionResidentLocation drl = getDescriptionResidentLocationFromRequest(request);

            //получение списка результов по описанию места проживания
            List<ResidentLocation> list = residentLocationService.getResidentLocations(drl);

            //Добавляем результат FindResidentLocationServlet сессию и передаем jsp для показа пользователю
            HttpSession session = request.getSession();

            session.setAttribute("residentLocationList", list);
            getServletContext().getRequestDispatcher("/tour/ViewResidentLocation.jspx").forward(request,response);
        }
        catch (Exception e){
            request.setAttribute("exception", e);
            getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
            return;
        }


    }

    private DescriptionResidentLocation getDescriptionResidentLocationFromRequest(HttpServletRequest request) throws ParseException {

        DescriptionResidentLocation drl = new DescriptionResidentLocation();

        //Установка кода места назначения
        String locationCode = request.getParameter("locationCode");
        drl.setLocationCode(locationCode);

        //Проверка, что значение корректно и установка максимальной стоимости
        String maxFareStr = request.getParameter("maxFare");
        if (maxFareStr != null && !maxFareStr.isEmpty()){
            double maxFareD = Double.parseDouble(maxFareStr);
            drl.setMaxFare(BigDecimal.valueOf(maxFareD));
        }

        //Парсинг и установка даты возвращения
        String departureDateTimeStr = request.getParameter("departureDateTime");
        Date departureDateTime = getDateTimeFromString(departureDateTimeStr);
        drl.setDepartureDate(departureDateTime);

        //Парсинг и установка даты заказа
        String orderDateTimeStr = request.getParameter("orderDateTime");
        Date orderDateTime = getDateTimeFromString(orderDateTimeStr);
        drl.setOrderDate(orderDateTime);

        return drl;
    }
}
