package com.hitema.mongoProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

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
		// initialisation de la matrice
		int[] listInt = new int[_nbPts];
		int[][] graphe = new int[_nbPts][_nbPts];
		for(int i=0;i<_nbPts;i++) {
			listInt[i] = 0;
		}
		for(int i=0;i<_nbPts;i++) {
			graphe[i] = listInt;
		}
		displayGrapheToConsole(graphe);
		// remplissage de la matrice
//		for(int i=0;i<graphe.length;i++) {
//			int[] lInt = graphe[i];
//			int nbConn = 0;
//			List<Integer> lIndexConn = new ArrayList<Integer>();
//			// récupération du nombre de connexion avec d'autres points
//			for(int j=0; j<lInt.length;j++) {
//				if(lInt[j] > 0) {
//					nbConn++;
//					lIndexConn.add(j);
//				}
//			}
//			// si le nombre de connexion est infèrieur au minimum
//			if(nbConn < nbConnMin) {
//				// creation de la liste d'index
//				List<Integer> listIndex = new ArrayList<Integer>();
//				for(int l=0;l<_nbPts;l++) {
//					listIndex.add(l);
//				}
//				System.out.println("listIndex @ init");
//				System.out.println(listIndex.toString());
//				// pas de connexion necessaire vers le point actuel
//				listIndex.remove(i);
//				// suppresion des index déja connectés
//				for(int indexConn : lIndexConn) {
//					listIndex.remove(listIndex.indexOf(indexConn));
//				}
//				System.out.println("listIndex @ after removeConnExist");
//				System.out.println(listIndex.toString());
//				int nbConnToCreate = nbConnMin-nbConn;
//				Random r = new Random();
//				for(int k=0;k<nbConnToCreate;k++) {
//					// crée un connexion
//					int indexListIndex = r.nextInt(listIndex.size());
//					int indexConnToSet = listIndex.get(indexListIndex);
//					System.out.println("index to set : "+indexConnToSet);
//					graphe[i][indexConnToSet] = 1;
////					lInt.set(indexConnToSet, 1);
////					graphe.set(i, lInt);
////					List<Integer> lInt2 = graphe.get(indexConnToSet);
////					lInt2.set(i, 1);
//					System.out.println("listIndex @ after connCreated");
//					listIndex.remove(listIndex.indexOf(indexConnToSet));
//					System.out.println(listIndex.toString());
//					System.out.println();
//					
//					displayGrapheToConsole(graphe);
//				}
//			}
//			
//		}
		graphe[4][1] = 1;
		displayGrapheToConsole(graphe);
		return graphe;
	}
	
	public List<Integer> calculChemin() {
		return null;
	}
}
