package controller.servlets;

import controller.dao.impl.TripPreferencesDAOImpl;
import model.client.TripPreferences;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 02.03.16.
 */
@WebServlet("/ViewTripPreferences")
public class ViewTripPreferencesServlet extends HttpServlet {

    @EJB
    private TripPreferencesDAOImpl tripPreferencesDAOImpl;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer clientId = (Integer) req.getSession().getAttribute("id");

        List<TripPreferences> tripPreferences = tripPreferencesDAOImpl.findByClientId(clientId);

        if (tripPreferences != null) {
            req.setAttribute("tripPreferences", tripPreferences.toArray());
        }else{
            req.setAttribute("tripPreferences", null);
        }

        getServletContext().getRequestDispatcher("/tour/ViewMyTour.jspx").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
