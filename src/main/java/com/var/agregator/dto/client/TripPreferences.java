package com.var.agregator.dto.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "trip_preferences")
public class TripPreferences implements Serializable {

	private int id;
	private Client client;
	private int travelersQuantity;
	private BigDecimal budget;
	private Date departureDate;
	private Date arrivalDate;
	private String transportKind;
	private String residentHotelKind;
	private String tripDocumentType;

	public TripPreferences(){
		id = 0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_preference_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "resident_hotel_kind")
	public String getResidentHotelKind() {
		return residentHotelKind;
	}
	public void setResidentHotelKind(String residentHotelKind) {
		this.residentHotelKind = residentHotelKind;
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
//	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH},
//			fetch = FetchType.EAGER)

	@Column(name = "transport_kind")
	public String getTransportKind() {
		return transportKind;
	}
	public void setTransportKind(String transportKind) {
		this.transportKind = transportKind;
	}

	@Column(name = "trip_document")
	public String getTripDocumentType() {
		return tripDocumentType;
	}
	public void setTripDocumentType(String tripDocumentType) {
		this.tripDocumentType = tripDocumentType;
	}
	
}
