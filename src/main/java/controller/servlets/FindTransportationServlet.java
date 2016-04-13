package controller.servlets;

import controller.InvalidDataException;
import model.client.DescriptionTransportation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ivan on 08.04.16.
 */
@WebServlet("/FindTransportation")
public class FindTransportationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DescriptionTransportation dt = getDescriptionTransportationFromRequest(req);
            System.out.println("ops");

        } catch (InvalidDataException e) {
            req.setAttribute("exception", e);
            try {
                getServletContext().getRequestDispatcher("/error.jspx").forward(req, resp);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private DescriptionTransportation getDescriptionTransportationFromRequest(HttpServletRequest req) throws InvalidDataException {

        DescriptionTransportation dt = new DescriptionTransportation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String originCode  = req.getParameter("originCode");
        String destinationCode = req.getParameter("destinationCode");
        String pointOfSaleCode  = req.getParameter("pointOfSaleCode");
        String departureDateStr = req.getParameter("departureDate");
        String maxFareStr = req.getParameter("maxFare");

        Integer lengthOfStay = Integer.parseInt(req.getParameter("lengthOfStay"));

        Date departDate = null;
        try {
            departDate = sdf.parse(departureDateStr);
        } catch (ParseException e) {
            throw new InvalidDataException("Departure date parsing error \n" +
                    "departureDate: " + departureDateStr + "\n SimpleDateFormat: " + "MM/dd/yyyy");
        }

        BigDecimal maxFare = new BigDecimal(maxFareStr);

        dt.setOriginCode(originCode);
        dt.setDestinationCode(destinationCode);
        dt.setPointOfSaleCode(pointOfSaleCode);
        dt.setLengthOfStay(lengthOfStay);
        dt.setMaxFare(maxFare);
        dt.setDepartDate(departDate);

        return dt;
    }
}
