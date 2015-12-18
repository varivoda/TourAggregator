package com.var.agregator.servlets;

import com.var.agregator.dao.ClientService;
import com.var.agregator.dto.client.Client;
import com.var.agregator.utils.HibernateUtil;
import com.var.agregator.dao.SimpleDAO;
import org.hibernate.Session;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	System.out.println("Hello from servlet 1");


	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	Client client = ClientService.findByEmail("Fedy@mail.co");

	System.out.println(client.getFullName());
	Writer wr = response.getWriter();
	wr.write(client.getFullName());


	try	{
		con = SimpleDAO.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from clients where login=\"" + userLogin + "\"" );

		String password = null;
		String fullName = null;
		if(rs.next()) {
			password = rs.getString("password");
			fullName = rs.getString("name");
		}



		if (password != null && password.equals(userPassword)){
//			request.setAttribute("login", userLogin);
			request.setAttribute("fullName", fullName);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/client/personalArea.jspx");
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
