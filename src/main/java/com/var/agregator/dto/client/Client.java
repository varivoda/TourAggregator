package com.var.agregator.dto.client;

import com.var.agregator.dto.tour.Tour;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable{


	private int id;
	private String password;
	private String fullName;
	private String email;
	private List<TripPreferences> tripPreferences;
	private List<Tour> tours;


	public Client() {
		id = 0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	public int getId() {
		return id;
	}
	public void setId(int clientId) {
		this.id = clientId;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "email")
	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;	}

	@OneToMany(cascade = CascadeType.ALL,
			   mappedBy = "client", fetch = FetchType.EAGER)
	public List<TripPreferences> getTripPreferences() {
		return tripPreferences;
	}
	public void setTripPreferences(List<TripPreferences> tripPreferences) {
		this.tripPreferences = tripPreferences;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.EAGER)
	public List<Tour> getTours(){
		return tours;
	}

	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
}
