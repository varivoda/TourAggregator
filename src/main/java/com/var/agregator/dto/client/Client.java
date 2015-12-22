package com.var.agregator.dto.client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable{


	private int clientId;
//	private String login;
	private String password;
	private String fullName;
	private String email;
	private List<TripPreferences> tripPreferences;


	public Client() {
		clientId = 0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

//	@Column(name = "login")
//	public String getLogin() {
//		return login;
//	}
//	public void setLogin(String login) {
//		this.login = login;
//	}

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
}
