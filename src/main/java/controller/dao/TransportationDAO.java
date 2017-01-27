package controller.dao;

import model.tour.Transportation;

import javax.ejb.Local;

@Local
public interface TransportationDAO extends IDAO<Transportation, Integer> {
}
