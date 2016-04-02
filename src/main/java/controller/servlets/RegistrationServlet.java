package controller.servlets;

import controller.dao.impl.DaoClientImpl;
import model.client.Client;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by ivan on 03.11.15.
 */

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    @EJB
    private DaoClientImpl clientService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");

        Client newClient = new Client();

        newClient.setId(0);
        newClient.setPassword(password);
        newClient.setFullName(fullName);
        newClient.setEmail(email);

        clientService.persist(newClient);
        try {
            getServletContext().getRequestDispatcher("/successfulRegistration.html").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//            con = SimpleDAO.getConnection();
////            st = con.createStatement();
//            String insertClientString = "insert into clients(login, password, name, email)  values(?, ?, ?, ?)";
//
//
//            insertClient = con.prepareStatement(insertClientString);
//            insertClient.setString(1,login);
//            insertClient.setString(2,password);
//            insertClient.setString(3,fullName);
//            insertClient.setString(4,email);
//
//            insertClient.executeUpdate();
//
//            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
//
//            try {
//                request.setAttribute("exception", e);
//                getServletContext().getRequestDispatcher("/error.jspx").forward(request,response);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(rs != null)
//                try {
//                    rs.close();
//                } catch (SQLException e) {e.printStackTrace();}
//            if(st != null)
//                try {
//                    st.close();
//                } catch (SQLException e) {e.printStackTrace();}
//            if (con != null)
//                try {
//                    con.close();
//                } catch (SQLException e) {e.printStackTrace();}
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        doGet(request,response);
    }
}
