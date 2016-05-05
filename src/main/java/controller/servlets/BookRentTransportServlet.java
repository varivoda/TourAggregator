package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.exceptions.RentCarServiceException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.RentTransportService;
import model.client.Client;
import model.tour.RentTransport;
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
import java.util.List;
import java.util.Set;

/**
 * Created by ivan on 28.04.16.
 */
@WebServlet("/BookRentTransport")
public class BookRentTransportServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Получаем выбранный RentTransport
        HttpSession session = request.getSession();
        String personalData = request.getParameter("personalData");
        RentTransport chosenRentTransport = (RentTransport) session.getAttribute("chosenRentTransport");

        try {
            RentTransportService rentTransportService = factoryService.getRentTransportService(NameGDS.SABRE);

            //Выполянем заказ
            boolean result = rentTransportService.bookRentTransport(chosenRentTransport);

            if (result){
                //Выбираем пользователя с Id
                Integer idClient = (Integer) session.getAttribute("id");
                Client client = clientDAO.findById(idClient);

                Tour tour;
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
                Set<RentTransport> rentTransportSet = tour.getRentTransports();

                //Если набор элементов не инициализирован создаем новый и присваваем его с туром
                if (rentTransportSet == null){
                    rentTransportSet = new HashSet<RentTransport>();
                    tour.setRentTransports(rentTransportSet);
                }

                //Устанавливаем связь между RentTransport and Tour
                chosenRentTransport.setTour(tour);
                rentTransportSet.add(chosenRentTransport);

                //Сохраняем tour если тур новый, обновляем, если уже существовал
                if(tourIsNew) {
                    tourDAO.persist(tour);
                }
                else {
                    tourDAO.update(tour);
                }

                response.sendRedirect("/SuccessOperation.html");
                return;
            }
            else{
                request.setAttribute("exception", new RentCarServiceException("Booking fail"));
                getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("exception", e);
            getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
            return;
        }
    }

    private RentTransport getChosenRentTransport(List<RentTransport> rentTransportList){
        return rentTransportList.get(0);
    }
}
