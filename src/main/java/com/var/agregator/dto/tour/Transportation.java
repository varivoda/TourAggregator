package com.var.agregator.dto.tour;

import com.var.agregator.dto.enums.TransportKind;

import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 */
public class Transportation {

    private long id;
    private long idTour;
    private TransportKind transportKindKind;
    private String companyName;
    private String departureAddressTo;
    private String departureAddressFrom;
    private Date departureDateTo;
    private Date departureDateFrom;
    private double cast;

    public Transportation() {}


    public TransportKind getTransportKindKind() {
        return transportKindKind;
    }

    public void setTransportKindKind(TransportKind transportKindKind) {
        this.transportKindKind = transportKindKind;
    }

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

    public double getCast() {
        return cast;
    }

    public void setCast(double cast) {
        this.cast = cast;
    }
}
