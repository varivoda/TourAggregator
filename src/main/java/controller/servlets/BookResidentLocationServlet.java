package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.exceptions.ResidentLocationServiceException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.ResidentLocationService;
import model.client.Client;
import model.tour.ResidentLocation;
import model.tour.Tour;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 16.05.16.
 */
@WebServlet("/BookResidentLocaion")
public class BookResidentLocationServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    private static final String SUCCESS_MESSAGE = "Booking resident location was successful";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Получаем выбранный ResidentLocation
        HttpSession session = request.getSession();
        String personalData = request.getParameter("personalData");
        ResidentLocation chosenResidentLocation = (ResidentLocation) session.getAttribute("chosenResidentLocation");

        Tour tour = null;
        try {
            ResidentLocationService residentLocationService = factoryService.getResidentLocationService(NameGDS.MY_WEB_SERVICE);

            //Выполянем заказ
            boolean result = residentLocationService.bookResidentLocation(chosenResidentLocation);

            if (result){
                //Выбираем пользователя с Id
                Integer idClient = (Integer) session.getAttribute("id");
                Client client = clientDAO.findById(idClient);


                boolean tourIsNew;
                //Если у клиента нет тура, создаем новый
                if (client.getTours() == null || client.getTours().isEmpty()){
                    tourIsNew = true;
                    tour = new Tour();
                    tour.setClient(client);
                }
                else{
                    tourIsNew = false;
                    tour = client.getTours().iterator().next();
                }

                // Проверям есть ли в туре эмеленты rentTransport
                Set<ResidentLocation> residentLocationSet = tour.getResidentLocations();

                //Если набор элементов не инициализирован создаем новый и присваваем его с туром
                if (residentLocationSet == null){
                    residentLocationSet = new HashSet<ResidentLocation>();
                    tour.setResidentLocations(residentLocationSet);
                }

                //Устанавливаем связь между RentTransport and Tour
                chosenResidentLocation.setTour(tour);
                residentLocationSet.add(chosenResidentLocation);

                //Сохраняем tour если тур новый, обновляем, если уже существовал
                if(tourIsNew) {
                    tourDAO.persist(tour);
                }
                else {
                    tourDAO.update(tour);
                }

//                response.sendRedirect("/SuccessOperation.html");
                request.setAttribute("message", SUCCESS_MESSAGE);
                getServletContext().getRequestDispatcher("/client/personalArea.jspx").forward(request,response);
                return;
            }
            else{
                request.setAttribute("exception", new ResidentLocationServiceException("Booking fail"));
                getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("exception" , new Exception("Данные о туре \n" +
                    "\nid: " + tour.getId() +
                    "\nclient: " + tour.getClient() +
                    "\nresident locations: " + tour.getResidentLocations(),e));
            getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
