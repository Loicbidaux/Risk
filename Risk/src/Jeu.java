import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.awt.event.*;

public class Jeu {
	
	public void menuPrincipal() {
		StdDraw.setCanvasSize(1352,720);
		StdDraw.picture(0.5,0.5,"avantMenu.png");
		if(StdDraw.isKeyPressed(49)) {	
			System.out.println("Ca marche");
			StdDraw.clear();
			StdDraw.filledRectangle(0, 0, 30, 40);
		}
	}
	
	private void menuOption() {
		
	}
	
	private void menuPartie() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu plateau = new Jeu();
		boolean termine = false;
		
		int coordonneesKenya [][] = {{0,0},{0,1}};
		int coordonneesZimbabwe [][] = {{1,0},{1,1}};
		int coordonneesEgypte [][] = {{2,0},{2,1}};
		Territoires territoire1 = new Territoires("Kenya", coordonneesKenya,0);
		Territoires territoire2 = new Territoires("Zimbabwe", coordonneesZimbabwe,1);
		Territoires territoire6 = new Territoires("Egypte", coordonneesEgypte,2);
		ArrayList <Territoires> territoires1 = new ArrayList();
		territoires1.add(territoire1);
		territoires1.add(territoire2);
		territoires1.add(territoire6);
		int adjMatriceAfrique [][] = {{0,1,1},{1,0,1},{1,1,0}};
		Regions region1 = new Regions("Afrique", territoires1);
		region1.setAdjMatrices(adjMatriceAfrique);
		
		int coordonneesChine [][] = {{3,0},{3,1}};
		int coordonneesJapon [][] = {{4,0},{4,1}};
		int coordonneesCoree [][] = {{5,0},{5,1}};
		Territoires territoire3 = new Territoires("Chine", coordonneesChine,0);
		Territoires territoire4 = new Territoires("Japon", coordonneesJapon,1);
		Territoires territoire5 = new Territoires("Corée", coordonneesCoree,2);
		ArrayList <Territoires> territoires2 = new ArrayList();
		territoires2.add(territoire3);
		territoires2.add(territoire4);
		territoires2.add(territoire5);
		int adjMatriceAsie [][] = {{0,1,1},{1,0,1},{1,1,0}};
		Regions region2 = new Regions("Asie", territoires2);
		region2.setAdjMatrices(adjMatriceAsie);
		
		
		ArrayList <Regions> regions  = new ArrayList();
		regions.add(region1);
		regions.add(region2);
		
		
		Missions mission1 = new Missions("Tuer", 1, 1, "Mission Tuer");
		Missions mission2 = new Missions("Sauver", 1, 1, "Mission Sauver");
		ArrayList <Missions> missionsDispo = new ArrayList();
		missionsDispo.add(mission1);
		missionsDispo.add(mission2);
		
		Partie partie = new Partie(0,4,4, missionsDispo, regions);
		partie.miseEnPlace();
		while(!termine) {
			for(int i = 0 ; i < partie.nbreJoueursTotal ; i++) {
				partie.tourJoueur(partie.joueurs.get(i));
				if(partie.joueurs.get(i).verifVictoire()) {
					termine = true;
				}
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(partie.joueurs.get(0).numero);
		System.out.println(partie.joueurs.get(0).mission.titre);
		System.out.println(partie.joueurs.get(0).territoires.size());
		System.out.println(partie.joueurs.get(0).territoires.get(0).nom);
		System.out.println(partie.joueurs.get(0).armees.size());
		System.out.println("");
		System.out.println(partie.joueurs.get(1).numero);
		System.out.println(partie.joueurs.get(1).mission.titre);
		System.out.println(partie.joueurs.get(1).territoires.size());
		System.out.println(partie.joueurs.get(1).territoires.get(0).nom);
		System.out.println(partie.joueurs.get(1).armees.size());
		System.out.println("");
		System.out.println(partie.joueurs.get(2).numero);
		System.out.println(partie.joueurs.get(2).mission.titre);
		System.out.println(partie.joueurs.get(2).territoires.size());
		System.out.println(partie.joueurs.get(2).territoires.get(0).nom);
		System.out.println(partie.joueurs.get(2).armees.size());
		System.out.println("");
		System.out.println(partie.joueurs.get(3).numero);
		System.out.println(partie.joueurs.get(3).mission.titre);
		System.out.println(partie.joueurs.get(3).territoires.size());
		System.out.println(partie.joueurs.get(3).territoires.get(0).nom);
		System.out.println(partie.joueurs.get(3).armees.size());
	}

}