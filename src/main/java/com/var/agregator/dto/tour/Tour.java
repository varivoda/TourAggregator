package com.var.agregator.dto.tour;

import java.util.List;

/**
 * Created by ivan on 10.11.15.
 */
public class Tour {

    private int id;
    private int idClient;
    private List<GeneralInformation> generalInformations;
    private List<EatingPlace> eatingPlaces;
    private List<RentTransport> rentTransports;
    private List<ResidentLocation> residentLocations;
    private List<Transportation> transportations;
//    private List<TravelerDocument> travelerDocuments;

    public Tour() {}

    public List<GeneralInformation> getGeneralInformations() {
        return generalInformations;
    }

    public void setGeneralInformations(List<GeneralInformation> generalInformations) {
        this.generalInformations = generalInformations;
    }

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

//    public List<TravelerDocument> getTravelerDocuments() {
//        return travelerDocuments;
//    }
//
//    public void setTravelerDocuments(List<TravelerDocument> travelerDocuments) {
//        this.travelerDocuments = travelerDocuments;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
