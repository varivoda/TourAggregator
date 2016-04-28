package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.exceptions.InvalidDataException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.RentTransportService;
import model.client.DescriptionRentTransport;
import model.tour.RentTransport;
import model.tour.Transportation;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static controller.util.DateTimeHelper.*;
/**
 * Created by ivan on 28.04.16.
 */
@WebServlet("/FindRentTransport")
public class FindRentTransportServlet extends HttpServlet {


    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //Запрашиваем у фабрики сервис для GDS заданной по имени
            RentTransportService rentTransportService = factoryService.getRentTransportService(NameGDS.Sabre);

            //Получение описания перелета из запроса. Если структура запроса нарушена будет сгенерировано исключени
            DescriptionRentTransport drt = getDescriptionRentTransportFromRequest(req);

            //Вызов сервиса transportationService  и получение списка результов
            List<RentTransport> list = rentTransportService.getRentTransport(drt);

            //Добавляем результат в сессию и передаем jsp для показа пользователю
            HttpSession session = req.getSession();

            session.setAttribute("rentTransportList", list);
            getServletContext().getRequestDispatcher("/tour/ViewRentTransport.jspx").forward(req,resp);
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

    private DescriptionRentTransport getDescriptionRentTransportFromRequest(HttpServletRequest req) throws InvalidDataException{

        DescriptionRentTransport drt = new DescriptionRentTransport();

        String pickUpDateTimeStr = req.getParameter("pickUpDateTime");
        String returnDateTimeStr = req.getParameter("returnDateTime");
        String locationCode = req.getParameter("locationCode");

        Date pickUpDateTime = null;
        Date returnDateTime = null;
        try {
            pickUpDateTime = getDateTimeFromString(pickUpDateTimeStr);
            returnDateTime = getDateTimeFromString(returnDateTimeStr);
        } catch (ParseException e) {
            throw new InvalidDataException("Incorrect date");
        }

        drt.setLocationCode(locationCode);
        drt.setReturnDateTime(returnDateTime);
        drt.setPickUpDateTime(pickUpDateTime);

        return drt;
    }

}
