package com.var.agregator.servlets;

import com.var.agregator.dao.SimpleDAO;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ClientManager
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String userLogin = request.getParameter("userLogin");
	String userPassword = request.getParameter("userPassword");

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	try	{
		con = SimpleDAO.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select login from accounts where password=\"" + userPassword + "\"" );

		String login = null;
		if(rs.next()) {
			login = rs.getString("login");
		}

		request.setAttribute("login", login);

		if (login != null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jspx");
			dispatcher.forward(request,response);
		}
		else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jspx");
			Exception ex = new Exception("Check your login or password");
			request.setAttribute("exception", ex);
			dispatcher.forward(request,response);
		}

	}
	catch (SQLException e){
		e.printStackTrace();
	}
	finally {
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
