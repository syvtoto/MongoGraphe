package com.hitema.mongoProject.controller;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hitema.mongoProject.model.Station;
import com.hitema.mongoProject.model.StationLigne;
import com.hitema.mongoProject.service.AlgoService;
import com.hitema.mongoProject.service.DataService;

@Controller
public class Control {
	
	@Autowired
    private AlgoService algoService;
	
	@Autowired
    private DataService dataService;
	
	@GetMapping("/graphe")
	public String createAndGetGraphe(Model model) {
		int tailleGraphe = 10;
		List<Integer> lInteg = new ArrayList<Integer>();
		for(int l=0;l<tailleGraphe;l++) {
			lInteg.add(l);
		}
		model.addAttribute("pts",lInteg);

		model.addAttribute("graphe", algoService.generateGraphe(tailleGraphe));
		return "graphe";
	}
	
	@GetMapping("/addStation")
	public String createAndAddStation(Model model) {
		dataService.addStation("FirstStation", "A", new StationLigne("A", "Mine", null, null));
		model.addAttribute("textToDisplay","station created");
		return "default";
	}
	
	@GetMapping("/createNsaveGraphe")
	public String createNsaveGraphe(Model model) {
		int[][] graphe = algoService.generateGraphe(10);
		dataService.saveGraphe(graphe, algoService.generateListStation(graphe.length));
		model.addAttribute("textToDisplay","graphe saved to mongo");
		return "default";
	}
	
	@GetMapping("/getAllStations")
	public String getAllStations(Model model) {
		List<Station> allStations = dataService.getAllStations();
		System.out.println(allStations.toString());
		model.addAttribute("textToDisplay","getting all stations");
		return "default";
	}
	
	@GetMapping("/getGraphe")
	public String getGraphe(Model model) {
		int[][] graphe = dataService.getGraphe();
		System.out.println(graphe.toString());
		model.addAttribute("textToDisplay","getting graphe");
		return "default";
	}
}
