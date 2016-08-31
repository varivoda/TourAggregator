package controller.servlets;

import controller.dao.ClientDAO;
import model.client.Client;
import model.tour.Tour;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 25.04.16.
 * Сервлет устанавливает по информации о клиенте, хранящейся в сессии,
 * данные о туре клиента
 */
@WebServlet("/ViewTour")
public class ViewTourServlet extends HttpServlet {

    @EJB
    private ClientDAO clientDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Достаем идентификатор из сессии и находим по нему клиента в БД
        HttpSession session = request.getSession();
        Integer clientId = (Integer) session.getAttribute("id");
        Client client = clientDAO.findById(clientId);

        Set<Tour> tourSet = client.getTours();
        Tour tour;
        if(tourSet == null || tourSet.isEmpty()){
            tour = new Tour();
        }
        else {
            tour = tourSet.iterator().next();
        }

        request.setAttribute("tour", tour);
//        response.sendRedirect("/TourAggregator/tour/ViewMyTour.jspx");
        getServletContext().getRequestDispatcher("/tour/ViewMyTour.jspx").forward(request,response);
    }
}
