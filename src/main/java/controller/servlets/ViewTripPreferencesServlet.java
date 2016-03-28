package controller.servlets;

import controller.dao.TripPreferencesService;
import model.client.TripPreferences;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ivan on 02.03.16.
 */
public class ViewTripPreferencesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer clientId = (Integer) req.getSession().getAttribute("id");
        TripPreferencesService tripPreferencesService = new TripPreferencesService();
        List<TripPreferences> tripPreferences = tripPreferencesService.findByClientId(clientId);

        if (tripPreferences != null) {
            req.setAttribute("tripPreferences", tripPreferences.toArray());
        }else{
            req.setAttribute("tripPreferences", null);
        }

        getServletContext().getRequestDispatcher("/tour/viewTripPreferences.jspx").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
