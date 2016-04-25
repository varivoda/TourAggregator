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
import javax.naming.NamingException;
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
 * Сервле выполянет бронирование перелета в сервисе Sabre
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
        List<Transportation> transportationList = (List<Transportation>) session.getAttribute("transportationList");
        Transportation chosenTransportation = getChosenTransportation(transportationList);

        try {
            TransportationService transportationService = factoryService.getTransportationService(NameGDS.Sabre);

            //Выполянем заказ
            boolean result = transportationService.bookTransportation(chosenTransportation);

            if (result){
                //Выбираем пользователя с Id
                Integer idClient = (Integer) session.getAttribute("id");
                Client client = clientDAO.findById(idClient);

                Tour tour;
                //Если у клиента нет тура, создаем новый
                if (client.getTours() == null || client.getTours().isEmpty()){
                    tour = new Tour();
                    tour.setClient(client);
                }
                else{
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
                tourDAO.persist(tour);

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
