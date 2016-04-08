package controller.servlets;

import model.TourContentData;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 29.02.16.
 */
@WebServlet("/InitData")
public class InitDataServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("transportKinds", TourContentData.getTransportKindsAsArray());
        req.setAttribute("hotelKinds", TourContentData.getHotelKindsAsArray());
        req.setAttribute("tripDocumentTypes", TourContentData.getTripDocumentsTypesAsArray());
        getServletContext().getRequestDispatcher("/tour/createTripPreferences.jspx").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
