package com.var.agregator.dto.tour;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 10.11.15.
 */
public class Tour {

    private long id;
    private long idClient;
    private String country;
    private String city;
    private Date departureDate;
    private Date arrivalDate;
    private List<EatingPlace> eatingPlaces;
    private List<RentTransport> rentTransports;
    private List<ResidentLocation> residentLocations;
    private List<Transportation> transportations;
    private List<TravelerDocument> travelerDocuments;

    public Tour() {}

    public List<EatingPlace> getEatingPlaces() {
        return eatingPlaces;
    }

    public void setEatingPlaces(List<EatingPlace> eatingPlaces) {
        this.eatingPlaces = eatingPlaces;
    }

    public List<RentTransport> getRentTransports() {
        return rentTransports;
    }

    public void setRentTransports(List<RentTransport> rentTransports) {
        this.rentTransports = rentTransports;
    }

    public List<ResidentLocation> getResidentLocations() {
        return residentLocations;
    }

    public void setResidentLocations(List<ResidentLocation> residentLocations) {
        this.residentLocations = residentLocations;
    }

    public List<Transportation> getTransportations() {
        return transportations;
    }

    public void setTransportations(List<Transportation> transportations) {
        this.transportations = transportations;
    }

    public List<TravelerDocument> getTravelerDocuments() {
        return travelerDocuments;
    }

    public void setTravelerDocuments(List<TravelerDocument> travelerDocuments) {
        this.travelerDocuments = travelerDocuments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
