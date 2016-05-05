package controller.servlets;

import model.tour.RentTransport;
import model.tour.Transportation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 29.04.16.
 */
@WebServlet("/CheckOutTransportation")
public class CheckOutTransportationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Достаем из запроса идентификатор выбранного контента
        int chosenId = Integer.parseInt(request.getParameter("chosenId"));

        //Извлекаем контент по id из сессии и удаляем список возможных вариантов
        HttpSession session = request.getSession();
        List<Transportation> rentTransportList = (List<Transportation>) session.getAttribute("transportationList");
        session.removeAttribute("transportationList");

        Transportation chosenTransportation= null;

        for (Transportation t : rentTransportList){
            if (t.getId() == chosenId){
                chosenTransportation = t;
                break;
            }
        }

        chosenTransportation.setId(0);
        session.setAttribute("chosenTransportation", chosenTransportation);

        getServletContext().getRequestDispatcher("/tour/CheckOutTransportation.jspx").forward(request, response);

    }
}
