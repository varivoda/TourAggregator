package model.tour;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 */
@Entity
@Table(name = "general_informations")
public class GeneralInformation implements Serializable {

    private int id;
    private Tour tour;
    private String country;
    private String city;
    private Date departureDate;
    private Date arrivalDate;
    private int travelersQuantity;
    private BigDecimal budget;

    public GeneralInformation(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "general_information_id")
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
    public void setTour(Tour idTour) {
        this.tour = idTour;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date")
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrival_date")
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Column(name = "travelers_quantity")
    public int getTravelersQuantity() {
        return travelersQuantity;
    }
    public void setTravelersQuantity(int travelersQuantity) {
        this.travelersQuantity = travelersQuantity;
    }
    @Column(name = "budget")
    public BigDecimal getBudget() {
        return budget;
    }
    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
