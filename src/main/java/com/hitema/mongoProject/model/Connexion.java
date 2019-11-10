package com.hitema.mongoProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Connexion")
public class Connexion {
	@Id
	private String id;
	
	private String stationDepart;
	private String stationArrivee;
	private String poids;
	
	public Connexion() {
		super();
	}

	public Connexion(String stationDepart, String stationArrivee, String poids) {
		super();
		this.stationDepart = stationDepart;
		this.stationArrivee = stationArrivee;
		this.poids = poids;
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

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Connexion [id=" + id + ", stationDepart=" + stationDepart + ", stationArrivee=" + stationArrivee
				+ ", poids=" + poids + "]";
	}
}
