package controller.servlets;

import controller.dao.impl.ClientDAOImpl;
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
    private ClientDAOImpl clientService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        Установка кодировки запроса для работы с кириллицей
        Получение параметров из запроса
        Параметры должны приходить непустые и не нулевые
         */
        request.setCharacterEncoding("utf-8");

        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");


        /*
        Создание экземпляра клиента и установка его полей
        id устанавливается 0. Увеличение идентификатора отводится на базу данных
         */
        Client newClient = new Client();

        newClient.setId(0);
        newClient.setPassword(password);
        newClient.setFullName(fullName);
        newClient.setEmail(email);

        /*
        Сохранение экземпляра клиента в БД с обработкой исключения,
        и переход на страничку успешной регестрации

         */
        clientService.persist(newClient);
        response.sendRedirect("/TourAggregator/successfulRegistration.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
