package com.var.agregator.dto.tour;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * Created by ivan on 29.10.15.
 */
@Entity
@Table(name = "transportations")
public class Transportation {

    private int id;
    private Tour tour;
    private String transportKind;
    private String companyName;
    private String departureAddressTo;
    private String departureAddressFrom;
    private Date departureDateTo;
    private Date departureDateFrom;
    private BigDecimal price;

    public Transportation() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportation_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "transportation_kind")
    public String getTransportKind() {
        return transportKind;
    }
    public void setTransportKind(String transportKind) {
        this.transportKind = transportKind;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "departure_address_to")
    public String getDepartureAddressTo() {
        return departureAddressTo;
    }
    public void setDepartureAddressTo(String departureAddressTo) {
        this.departureAddressTo = departureAddressTo;
    }

    @Column(name = "departure_address_from")
    public String getDepartureAddressFrom() {
        return departureAddressFrom;
    }
    public void setDepartureAddressFrom(String departureAddressFrom) {
        this.departureAddressFrom = departureAddressFrom;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date_to")
    public Date getDepartureDateTo() {
        return departureDateTo;
    }
    public void setDepartureDateTo(Date departureDateTo) {
        this.departureDateTo = departureDateTo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date_from")
    public Date getDepartureDateFrom() {
        return departureDateFrom;
    }
    public void setDepartureDateFrom(Date departureDateFrom) {
        this.departureDateFrom = departureDateFrom;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
