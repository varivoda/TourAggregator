package controller.servlets;

import controller.exceptions.AccountNotFoundException;
import controller.exceptions.InvalidDataException;
import controller.dao.impl.ClientDAOImpl;
import model.client.Client;

import java.io.IOException;

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
	private ClientDAOImpl clientService;

	public static final String CANT_FOUND_CLIENT_ERROR_MESSAGE = "You have to register first system";
	public static final String INCORRECT_PASS_OR_EMAIL_ERROR_MESSAGE = "Incorrect email or password";



protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/*
	Достаем из запроса email и пароль и проверяем, что параметры непусты и не нулевые
	иначе отправляем на страницу ошибки с исключением InvalidDataException
	 */
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	if ( !(emailAndPasswordCorrect(email,password)) ){

		InvalidDataException ex = new InvalidDataException(INCORRECT_PASS_OR_EMAIL_ERROR_MESSAGE);
		request.setAttribute("exception", ex);
		getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
		return;

	}

	// Достаем клиента из базы данных по email используя сервис
	Client client = clientService.findByEmail(email);

	/*
	Проверка, что клиент существует в противном случае, отправляем на страницу ошибки
	С исключением InvalidDataException
	*/
	if(client == null){

		AccountNotFoundException e = new AccountNotFoundException(CANT_FOUND_CLIENT_ERROR_MESSAGE);
		request.setAttribute("exception", e);
		getServletContext().getRequestDispatcher("/error.jspx").forward(request,response);
		return;
	}

	/*
	Сравнение паролей
	 */
	if ( (!password.equals(client.getPassword())) ){

		InvalidDataException ex = new InvalidDataException(INCORRECT_PASS_OR_EMAIL_ERROR_MESSAGE);
		request.setAttribute("exception", ex);
		getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
		return;
	}

	/*
	Создаем новую сессию при необходиомсти
	Выставляем информацию об авторизации, имени, почте, id
	Отправляем на персональную страничку
	 */

	HttpSession session = request.getSession(true);

	session.setAttribute("authorized", true);
	session.setAttribute("fullName", client.getFullName());
	session.setAttribute("email", email);
	session.setAttribute("id", client.getId());
	response.sendRedirect("/client/personalArea.jspx");

	return;
}

	private static boolean emailAndPasswordCorrect(String email, String password){

		return ( (email != null && !email.isEmpty()) && (password != null && !password.isEmpty()) );

	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
