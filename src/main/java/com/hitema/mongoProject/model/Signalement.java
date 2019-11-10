package com.hitema.mongoProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Signalement")
public class Signalement {
	@Id
	private String id;
	
	private String user;
	private String stationDepart;
	private String stationArrivee;
	
	public Signalement() {
		super();
	}

	public Signalement(String user, String stationDepart, String stationArrivee) {
		super();
		this.user = user;
		this.stationDepart = stationDepart;
		this.stationArrivee = stationArrivee;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStationDepart() {
		return stationDepart;
	}

	public void setStationDepart(String stationDepart) {
		this.stationDepart = stationDepart;
	}

	public String getStationArrivee() {
		return stationArrivee;
	}

	public void setStationArrivee(String stationArrivee) {
		this.stationArrivee = stationArrivee;
	}

	@Override
	public String toString() {
		return "Signalement [id=" + id + ", user=" + user + ", stationDepart=" + stationDepart + ", stationArrivee="
				+ stationArrivee + "]";
	}
}
