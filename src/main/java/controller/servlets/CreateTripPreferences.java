package controller.servlets;

import controller.dao.impl.DaoClientImpl;
import controller.dao.impl.DaoTripPreferencesImpl;
import model.client.Client;
import model.client.TripPreferences;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ivan on 23.11.15.
 */
public class CreateTripPreferences extends HttpServlet {

    @EJB
    private DaoClientImpl clientService;
    @EJB
    private DaoTripPreferencesImpl daoTripPreferencesImpl;

    public CreateTripPreferences() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Getting parameters

        int travelersQuantity = Integer.parseInt(req.getParameter("travelersQuantity"));
        BigDecimal budget = new BigDecimal(req.getParameter("budget"));
        String departureDateStr =req.getParameter("departureDate");
        String arrivalDateStr = req.getParameter("arrivalDate");
        String transportKind = req.getParameter("transportKind");
        String hotelKind = req.getParameter("hotelKind");
        String tripDocumentType = req.getParameter("tripDocumentType");
        String originAirportCode = req.getParameter("originAirportCode");
        String destinationAirportCode = req.getParameter("destinationAirportCode");

        // Creating correct date format for MySQL

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date departureDate = null;
        Date arrivalDate = null;

        try {
            departureDate =  sdf.parse(departureDateStr);
            arrivalDate = sdf.parse(arrivalDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Creating TripPreferences instance for data base

        TripPreferences tripPreferences = new TripPreferences();
        tripPreferences.setId(0);
        tripPreferences.setTravelersQuantity(travelersQuantity);
        tripPreferences.setArrivalDate(arrivalDate);
        tripPreferences.setDepartureDate(departureDate);
        tripPreferences.setTransportKind(transportKind);
        tripPreferences.setBudget(budget);
        tripPreferences.setResidentHotelKind(hotelKind);
        tripPreferences.setTripDocumentType(tripDocumentType);
        tripPreferences.setOriginAirportCode(originAirportCode);
        tripPreferences.setDestinationAirportCode(destinationAirportCode);

        // Creating services for persisting preferences

//        DaoClientImpl clientService = new DaoClientImpl();
//        DaoTripPreferencesImpl daoTripPreferencesImpl = new DaoTripPreferencesImpl();

        String clientEmail = (String) req.getSession().getAttribute("email");
        Client client = clientService.findByEmail(clientEmail);
        tripPreferences.setClient(client);

        daoTripPreferencesImpl.persist(tripPreferences);
        resp.sendRedirect("/successfulRegistration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
