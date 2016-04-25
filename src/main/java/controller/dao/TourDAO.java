package controller.dao;

import model.tour.Tour;

import javax.ejb.Local;

/**
 * Created by ivan on 21.04.16.
 */
@Local
public interface TourDAO extends IDAO<Tour,Integer> {
}
