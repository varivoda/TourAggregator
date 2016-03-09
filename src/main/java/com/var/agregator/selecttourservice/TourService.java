package com.var.agregator.selecttourservice;

import com.var.agregator.dto.client.TripPreferences;
import com.var.agregator.dto.tour.ResidentLocation;
import com.var.agregator.dto.tour.Tour;

/**
 * Created by ivan on 03.03.16.
 */
public interface TourService {

    public Tour createTour(TripPreferences tripPreferences);
    public ResidentLocation serachResidentLocation(TripPreferences tripPreferences);
}
