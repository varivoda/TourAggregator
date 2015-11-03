package com.var.agregator.dto.client;

public class Client {
	
	private PersonalData personalData;
	private TripPreferences tripPreferences;
	
	
	public Client(PersonalData pd, TripPreferences pl) {
		tripPreferences = pl;
		personalData = pd;
	}
	
	
	public TripPreferences getTripPreferences() {
		return tripPreferences;
	}

	public void setTripPreferences(TripPreferences tripPreferences) {
		this.tripPreferences = tripPreferences;
	}


	public PersonalData getPersonalData() {
		return personalData;
	}


	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

}
