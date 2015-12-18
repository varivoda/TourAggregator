package com.var.agregator.dto.tour;

import java.math.BigDecimal;

/**
 * Created by ivan on 29.10.15.
 */
public class ResidentLocation {

    private int id;
    private int idTour;
    private String hotelKind;
//    private String city;
    private String hotelName;
    private String hotelAddress;
    private BigDecimal costPerDay;


    public ResidentLocation() {}


    public String getHotelKind() {
        return hotelKind;
    }

    public void setHotelKind(String hotelKind) {
        this.hotelKind = hotelKind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(BigDecimal costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }

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
