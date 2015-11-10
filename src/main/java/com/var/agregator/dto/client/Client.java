package com.var.agregator.dto.client;

import java.util.List;

public class Client {

	private long id;
	private String login;
	private String password;
	private String fullName;
	private String email;
	private List<TripPreferences> tripPreferences;


	public Client() {}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<TripPreferences> getTripPreferences() {
		return tripPreferences;
	}

	public void setTripPreferences(List<TripPreferences> tripPreferences) {
		this.tripPreferences = tripPreferences;
	}
}
