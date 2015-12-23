package com.var.agregator.dto.tour;

import com.var.agregator.dto.client.Client;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ivan on 10.11.15.
 */
@Entity
@Table(name = "tour")
public class Tour {

    private int id;
    private Client client;
    private List<GeneralInformation> generalInformations;
    private List<EatingPlace> eatingPlaces;
    private List<RentTransport> rentTransports;
    private List<ResidentLocation> residentLocations;
    private List<Transportation> transportations;

    public Tour() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public List<GeneralInformation> getGeneralInformations() {
        return generalInformations;
    }
    public void setGeneralInformations(List<GeneralInformation> generalInformations) {
        this.generalInformations = generalInformations;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public List<EatingPlace> getEatingPlaces() {
        return eatingPlaces;
    }
    public void setEatingPlaces(List<EatingPlace> eatingPlaces) {
        this.eatingPlaces = eatingPlaces;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public List<RentTransport> getRentTransports() {
        return rentTransports;
    }
    public void setRentTransports(List<RentTransport> rentTransports) {
        this.rentTransports = rentTransports;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public List<ResidentLocation> getResidentLocations() {
        return residentLocations;
    }
    public void setResidentLocations(List<ResidentLocation> residentLocations) {
        this.residentLocations = residentLocations;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public List<Transportation> getTransportations() {
        return transportations;
    }
    public void setTransportations(List<Transportation> transportations) {
        this.transportations = transportations;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
