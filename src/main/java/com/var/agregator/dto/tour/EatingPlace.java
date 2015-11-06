package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.RestaurantType;

/**
 * Created by ivan on 29.10.15.
 */
public class EatingPlace {

    private long idTour;
    private RestaurantType restaurantType;
    private String resaurantAdress;
    private String cuisineType;

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getResaurantAdress() {
        return resaurantAdress;
    }

    public void setResaurantAdress(String resaurantAdress) {
        this.resaurantAdress = resaurantAdress;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
