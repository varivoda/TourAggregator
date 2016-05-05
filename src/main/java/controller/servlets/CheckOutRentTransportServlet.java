package controller.servlets;

import model.tour.RentTransport;

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
 * Сервлет оставляет только выбранный пользователем контент
 */
@WebServlet("/CheckOutRentTransport")
public class CheckOutRentTransportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Достаем из запроса идентификатор выбранного контента
        int chosenId = Integer.parseInt(request.getParameter("chosenId"));

        //Извлекаем контент по id из сессии и удаляем список возможных вариантов
        HttpSession session = request.getSession();
        List<RentTransport> rentTransportList = (List<RentTransport>) session.getAttribute("rentTransportList");
        session.removeAttribute("rentTransportList");

        RentTransport chosenRentTransport = null;

        for (RentTransport rt : rentTransportList){
            if (rt.getId() == chosenId){
                chosenRentTransport = rt;
                break;
            }
        }

        chosenRentTransport.setId(0);
        session.setAttribute("chosenRentTransport", chosenRentTransport);

        getServletContext().getRequestDispatcher("/tour/CheckOutRentTransport.jspx").forward(request, response);

    }
}
