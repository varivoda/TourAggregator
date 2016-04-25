package dao;

//import controller.dao.ClientDAO;
//import controller.dao.RentTransportDAO;
//import controller.dao.TourDAO;
//import controller.dao.impl.ClientDAOImpl;
//import controller.dao.impl.RentTransportDAOImpl;
//import controller.dao.impl.TourDAOImpl;
import model.client.Client;
import model.tour.RentTransport;
import model.tour.ResidentLocation;
import model.tour.Tour;
import model.tour.Transportation;
import static org.junit.Assert.*;
import org.junit.Test;
import static dao.DAOServices.*;

import java.text.ParseException;
import java.util.*;

/**
 * Created by ivan on 21.04.16.
 */
public class TourDAOTest {

//    private static TourDAO tourDAO = new TourDAOImpl();
//    private static ClientDAO clientDAO = new ClientDAOImpl();
//    private static RentTransportDAO rentTransportDAO = new RentTransportDAOImpl();

    private static final String CLIENT_EMAIL = "varivoda_ivan@mail.ru";
    private static final int NUM_TOURS = 10;

    static Tour createSimplyTourByClientEmail(String clientEmail) throws ParseException {

        Tour tour = new Tour();

        ResidentLocation residentLocation = ResidentLocationDAOTest.getResidentLocation();
        residentLocation.setTour(tour);

        Transportation transportation = TransportationDAOTest.createTransportation();
        transportation.setTour(tour);

        RentTransport rentTransport = RentTransportDAOTest.createSimplyRentTransport();
        rentTransport.setTour(tour);

        Set<ResidentLocation> residentLocationSet = new HashSet<ResidentLocation>();
        residentLocationSet.add(residentLocation);

        Set<Transportation> transportationSet = new HashSet<Transportation>();
//        List<Transportation> transportationSet = new ArrayList<Transportation>();
        transportationSet.add(transportation);

        Set<RentTransport> rentTransportSet = new HashSet<RentTransport>();
//        List<RentTransport> rentTransportSet = new ArrayList<RentTransport>();
        rentTransportSet.add(rentTransport);

        Client client = clientDAO.findByEmail(clientEmail);
//        Client client = clientDAO.findByEmail("admin");

        tour.setRentTransports(rentTransportSet);
        tour.setResidentLocations(residentLocationSet);
        tour.setTransportations(transportationSet);
        tour.setClient(client);

        return tour;
    }

    @Test
    public void CRUDTest() throws ParseException {

        //удаляем все записи из БД и сохраняем текущий экземпляр
        tourDAO.deleteAll();

        //создаем NUM_TOURS простых туров и сохраняем в БД
        for (int i = 0; i < NUM_TOURS; i++){
            Tour tour = createSimplyTourByClientEmail(CLIENT_EMAIL);
            tourDAO.persist(tour);
        }

        //Проверка, что клиент связанный с этим туром содержит то же количество туров
        Client client = clientDAO.findByEmail(CLIENT_EMAIL);
        assertEquals(NUM_TOURS, client.getTours().size());


        //Достаем все туры из БД и провермяем, что их кол-во равно заказанному кол-ву
        List<Tour> tourList = tourDAO.findAll();
        assertEquals(NUM_TOURS, tourList.size());

        //Удаляем все туры из БД
        tourDAO.deleteAll();

        //Достаем set туров и проверяем, что он null
        tourList = tourDAO.findAll();
        assertEquals(0, tourList.size());


        //Проверка, что клиент связанный с этим туром содержит то же количество туров
        client = clientDAO.findByEmail(CLIENT_EMAIL);
        assertEquals(0, client.getTours().size());
    }

//    @Test
    public void CreteNewClientWithOldTourPersist() throws ParseException {

        //удаляем все записи из БД и сохраняем текущий экземпляр
        tourDAO.deleteAll();

        //создаем NUM_TOURS простых туров и сохраняем в БД
        for (int i = 0; i < NUM_TOURS; i++){
            Tour tour = createSimplyTourByClientEmail(CLIENT_EMAIL);
            tourDAO.persist(tour);
        }

        //Достаем все туры из БД и провермяем, что их кол-во равно заказанному кол-ву
        List<Tour> tourList = tourDAO.findAll();
        assertEquals(NUM_TOURS, tourList.size());

        final String newEmail = "ne_Varivoda_Ivan@mail.ru";

        Client newClient = new Client();
        newClient.setFullName("Ne Varivoda Ivan");
        newClient.setEmail(newEmail);
        newClient.setPassword("nepass");
//        newClient.setTours(tourList);

        clientDAO.persist(newClient);

        //Проверка, что клиент связанный с этим туром содержит то же количество туров
        Client client = clientDAO.findByEmail(newEmail);
        assertEquals(NUM_TOURS, client.getTours().size());

        //Удаляем все туры из БД
        tourDAO.deleteAll();

        //Достаем set туров и проверяем, что он null
        tourList = tourDAO.findAll();
        assertEquals(0, tourList.size());
    }

    //Добавляем новый Transportation в Tour и вызываем клиента, привязанного к этому туру
    @Test
    public void insertOneMoreTransportationAndCheck() throws ParseException {

        //удаляем все записи из БД
        tourDAO.deleteAll();

        //создаем простой тур и сохраняем в БД
        Tour tour = createSimplyTourByClientEmail(CLIENT_EMAIL);
        tourDAO.persist(tour);

        //Достаем все туры из БД
        List<Tour> tourList = tourDAO.findAll();

        //Достаем единственный тур и получаем его Id
        Tour tourFromList = tourList.get(0);
        Integer tourId = tourFromList.getId();

        //Создаем новый Transportation и устанавливаем ему текущий тур
        Transportation newTransportation = TransportationDAOTest.createTransportation();
//        newTransportation.setTour(tour);
        newTransportation.setId(tourId);

        //Сохраняет Transportation
        transportationDAO.persist(newTransportation);

        //Достаем set туров и проверяем, что в списке Transportation 2 экземпляра
//        tourList = tourDAO.findAll();
//        tourFromList = tourList.get(0);
        tourFromList = tourDAO.findById(tourId);

        assertEquals(2, tourFromList.getTransportations().size());


        //По экземпляру клиента поиск туров и проверка, что в листе Transportation 2 экземпляра
        Client client = clientDAO.findByEmail(CLIENT_EMAIL);
        tourList = new ArrayList<Tour>(client.getTours());
        tourFromList = tourList.get(0);
        assertEquals(2, tourFromList.getTransportations().size());

        tourDAO.deleteAll();
    }


}
