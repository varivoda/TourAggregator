package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.gds.FactoryService;
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
import java.util.Set;

/**
 * Created by ivan on 20.05.16.
 */
@WebServlet("/DeleteTour")
public class DeleteTourServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    private static final String SUCCESS_MESSAGE = "Removal was successful";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //Получаем id клиента, тур котрого удаляем
        HttpSession session = request.getSession();
        Integer clientId = (Integer) session.getAttribute("id");

        //Выполняем поиск клиента с id
        Client client = clientDAO.findById(clientId);

        //Удаляем все туры у данного клиента
        Set<Tour> tourSet = client.getTours();

        for (Tour tour : tourSet){
            tourDAO.delete(tour);
        }

        request.setAttribute("message", SUCCESS_MESSAGE);
        getServletContext().getRequestDispatcher("/client/personalArea.jspx").forward(request,response);
    }
}
