package com.hitema.mongoProject.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hitema.mongoProject.service.AlgoService;

@Controller
public class Control {

	@Autowired
	private AlgoService algoService;
	
	@GetMapping("/index")
	public String index(Model model,
			@RequestParam(name="start", required = false, defaultValue = "start")String start,
			@RequestParam(name="end", required = false, defaultValue = "end")String end) {
		int tailleGraphe = 10;
		ArrayList<Integer> lInteg = new ArrayList<Integer>();
		for(int l=0;l<tailleGraphe;l++) {
			lInteg.add(l);
		}
		model.addAttribute("pts",lInteg);
		model.addAttribute("graphe", algoService.generateGraphe(tailleGraphe));
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "index";
	}

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
}
