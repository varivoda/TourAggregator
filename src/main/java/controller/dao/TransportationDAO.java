package controller.dao;

import model.tour.Transportation;

import javax.ejb.Local;

/**
 * Created by ivan on 15.04.16.
 */
@Local
public interface TransportationDAO extends IDAO<Transportation, Integer> {
}
