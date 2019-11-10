package com.hitema.mongoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitema.mongoProject.dao.ConnexionRepo;
import com.hitema.mongoProject.dao.StationRepo;
import com.hitema.mongoProject.dao.UserRepo;
import com.hitema.mongoProject.model.Connexion;
import com.hitema.mongoProject.model.Station;
import com.hitema.mongoProject.model.StationLigne;

@Service
public class DataService {
	@Autowired
    private StationRepo stationRepo;
	
	@Autowired
    private UserRepo userRepo;
	
	@Autowired
    private ConnexionRepo connexionRepo;
	
	public void addStation(String _nom, String _alias, StationLigne _stationLigne) {
		Station stationToAdd = new Station(_nom, _alias, _stationLigne);
		stationRepo.save(stationToAdd);
	}
	
	public void addConnexion(String _stationDepart, String _stationArrivee, String _poids) {
		connexionRepo.save(new Connexion(_stationDepart, _stationArrivee, _poids));
	}
	
	public void clearStationColl() {
		stationRepo.deleteAll();
	}
	
	public void clearUserColl() {
		userRepo.deleteAll();
	}
	
	public void clearConnexionColl() {
		connexionRepo.deleteAll();
	}
	
	public void saveGraphe(int[][] _graphe, String[] _listStation) {
		this.clearConnexionColl();
		this.clearStationColl();
		// ajpout des stations vers mongo
		for(int i=0;i<_listStation.length;i++) {
			this.addStation(_listStation[i], _listStation[i], new StationLigne("A", "noType", null, null));
		}
		// ajout des connexions vers mongo
		for(int i=0;i<_graphe.length;i++) {
			for(int j=0;j<_graphe[i].length;j++) {
				if(_graphe[i][j] > 0) {
					this.addConnexion(_listStation[i], _listStation[j], String.valueOf(_graphe[i][j]));
				}
			}
		}
	}
	
	public List<Station> getAllStations() {
		List<Station> allStations = stationRepo.findAll();
		return allStations;
	}
	
	public int[][] getGraphe() {
		List<Connexion> allConns = connexionRepo.findAll();
		List<Station> allStations = stationRepo.findAll();
		int[][] graphe = new int[allStations.size()][allStations.size()];
		for(int i=0;i<allStations.size();i++) {
			int[] listInt = new int[allStations.size()];
			for(int j=0;j<allStations.size();j++) {
				listInt[i] = 0;
			}
			graphe[i] = listInt;
		}
		for(Connexion conn: allConns) {
			String dep = conn.getStationDepart();
			String arr = conn.getStationArrivee();
			int indexDep = -1;
			int indexArr = -1;
			for(Station station : allStations) {
		        if(station.getNom().equals(dep)) {
		        	indexDep = allStations.indexOf(station);
		        }
		    }
			for(Station station : allStations) {
		        if(station.getNom().equals(arr)) {
		        	indexArr = allStations.indexOf(station);
		        }
		    }
			graphe[indexDep][indexArr] = Integer.valueOf(conn.getPoids());
		}
		return graphe;
	}
}
