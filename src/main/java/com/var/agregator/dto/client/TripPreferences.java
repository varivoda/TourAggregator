package com.var.agregator.dto.client;

import java.util.Date;

import com.var.agregator.dto.enums.Location;
import com.var.agregator.dto.enums.Transport;
import com.var.agregator.dto.enums.TripDocuments;

public class TripPreferences {
	
	private int quantityOfTourists;
	private double budget;
	private Date departureDate;
	private Date arrivalDate;
	private Transport transport;
	private Location residentLocation;
	private TripDocuments tripDocuments;
	
	public int getQuantityOfTourists() {
		return quantityOfTourists;
	}
	public void setQuantityOfTourists(int quantityOfTourists) {
		this.quantityOfTourists = quantityOfTourists;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
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
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	public Location getLocation() {
		return residentLocation;
	}
	public void setLocation(Location location) {
		this.residentLocation = location;
	}
	public TripDocuments getTripDocuments() {
		return tripDocuments;
	}
	public void setTripDocuments(TripDocuments tripDocuments) {
		this.tripDocuments = tripDocuments;
	}
	
}
