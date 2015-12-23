package com.var.agregator.dto.tour;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ivan on 29.10.15.
 */
@Entity
@Table(name = "rent_transports")
public class RentTransport {

    private int id;
    private Tour tour;
    private String companyName;
    private String companyAddress;
    private String carBrand;
    private String carNumber;
    private BigDecimal pricePerDay;
    private String carCategory;

    public RentTransport() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_transport_id")
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

    @Column(name = "car_number")
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "company_address")
    public String getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Column(name = "car_brand")
    public String getCarBrand() {
        return carBrand;
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Column(name = "price_per_day")
    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Column(name = "car_category")
    public String getCarCategory() {
        return carCategory;
    }
    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }
}
