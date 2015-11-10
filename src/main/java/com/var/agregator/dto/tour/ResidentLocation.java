package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.HotelKind;

/**
 * Created by ivan on 29.10.15.
 */
public class ResidentLocation {

    private long id;
    private long idTour;
    private HotelKind hotelKind;
    private String city;
    private String hotelName;
    private String hotelAddress;
    private double costPerDay;


    public ResidentLocation() {}


    public HotelKind getHotelKind() {
        return hotelKind;
    }

    public void setHotelKind(HotelKind hotelKind) {
        this.hotelKind = hotelKind;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
