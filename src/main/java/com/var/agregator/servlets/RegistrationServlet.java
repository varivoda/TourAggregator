package com.var.agregator.servlets;

import com.var.agregator.dao.SimpleDAO;

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
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement insertClient = null;

        try {
            con = SimpleDAO.getConnection();
//            st = con.createStatement();
            String insertClientString = "insert into accounts values(?,?,?,?)";
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");

            insertClient = con.prepareStatement(insertClientString);
            insertClient.setString(1,login);
            insertClient.setString(2,password);
            insertClient.setString(3,fullName);
            insertClient.setString(4,email);

            insertClient.execute();

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (SQLException e) {
            try {
                request.setAttribute("exception", e);
                getServletContext().getRequestDispatcher("/error.jspx").forward(request,response);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {e.printStackTrace();}
            if(st != null)
                try {
                    st.close();
                } catch (SQLException e) {e.printStackTrace();}
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {e.printStackTrace();}
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        doGet(request,response);
    }
}
