package dao;

import controller.dao.*;
import controller.dao.impl.*;

/**
 * Created by ivan on 22.04.16.
 */
class DAOServices {

    static TourDAO tourDAO = new TourDAOImpl();
    static ClientDAO clientDAO = new ClientDAOImpl();
    static RentTransportDAO rentTransportDAO = new RentTransportDAOImpl();
    static ResidentLocationDAO residentLocationDAO = new ResidentLocationDAOImpl();
    static TransportationDAO transportationDAO = new TransportationDAOImpl();
}
