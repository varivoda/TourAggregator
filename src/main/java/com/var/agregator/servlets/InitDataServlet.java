package com.var.agregator.servlets;

import com.var.agregator.dto.data.DataTypes;
import com.var.agregator.dto.data.HotelKinds;
import com.var.agregator.dto.data.TransportKinds;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 29.02.16.
 */
public class InitDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("transportKinds", DataTypes.getTransportKinds());
        req.setAttribute("hotelKinds", DataTypes.getHotelKinds());
        req.setAttribute("tripDocumentTypes", DataTypes.getTripDocumentsTypes());
        getServletContext().getRequestDispatcher("/tour/createTripPreferences.jspx").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
