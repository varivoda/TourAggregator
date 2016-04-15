package controller.servlets;

import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.TransportationService;
import model.tour.Transportation;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Сервле выполянет бронирование перелета в сервисе Sabre
 * также осуществяет сохранение экземпляра перелета класса в базе данных
 */
@WebServlet("/BookTransportation")
public class BookTransportationServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Transportation> transportationList = (List<Transportation>) session.getAttribute("transportationList");
        Transportation chosenTransportation = getChosenTransportation(transportationList);

        try {
            TransportationService transportationService = factoryService.getTransportationService(NameGDS.Sabre);

            boolean result = transportationService.bookTransportation(chosenTransportation);

            if (result){
                System.out.println("Сохранили в базу");
            }
        } catch (Exception e) {
            request.setAttribute("exception", e);
            getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
            return;
        }
    }

    private Transportation getChosenTransportation(List<Transportation> transportationList){
        return transportationList.get(0);
    }
}
