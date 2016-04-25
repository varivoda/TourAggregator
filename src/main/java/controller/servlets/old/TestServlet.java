package controller.servlets.old;

import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.RentTransportService;
import controller.gds.TransportationService;

import javax.ejb.EJB;
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

    @EJB
    FactoryService factoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            TransportationService ts = factoryService.getTransportationService(NameGDS.Sabre);
            RentTransportService rs = factoryService.getRentTransportService(NameGDS.Sabre);
            System.out.println();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
