package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.RestaurantType;

/**
 * Created by ivan on 29.10.15.
 */
public class EatingPlace {

    private long id;
    private long idTour;
    private RestaurantType restaurantType;
    private String restaurantAddress;
    private String cuisineType;

    public EatingPlace() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
