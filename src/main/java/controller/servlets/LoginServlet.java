package controller.servlets;

import controller.dao.ClientService;
import model.client.Client;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClientManager
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public LoginServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email = request.getParameter("email");
	String password = request.getParameter("password");

	ClientService cs = new ClientService();
	Client client = cs.findByEmail(email);


	if (client != null && password != null && password.equals(client.getPassword())) {
		Writer wr = response.getWriter();
		HttpSession session = request.getSession(true);
		session.setAttribute("authorized", true);
		session.setAttribute("fullName", client.getFullName());
		session.setAttribute("email", email);
		session.setAttribute("id", client.getId());
		response.sendRedirect("/client/personalArea.jspx");
		return;
	}

	response.sendRedirect("/error.jspx");
	Exception ex = new Exception("Check your login or password");
	request.setAttribute("exception", ex);


}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
