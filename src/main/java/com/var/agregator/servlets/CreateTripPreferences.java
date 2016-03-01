package com.var.agregator.servlets;

import com.var.agregator.dto.client.TripPreferences;

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
        String transportKind = req.getParameter("TransportKind");

        // Creating correct date format for MySQL

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
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
        tripPreferences.setArrivalDate(arrivalDate);
        tripPreferences.setDepartureDate(departureDate);
        tripPreferences.setBudget(budget);
        tripPreferences.setResidentHotelKind(null);
        tripPreferences.setTripDocumentType(null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
