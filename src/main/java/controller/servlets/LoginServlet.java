package controller.servlets;

import controller.dao.impl.DaoClientImpl;
import model.client.Client;

import java.io.IOException;
import java.io.Writer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

@EJB
private DaoClientImpl clientService;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email = request.getParameter("email");
	String password = request.getParameter("password");

	Client client = clientService.findByEmail(email);


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


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
