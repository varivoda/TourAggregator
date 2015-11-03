package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.RestouranType;

/**
 * Created by ivan on 29.10.15.
 */
public class EatingPlace {

    private long idTour;
    private RestouranType restouranType;
    private String resouranAdress;
    private String cuisineType;

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public RestouranType getRestouranType() {
        return restouranType;
    }

    public void setRestouranType(RestouranType restouranType) {
        this.restouranType = restouranType;
    }

    public String getResouranAdress() {
        return resouranAdress;
    }

    public void setResouranAdress(String resouranAdress) {
        this.resouranAdress = resouranAdress;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
