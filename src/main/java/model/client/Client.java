package model.client;

import model.tour.Tour;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client implements Serializable{


	private int id;
	private String password;
	private String fullName;
	private String email;
	private Set<TripPreferences> tripPreferences;
	private Set<Tour> tours;


	public Client() {
		id = 0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
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
	public Set<TripPreferences> getTripPreferences() {
		return tripPreferences;
	}
	public void setTripPreferences(Set<TripPreferences> tripPreferences) {
		this.tripPreferences = tripPreferences;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client",  fetch = FetchType.EAGER)
	public Set<Tour> getTours(){
		return tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}
}
