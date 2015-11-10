package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.CarCategory;

/**
 * Created by ivan on 29.10.15.
 */
public class RentTransport {

    private long id;
    private long idTour;
    private String companyName;
    private String companyAddress;
    private String carBrand;
    private String carNumber;
    private double castPerDay;
    private CarCategory carCategory;

    public RentTransport() {}

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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public double getCastPerDay() {
        return castPerDay;
    }

    public void setCastPerDay(double castPerDay) {
        this.castPerDay = castPerDay;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }
}
