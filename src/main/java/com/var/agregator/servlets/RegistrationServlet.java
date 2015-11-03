package com.var.agregator.servlets;

import com.var.agregator.dao.SimpleDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ivan on 03.11.15.
 */
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = SimpleDAO.getConnection();
            st = con.createStatement();
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String sql = "insert into accounts values(\"" + login + "\", \"" + password + "\")";
            st.executeUpdate(sql);

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
