package com.var.agregator.servlets;

import com.var.agregator.dto.data.TransportKinds;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 24.11.15.
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TransportKind[] tr1 = TransportKinds.toArray();
        req.setAttribute("transportKinds", TransportKinds.toArray());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/tour/createTripPreferences.jspx");
        rd.forward(req,resp);
    }
}
