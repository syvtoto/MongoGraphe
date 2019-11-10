package com.hitema.mongoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AlgoService {
	
	public void displayGrapheToConsole(List<List<Integer>> _graphe) {
		// verif console
		System.out.print("/ ; "); 
		for(int y=0;y<_graphe.size();y++) {
			System.out.print(y+" ; "); 
		}
		System.out.println("");
		for(int y=0;y<_graphe.size();y++) {
			System.out.print(y+" ; "); 
			List<Integer> lInteger = _graphe.get(y);
			for(int z=0;z<lInteger.size();z++) {
				System.out.print(lInteger.get(z)+" ; "); 
			}
			System.out.println("");
		}
		
		System.out.println();
		System.out.println();
	}
	
	public List<List<Integer>> generateGraphe(int _nbPts) {
		// clear base AF
		int nbConnMin = 3;
		// initialisation de la matrice
		List<Integer> listInt = new ArrayList<Integer>();
		List<List<Integer>> graphe = new ArrayList<List<Integer>>();
		for(int i=0;i<_nbPts;i++) {
			listInt.add(0);
		}
		for(int i=0;i<_nbPts;i++) {
			graphe.add(listInt);
		}
		displayGrapheToConsole(graphe);
		// remplissage de la matrice
		for(int i=0;i<graphe.size();i++) {
			List<Integer> lInt = graphe.get(i);
			int nbConn = 0;
			List<Integer> lIndexConn = new ArrayList<Integer>();
			// récupération du nombre de connexion avec d'autres points
			for(int j=0; j<lInt.size();j++) {
				if(lInt.get(j) > 0) {
					nbConn++;
					lIndexConn.add(j);
				}
			}
			// si le nombre de connexion est infèrieur au minimum
			if(nbConn < nbConnMin) {
				// creation de la liste d'index
				List<Integer> listIndex = new ArrayList<Integer>();
				for(int l=0;l<_nbPts;l++) {
					listIndex.add(l);
				}
				System.out.println("listIndex @ init");
				System.out.println(listIndex.toString());
				// pas de connexion necessaire vers le point actuel
				listIndex.remove(i);
				// suppresion des index déja connectés
				for(int indexConn : lIndexConn) {
					listIndex.remove(listIndex.indexOf(indexConn));
				}
				System.out.println("listIndex @ after removeConnExist");
				System.out.println(listIndex.toString());
				int nbConnToCreate = nbConnMin-nbConn;
				for(int k=0;k<nbConnToCreate;k++) {
					// crée un connexion
					Random r = new Random();
					int indexListIndex = r.nextInt(listIndex.size());
					int indexConnToSet = listIndex.get(indexListIndex);
					System.out.println("index to set : "+indexConnToSet);
					lInt.set(indexConnToSet, 1);
					List<Integer> lInt2 = graphe.get(indexConnToSet);
					lInt2.set(i, 1);
					System.out.println("listIndex @ after connCreated");
					listIndex.remove(listIndex.indexOf(indexConnToSet));
					System.out.println(listIndex.toString());
					System.out.println();
					
					displayGrapheToConsole(graphe);
				}
			}
			
		}
//		displayGrapheToConsole(graphe);
		return graphe;
	}
}
