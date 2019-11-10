package com.hitema.mongoProject.model;

public class StationLigne {
	private String ligne;
	private String type;
	private String station_pre;
	private String station_suiv;
	
	public StationLigne() {
		super();
	}
	
	public StationLigne(String ligne, String type, String station_pre, String station_suiv) {
		super();
		this.ligne = ligne;
		this.type = type;
		this.station_pre = station_pre;
		this.station_suiv = station_suiv;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStation_pre() {
		return station_pre;
	}

	public void setStation_pre(String station_pre) {
		this.station_pre = station_pre;
	}

	public String getStation_suiv() {
		return station_suiv;
	}

	public void setStation_suiv(String station_suiv) {
		this.station_suiv = station_suiv;
	}

	@Override
	public String toString() {
		return "StationLigne [ligne=" + ligne + ", type=" + type + ", station_pre=" + station_pre + ", station_suiv="
				+ station_suiv + "]";
	}
}
