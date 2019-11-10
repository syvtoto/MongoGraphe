package com.hitema.mongoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AlgoService {
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
				int nbConnToCreate = nbConnMin-nbConn;
				for(int k=0;k<nbConnToCreate;k++) {
					// crée un connexion
					List<Integer> listIndex = new ArrayList<Integer>();
					for(int l=0;l<_nbPts;l++) {
						listIndex.add(l);
					}
					for(int indexConn : lIndexConn) {
						listIndex.remove(indexConn);
					}
					Random r = new Random();
					int indexConnToSet = r.nextInt(listIndex.size()+1);
					graphe.get(i).set(indexConnToSet, 1);
					graphe.get(indexConnToSet).set(i, 1);
				}
			}
			
		}
		// verif console TODO
		System.out.print("/ ; "); 
		for(int y=0;y<graphe.size();y++) {
			System.out.print(y+" ; "); 
		}
		System.out.println("");
		for(int y=0;y<graphe.size();y++) {
			System.out.print(y+" ; "); 
			List<Integer> lInteger = graphe.get(y);
			for(int z=0;z<lInteger.size();z++) {
				System.out.print(lInteger.get(z)+" ; "); 
			}
			System.out.println("");
		}
		return graphe;
	}
}
