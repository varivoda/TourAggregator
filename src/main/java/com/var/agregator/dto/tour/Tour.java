package com.var.agregator.dto.tour;

import com.var.agregator.dto.client.Client;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by ivan on 10.11.15.
 */
@Entity
@Table(name = "tour")
public class Tour {

    private int id;
    private Client client;
    private Set<GeneralInformation> generalInformations;
    private Set<EatingPlace> eatingPlaces;
    private Set<RentTransport> rentTransports;
    private Set<ResidentLocation> residentLocations;
    private Set<Transportation> transportations;

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
    public Set<GeneralInformation> getGeneralInformations() {
        return generalInformations;
    }
    public void setGeneralInformations(Set<GeneralInformation> generalInformations) {
        this.generalInformations = generalInformations;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public Set<EatingPlace> getEatingPlaces() {
        return eatingPlaces;
    }
    public void setEatingPlaces(Set<EatingPlace> eatingPlaces) {
        this.eatingPlaces = eatingPlaces;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public Set<RentTransport> getRentTransports() {
        return rentTransports;
    }
    public void setRentTransports(Set<RentTransport> rentTransports) {
        this.rentTransports = rentTransports;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public Set<ResidentLocation> getResidentLocations() {
        return residentLocations;
    }
    public void setResidentLocations(Set<ResidentLocation> residentLocations) {
        this.residentLocations = residentLocations;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    public Set<Transportation> getTransportations() {
        return transportations;
    }
    public void setTransportations(Set<Transportation> transportations) {
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
