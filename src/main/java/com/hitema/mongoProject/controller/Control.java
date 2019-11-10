package com.hitema.mongoProject.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hitema.mongoProject.model.StationLigne;
import com.hitema.mongoProject.service.AlgoService;
import com.hitema.mongoProject.service.DataService;

@Controller
public class Control {

	@Autowired
	private AlgoService algoService;
	
	@GetMapping("/index")
	public String index(Model model,
			@RequestParam(name="start", required = false)String start,
			@RequestParam(name="end", required = false)String end,
			@RequestParam(name="nbPoint", required = false, defaultValue = "10" )int nbPoint) {
		ArrayList<Integer> lInteg = new ArrayList<Integer>();
		for(int l=0;l<nbPoint;l++) {
			lInteg.add(l);
		}
		model.addAttribute("pts",lInteg);		
		model.addAttribute("graphe", algoService.generateGraphe(nbPoint));
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("nbPoint", nbPoint);
		return "index";
	}

	@Autowired
    private DataService dataService;
	
	
	@GetMapping("/graphe")
	public String createAndGetGraphe(Model model) {
		int tailleGraphe = 10;
		ArrayList<Integer> lInteg = new ArrayList<Integer>();
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
}
