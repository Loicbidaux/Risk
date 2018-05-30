import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.awt.event.*;

public class Jeu {
	
	/*public void menuPrincipal() {
		StdDraw.setCanvasSize(1352,720);
		StdDraw.picture(0.5,0.5,"avantMenu.png");
		if(StdDraw.isKeyPressed(49)) {	
			System.out.println("Ca marche");
			StdDraw.clear();
			StdDraw.filledRectangle(0, 0, 30, 40);
		}
	}*/
	
	private void menuOption() {
		
	}
	
	private void menuPartie() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu plateau = new Jeu();
		boolean termine = false;
		Joueur joueur = new Joueur(1,"gege", true,"red");
		joueur.setCamp("rebelles");
		
		
		//Ensemble des térritoires de la région 1
		int coordonneesUniteTatooine [] = {1050,80};
		Territoires Tatooine = new Territoires("Tatooine",0,coordonneesUniteTatooine);
		int coordonneesUniteWayland [] = {955,165};
		Territoires Wayland = new Territoires("Wayland",1,coordonneesUniteWayland);
		int coordonneesUniteToprawa [] = {1275,110};
		Territoires Toprawa = new Territoires("Toprawa",2,coordonneesUniteToprawa);
		int coordonneesUniteDathomir [] = {1140,165};
		Territoires Dathomir = new Territoires("Dathomir",3,coordonneesUniteDathomir);
		int coordonneesUniteYavin4 [] = {1230,230};
		Territoires Yavin4 = new Territoires("Yavin4",4,coordonneesUniteYavin4);
		int coordonneesUniteDantooine [] = {1415,175};
		Territoires Dantooine = new Territoires("Dantooine",5,coordonneesUniteDantooine);
		int coordonneesUniteOrdmantell [] = {1325,310};
		Territoires Ordmantell = new Territoires("Ord Mantell",6,coordonneesUniteOrdmantell);
		int coordonneesUniteMoncalamari [] = {1520,300};
		Territoires Moncalamari = new Territoires("Mon Calamari",7,coordonneesUniteMoncalamari);
		
		ArrayList <Territoires> BordureExterieureListe = new ArrayList();
		BordureExterieureListe.add(Tatooine);
		BordureExterieureListe.add(Wayland);
		BordureExterieureListe.add(Toprawa);
		BordureExterieureListe.add(Dathomir);
		BordureExterieureListe.add(Yavin4);
		BordureExterieureListe.add(Dantooine);
		BordureExterieureListe.add(Ordmantell);
		BordureExterieureListe.add(Moncalamari);
		
		Regions BordureExterieure = new Regions("Bordure Exterieure", BordureExterieureListe);
		
		Tatooine.setProprietaire(joueur);
		Wayland.setProprietaire(joueur);
		Toprawa.setProprietaire(joueur);
		Dathomir.setProprietaire(joueur);
		Yavin4.setProprietaire(joueur);
		Dantooine.setProprietaire(joueur);
		Ordmantell.setProprietaire(joueur);
		Moncalamari.setProprietaire(joueur);
		
		/*int adjMatriceBordureExterieure [][] = {{0,1,1},{1,0,1},{1,1,0}};
		BordureExterieure.setAdjMatrices(adjMatriceBordureExterieure);*/
		
		
		//Ensemble des térritoires de la région 2
		int coordonneesUniteKashyyyk [] = {1270,430};
		Territoires Kashyyyk = new Territoires("Kashyyyk",0,coordonneesUniteKashyyyk);
		int coordonneesUniteKessel [] = {1540,450};
		Territoires Kessel = new Territoires("Kessel",1,coordonneesUniteKessel);
		int coordonneesUniteDasoochrV [] = {1375,495};
		Territoires DasoochrV = new Territoires("Da Soochr V",2,coordonneesUniteDasoochrV);
		int coordonneesUniteYlesia [] = {1500,585};
		Territoires Ylesia = new Territoires("Ylesia",3,coordonneesUniteYlesia);
		int coordonneesUniteToydaria [] = {1290,560};
		Territoires Toydaria = new Territoires("Toydaria",4,coordonneesUniteToydaria);
		int coordonneesUniteNarshadda [] = {1325,675};
		Territoires Narshadda = new Territoires("Nar Shadda",5,coordonneesUniteNarshadda);
		int coordonneesUniteBothawui [] = {1170,600};
		Territoires Bothawui = new Territoires("Bothawui",6,coordonneesUniteBothawui);
		int coordonneesUniteGamorr [] = {1130,730};
		Territoires Gamorr = new Territoires("Gamorr",7,coordonneesUniteGamorr);
		int coordonneesUniteKothlis [] = {1065,645};
		Territoires Kothlis = new Territoires("Kothlis",7,coordonneesUniteKothlis);
		int coordonneesUniteRodia [] = {960,710};
		Territoires Rodia = new Territoires("Rodia",7,coordonneesUniteRodia);
		int coordonneesUniteFalleen [] = {925,610};
		Territoires Falleen = new Territoires("Falleen",7,coordonneesUniteFalleen);
		
		
		ArrayList <Territoires> BordureMedianeListe = new ArrayList();
		BordureExterieureListe.add(Kashyyyk);
		BordureExterieureListe.add(Kessel);
		BordureExterieureListe.add(DasoochrV);
		BordureExterieureListe.add(Ylesia);
		BordureExterieureListe.add(Toydaria);
		BordureExterieureListe.add(Narshadda);
		BordureExterieureListe.add(Bothawui);
		BordureExterieureListe.add(Gamorr);
		BordureExterieureListe.add(Kothlis);
		BordureExterieureListe.add(Rodia);
		BordureExterieureListe.add(Falleen);

		
		Regions BordureMediane = new Regions("Bordure Mediane", BordureMedianeListe);
		
		Kashyyyk.setProprietaire(joueur);
		Kessel.setProprietaire(joueur);
		DasoochrV.setProprietaire(joueur);
		Ylesia.setProprietaire(joueur);
		Toydaria.setProprietaire(joueur);
		Narshadda.setProprietaire(joueur);
		Bothawui.setProprietaire(joueur);
		Gamorr.setProprietaire(joueur);
		Kothlis.setProprietaire(joueur);
		Rodia.setProprietaire(joueur);
		Falleen.setProprietaire(joueur);
		
		/*int adjMatriceBordureMediane [][] = {{0,1,1},{1,0,1},{1,1,0}};
		BordureMediane.setAdjMatrices(adjMatriceBordureMediane);*/
		
		//Ensemble des térritoires de la région 3
				int coordonneesUniteOmwat [] = {790,745};
				Territoires Omwat = new Territoires("Omwat",0,coordonneesUniteOmwat);
				int coordonneesUniteArbra [] = {960,820};
				Territoires Arbra = new Territoires("Arbra",1,coordonneesUniteArbra);
				int coordonneesUniteExcarga [] = {1005,910};
				Territoires Excarga = new Territoires("Excarga",2,coordonneesUniteExcarga);
				int coordonneesUniteElom [] = {800,880};
				Territoires Elom = new Territoires("Elom",3,coordonneesUniteElom);
				
				
				ArrayList <Territoires> EspaceSauvageListe = new ArrayList();
				EspaceSauvageListe.add(Omwat);
				EspaceSauvageListe.add(Arbra);
				EspaceSauvageListe.add(Excarga);
				EspaceSauvageListe.add(Elom);
				
				
				Regions EspaceSauvage = new Regions("Espace Sauvage", EspaceSauvageListe);
				
				Omwat.setProprietaire(joueur);
				Arbra.setProprietaire(joueur);
				Excarga.setProprietaire(joueur);
				Elom.setProprietaire(joueur);
				
				
				/*int adjMatriceEspaceSauvage [][] = {{0,1,1},{1,0,1},{1,1,0}};
				EspaceSauvage.setAdjMatrices(adjMatriceEspaceSauvage);*/
				
		
				//Ensemble des térritoires de la région 4
				int coordonneesUniteEndor [] = {425,560};
				Territoires Endor = new Territoires("Endor",0,coordonneesUniteEndor);
				int coordonneesUniteBespin [] = {315,625};
				Territoires Bespin = new Territoires("Bespin",1,coordonneesUniteBespin);
				int coordonneesUniteHoth [] = {190,690};
				Territoires Hoth = new Territoires("Hoth",2,coordonneesUniteHoth);
				int coordonneesUniteBakura [] = {215,500};
				Territoires Bakura = new Territoires("Bakura",3,coordonneesUniteBakura);
				
				
				ArrayList <Territoires> CorridorDisonListe = new ArrayList();
				CorridorDisonListe.add(Endor);
				CorridorDisonListe.add(Bespin);
				CorridorDisonListe.add(Hoth);
				CorridorDisonListe.add(Bakura);
				
				 
				Regions CorridorDison = new Regions("Corridor Dison", CorridorDisonListe);
				
				Endor.setProprietaire(joueur);
				Bespin.setProprietaire(joueur);
				Hoth.setProprietaire(joueur);
				Bakura.setProprietaire(joueur);
				
				
				/*int adjMatriceCorridorDison [][] = {{0,1,1},{1,0,1},{1,1,0}};
				CorridorDison.setAdjMatrices(adjMatriceCorridorDison);*/
				
		
		
		
		ArrayList <Regions> regions  = new ArrayList();
		regions.add(BordureExterieure);
		regions.add(BordureMediane);
		regions.add(EspaceSauvage);
		regions.add(CorridorDison);
		
		Missions mission1 = new Missions("Tuer", 1, 1, "Mission Tuer");
		Missions mission2 = new Missions("Sauver", 1, 1, "Mission Sauver");
		ArrayList <Missions> missionsDispo = new ArrayList();
		missionsDispo.add(mission1);
		missionsDispo.add(mission2);
		
		int tableau [] = {1,1};
		int puissCavalier [] = {2,3,4,5,6,7};
		int puissCanon [] = {4,5,6,7,8,9};
		Unite soldatA = new Soldat(1,tableau,1,1,1,1,1,"soldatA");
		Unite cavalierA = new Unite(3,puissCavalier,1,3,3,1,2, "CavalierA" );
		Unite canonA = new Unite(7,puissCanon,3,2,1,1,3, "CanonA");
		
		Unite soldatD = new Soldat(1,tableau,1,1,1,1,4, "SoldatD");
		Unite cavalierD = new Unite(3,puissCavalier,1,3,3,1,5, "CavalierD");
		Unite canonD = new Unite(7,puissCanon,3,2,1,1,6, "CanonD");
		
		
		ArrayList <Unite> attaquants = new ArrayList<Unite>();
		attaquants.add(soldatA);
		attaquants.add(1, cavalierA);
		attaquants.add(2, canonA);
		
		
		Tatooine.setUnites(attaquants);
		Wayland.setUnites(attaquants);
		Toprawa.setUnites(attaquants);
		Dathomir.setUnites(attaquants);
		Yavin4.setUnites(attaquants);
		Dantooine.setUnites(attaquants);
		Ordmantell.setUnites(attaquants);
		Moncalamari.setUnites(attaquants);
		
		Kashyyyk.setUnites(attaquants);
		Kessel.setUnites(attaquants);
		DasoochrV.setUnites(attaquants);
		Ylesia.setUnites(attaquants);
		Toydaria.setUnites(attaquants);
		Narshadda.setUnites(attaquants);
		Bothawui.setUnites(attaquants);
		Gamorr.setUnites(attaquants);
		Kothlis.setUnites(attaquants);
		Rodia.setUnites(attaquants);
		Falleen.setUnites(attaquants);
		
		Omwat.setUnites(attaquants);
		Arbra.setUnites(attaquants);
		Excarga.setUnites(attaquants);
		Elom.setUnites(attaquants);
		
		Endor.setUnites(attaquants);
		Bespin.setUnites(attaquants);
		Hoth.setUnites(attaquants);
		Bakura.setUnites(attaquants);
		//attaquants.add(canonA);
		
		ArrayList <Unite> defenseurs = new ArrayList();
		//defenseurs.add(soldatD);
		defenseurs.add(cavalierD);
		defenseurs.add(canonD);
		
		Partie partie = new Partie(0,4,4, missionsDispo, regions);
		Interface frame = new Interface();
		frame.setVisible(true);
		frame.affichageUniteCarte(partie);
		/*joueur.issueBataille(defenseurs, attaquants);
		partie.miseEnPlace();
		//while(!termine) {
			for(int i = 0 ; i < partie.nbreJoueursTotal ; i++) {
				partie.tourJoueur(partie.joueurs.get(i));
				//if(partie.joueurs.get(i).verifVictoire()) {
					//termine = true;
				//}
			}
		//}
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
		System.out.println(partie.joueurs.get(3).armees.size());*/
	}

}