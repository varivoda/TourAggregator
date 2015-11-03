package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.CarCategory;

/**
 * Created by ivan on 29.10.15.
 */
public class RentTransport {

    private long idTour;
    private String companyName;
    private String companyAdress;
    private String carBrand;
    private double castPerDay;
    private CarCategory carCategory;

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
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
