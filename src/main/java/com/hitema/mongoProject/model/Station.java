package com.hitema.mongoProject.model;

import org.springframework.data.annotation.Id;

public class Station {
	@Id
	private String id;
	
	private String nom;
	private String alias;
	private StationLigne ligne;
	
	public Station() {
		super();
	}

	public Station(String nom, String alias, StationLigne ligne) {
		super();
		this.nom = nom;
		this.alias = alias;
		this.ligne = ligne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public StationLigne getLigne() {
		return ligne;
	}

	public void setLigne(StationLigne ligne) {
		this.ligne = ligne;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", nom=" + nom + ", alias=" + alias + ", ligne=" + ligne + "]";
	}
}
