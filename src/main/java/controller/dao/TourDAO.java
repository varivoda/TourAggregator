package controller.dao;

import model.tour.Tour;

import javax.ejb.Local;

@Local
public interface TourDAO extends IDAO<Tour, Integer> {
}
