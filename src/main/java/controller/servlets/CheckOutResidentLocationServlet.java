package controller.servlets;

import model.tour.ResidentLocation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 16.05.16.
 */
@WebServlet("/CheckOutResidentLocation")
public class CheckOutResidentLocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Достаем из запроса идентификатор выбранного контента
        int chosenId = Integer.parseInt(request.getParameter("chosenId"));

        //Извлекаем контент по id из сессии и удаляем список возможных вариантов
        HttpSession session = request.getSession();
        List<ResidentLocation> residentLocationList = (List<ResidentLocation>) session.getAttribute("residentLocationList");
        session.removeAttribute("residentLocationList");

        ResidentLocation chosenResidentLocation = null;

        for (ResidentLocation rl : residentLocationList){
            if (rl.getId() == chosenId){
                chosenResidentLocation = rl;
                break;
            }
        }

        chosenResidentLocation.setId(0);
        session.setAttribute("chosenResidentLocation", chosenResidentLocation);

        getServletContext().getRequestDispatcher("/tour/CheckOutResidentLocation.jspx").forward(request, response);
    }
}
