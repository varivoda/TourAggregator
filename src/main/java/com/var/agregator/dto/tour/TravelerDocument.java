package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.TripDocuments;

/**
 * Created by ivan on 29.10.15.
 */
public class TravelerDocument {

    private long idTour;
    private TripDocuments tripDocuments;

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public TripDocuments getTripDocuments() {
        return tripDocuments;
    }

    public void setTripDocuments(TripDocuments tripDocuments) {
        this.tripDocuments = tripDocuments;
    }
}
