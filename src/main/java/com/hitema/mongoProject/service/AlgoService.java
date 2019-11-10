package com.hitema.mongoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

@Service
public class AlgoService {
	
	public void displayGrapheToConsole(int[][] _graphe) {
		// verif console
		System.out.print("/ ; "); 
		for(int y=0;y<_graphe.length;y++) {
			System.out.print(y+" ; "); 
		}
		System.out.println("");
		for(int y=0;y<_graphe.length;y++) {
			System.out.print(y+" ; "); 
			int[] lInteger = _graphe[y];
			for(int z=0;z<lInteger.length;z++) {
				System.out.print(lInteger[z]+" ; "); 
			}
			System.out.println("");
		}
		
		System.out.println();
		System.out.println();
	}
	
	public int[][] generateGraphe(int _nbPts) {
		// clear base AF
		int nbConnMin = 3;
		// random nb conn poss
		// initialisation de la matrice
		int[][] graphe = new int[_nbPts][_nbPts];
		for(int i=0;i<_nbPts;i++) {
			int[] listInt = new int[_nbPts];
			for(int j=0;j<_nbPts;j++) {
				listInt[i] = 0;
			}
			graphe[i] = listInt;
		}
		displayGrapheToConsole(graphe);
		// remplissage de la matrice
		for(int i=0;i<graphe.length;i++) {
			int[] lInt = graphe[i];
			int nbConn = 0;
			List<Integer> lIndexConn = new ArrayList<Integer>();
			// récupération du nombre de connexion avec d'autres points
			for(int j=0; j<lInt.length;j++) {
				if(lInt[j] > 0) {
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
				Random r = new Random();
				for(int k=0;k<nbConnToCreate;k++) {
					// crée un connexion
					int indexListIndex = r.nextInt(listIndex.size());
					int indexConnToSet = listIndex.get(indexListIndex);
					System.out.println("index to set : "+indexConnToSet);
					graphe[i][indexConnToSet] = 1;
					System.out.println("listIndex @ after connCreated");
					listIndex.remove(listIndex.indexOf(indexConnToSet));
					System.out.println(listIndex.toString());
					System.out.println();
					
					displayGrapheToConsole(graphe);
				}
			}
			
		}
		displayGrapheToConsole(graphe);
		return graphe;
	}
	
	public List<Integer> calculChemin() {
		return null;
	}

	public String generateString(int count) {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public String[] generateListStation(int _nbStations) {
		String[] listStations = new String[_nbStations];
		for(int i=0;i<listStations.length;i++) {
			listStations[i] = this.generateString(8);
		}
		return listStations;
	}
}