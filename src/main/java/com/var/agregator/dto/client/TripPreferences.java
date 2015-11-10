package com.var.agregator.dto.client;

import java.util.Date;

import com.var.agregator.dto.enums.HotelKind;
import com.var.agregator.dto.enums.TransportKind;
import com.var.agregator.dto.enums.TripDocuments;

public class TripPreferences {

	private long id;
	private long idClient;
	private int touristsQuantity;
	private long budget;
	private Date departureDate;
	private Date arrivalDate;
	private TransportKind transportKind;
	private HotelKind residentHotelKind;
	private TripDocuments tripDocuments;

	public TripPreferences(){}



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

	public HotelKind getResidentHotelKind() {
		return residentHotelKind;
	}

	public void setResidentHotelKind(HotelKind residentHotelKind) {
		this.residentHotelKind = residentHotelKind;
	}

	public int getTouristsQuantity() {
		return touristsQuantity;
	}
	public void setTouristsQuantity(int touristsQuantity) {
		this.touristsQuantity = touristsQuantity;
	}
	public long getBudget() {
		return budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
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
	public TransportKind getTransportKind() {
		return transportKind;
	}
	public void setTransportKind(TransportKind transportKind) {
		this.transportKind = transportKind;
	}
	public HotelKind getLocation() {
		return residentHotelKind;
	}
	public void setLocation(HotelKind hotelKind) {
		this.residentHotelKind = hotelKind;
	}
	public TripDocuments getTripDocuments() {
		return tripDocuments;
	}
	public void setTripDocuments(TripDocuments tripDocuments) {
		this.tripDocuments = tripDocuments;
	}
	
}
