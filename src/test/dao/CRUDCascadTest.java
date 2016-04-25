package dao;

import model.client.Client;
import model.tour.Tour;
import model.tour.Transportation;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import static dao.DAOServices.*;
import static dao.CreatorEntity.*;


/**
 * Created by ivan on 25.04.16.
 */
public class CRUDCascadTest {

    private static final Integer CLIENT_ID = 1;

    private void clearDB(){
        transportationDAO.deleteAll();
        tourDAO.deleteAll();
    }

    private void createAndPersistTourWithTransportation() throws ParseException {

        clearDB();

        Transportation transportation = createSimpleTransportation();
        Client client = clientDAO.findById(CLIENT_ID);

        Set<Tour> tourSet = client.getTours();

        Tour tour = null;

        if (tourSet == null || tourSet.isEmpty()){
            tour = new Tour();
            tour.setClient(client);
        }

        Set<Transportation> transportationSet = new HashSet<Transportation>();
        transportationSet.add(transportation);
        tour.setTransportations(transportationSet);
        transportation.setTour(tour);

        tourDAO.persist(tour);

    }

//    @Test
    public void test() throws ParseException {

        Transportation transportation = createSimpleTransportation();
        Client client = clientDAO.findById(CLIENT_ID);

        Set<Tour> tourSet = client.getTours();

        Tour tour = null;

        if (tourSet == null || tourSet.isEmpty()){
            tour = new Tour();
            tour.setClient(client);
        }

        Set<Transportation> transportationSet = new HashSet<Transportation>();
        transportationSet.add(transportation);
        tour.setTransportations(transportationSet);
        transportation.setTour(tour);

        tourDAO.persist(tour);

        System.out.println("Yes");

        clearDB();
    }

    @Test
    public void updateTour() throws ParseException {

        createAndPersistTourWithTransportation();

        Transportation transportation = createSimpleTransportation();
        Client client = clientDAO.findById(CLIENT_ID);

        Set<Tour> tourSet = client.getTours();

        Tour tour = null;

        if (tourSet == null || tourSet.isEmpty()){
            tour = new Tour();
            tour.setClient(client);
        }
        else {
            tour = tourSet.iterator().next();
        }


        Set<Transportation> transportationSet = tour.getTransportations();
        if(transportationSet == null){
            transportationSet = new HashSet<Transportation>();
        }

        transportationSet.add(transportation);
//        tour.setTransportations(transportationSet);
        transportation.setTour(tour);

        transportationDAO.persist(transportation);

        System.out.println("d");

        client = clientDAO.findById(CLIENT_ID);

        clearDB();

    }

}
