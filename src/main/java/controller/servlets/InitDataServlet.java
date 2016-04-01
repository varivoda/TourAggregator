package controller.servlets;

import model.DataTypes;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 29.02.16.
 */
public class InitDataServlet extends HttpServlet {

    @EJB DataTypes dataTypes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("transportKinds", dataTypes.getTransportKinds());
        req.setAttribute("hotelKinds", dataTypes.getHotelKinds());
        req.setAttribute("tripDocumentTypes", dataTypes.getTripDocumentsTypes());
        getServletContext().getRequestDispatcher("/tour/createTripPreferences.jspx").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
