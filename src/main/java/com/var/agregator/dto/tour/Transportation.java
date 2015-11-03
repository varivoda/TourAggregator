package com.var.agregator.dto.tour;

import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 */
public class Transportation {

    private long idTour;
    private String companyName;
    private String departureAdressTo;
    private String departureAdressFrom;
    private Date departureDateTo;
    private Date departureDateFrom;
    private double cast;

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

    public String getDepartureAdressTo() {
        return departureAdressTo;
    }

    public void setDepartureAdressTo(String departureAdressTo) {
        this.departureAdressTo = departureAdressTo;
    }

    public String getDepartureAdressFrom() {
        return departureAdressFrom;
    }

    public void setDepartureAdressFrom(String departureAdressFrom) {
        this.departureAdressFrom = departureAdressFrom;
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
