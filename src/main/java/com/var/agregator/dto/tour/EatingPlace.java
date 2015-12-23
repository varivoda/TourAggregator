package com.var.agregator.dto.tour;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ivan on 29.10.15.
 */
public class EatingPlace implements Serializable {

    private int id;
    private Tour tour;
    private String restaurantType;
    private String restaurantAddress;
    private String cuisineType;

    public EatingPlace() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eating_place_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Column(name = "restaurant_type")
    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    @Column(name = "restaurant_address")
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    @Column(name = "cuisine_type")
    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
