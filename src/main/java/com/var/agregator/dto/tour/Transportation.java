package com.var.agregator.dto.tour;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 */
public class Transportation {

    private int id;
    private int idTour;
    private String transportKindKind;
    private String companyName;
    private String departureAddressTo;
    private String departureAddressFrom;
    private Date departureDateTo;
    private Date departureDateFrom;
    private BigDecimal cast;

    public Transportation() {}


    public String getTransportKindKind() {
        return transportKindKind;
    }

    public void setTransportKindKind(String transportKindKind) {
        this.transportKindKind = transportKindKind;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartureAddressTo() {
        return departureAddressTo;
    }

    public void setDepartureAddressTo(String departureAddressTo) {
        this.departureAddressTo = departureAddressTo;
    }

    public String getDepartureAddressFrom() {
        return departureAddressFrom;
    }

    public void setDepartureAddressFrom(String departureAddressFrom) {
        this.departureAddressFrom = departureAddressFrom;
    }

    public Date getDepartureDateTo() {
        return departureDateTo;
    }

    public void setDepartureDateTo(Date departureDateTo) {
        this.departureDateTo = departureDateTo;
    }

    public Date getDepartureDateFrom() {
        return departureDateFrom;
    }

    public void setDepartureDateFrom(Date departureDateFrom) {
        this.departureDateFrom = departureDateFrom;
    }

    public BigDecimal getCast() {
        return cast;
    }

    public void setCast(BigDecimal cast) {
        this.cast = cast;
    }
}
