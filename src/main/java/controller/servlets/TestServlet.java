package controller.servlets;

import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.TransportationService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ivan on 04.04.16.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TransportationService ts = FactoryService.getTransportationService(NameGDS.Sabre);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
