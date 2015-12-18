package com.var.agregator.dto.tour;


/**
 * Created by ivan on 29.10.15.
 */
public class RentTransport {

    private int id;
    private int idTour;
    private String companyName;
    private String companyAddress;
    private String carBrand;
    private String carNumber;
    private double castPerDay;
    private String carCategory;

    public RentTransport() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
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

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }
}
