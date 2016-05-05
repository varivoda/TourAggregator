package controller.servlets;

import controller.dao.ClientDAO;
import controller.dao.TourDAO;
import controller.exceptions.TransportationServiceException;
import controller.gds.FactoryService;
import controller.gds.NameGDS;
import controller.gds.TransportationService;
import model.client.Client;
import model.tour.Tour;
import model.tour.Transportation;

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
 * Сервле выполянет бронирование перелета в сервисе SABRE
 * также осуществяет сохранение экземпляра перелета класса в базе данных
 */
@WebServlet("/BookTransportation")
public class BookTransportationServlet extends HttpServlet {

    @EJB
    FactoryService factoryService;

    @EJB
    ClientDAO clientDAO;

    @EJB
    TourDAO tourDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Получаем выбранный Transportation
        HttpSession session = request.getSession();
        Transportation chosenTransportation = (Transportation) session.getAttribute("chosenTransportation");

        try {
            TransportationService transportationService = factoryService.getTransportationService(NameGDS.SABRE);

            //Выполянем заказ
            boolean result = transportationService.bookTransportation(chosenTransportation);

            if (result){
                //Выбираем пользователя с Id
                Integer idClient = (Integer) session.getAttribute("id");
                Client client = clientDAO.findById(idClient);

                Tour tour;
                boolean tourIsNew;
                //Если у клиента нет тура, создаем новый
                if (client.getTours().isEmpty()){
                    tourIsNew = true;
                    tour = new Tour();
                    tour.setClient(client);
                }
                else{
                    tourIsNew = false;
                    tour = client.getTours().iterator().next();
                }

                // Проверям есть ли в туре эмеленты Transportation
                Set<Transportation> transportationSet = tour.getTransportations();

                //Если набор элементов не инициализирован создаем новый и присваваем его с туром
                if (transportationSet == null){
                    transportationSet = new HashSet<Transportation>();
                    tour.setTransportations(transportationSet);
                }

                //Устанавливаем связь между Transportation and Tour
                chosenTransportation.setTour(tour);
                transportationSet.add(chosenTransportation);
//                tour.setTransportations(transportationSet);

                //Сохраняем tour
                if(tourIsNew) {
                    tourDAO.persist(tour);
                }
                else {
                    tourDAO.update(tour);
                }

//                response.getWriter().append("Success booking transportation");
                response.sendRedirect("/SuccessOperation.html");
                return;
            }
            else{
                request.setAttribute("exception", new TransportationServiceException("Booking fail"));
                getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("exception", e);
            getServletContext().getRequestDispatcher("/error.jspx").forward(request, response);
            return;
        }
    }

    private Transportation getChosenTransportation(List<Transportation> transportationList){
        return transportationList.get(0);
    }
}
