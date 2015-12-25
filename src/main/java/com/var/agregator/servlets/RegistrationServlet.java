package com.var.agregator.servlets;

import com.var.agregator.dao.ClientService;
import com.var.agregator.dao.SimpleDAO;
import com.var.agregator.dto.client.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by ivan on 03.11.15.
 */
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

        ClientService cs = new ClientService();

        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");

        Client newClient = new Client();

        newClient.setId(0);
        newClient.setPassword(password);
        newClient.setFullName(fullName);
        newClient.setEmail(email);

        cs.persist(newClient);
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
