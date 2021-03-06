import java.util.ArrayList;

public class Jeu {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean termine = false;
		Joueur joueur = new Joueur(1,"gege", true);
		joueur.setCamp("rebelles");
		
		
		//Ensemble des territoires de la r�gion 1
		int coordonneesUniteTatooine [] = {1050,80};
		Territoires Tatooine = new Territoires("Tatooine",0,coordonneesUniteTatooine);
		int coordonneesUniteWayland [] = {955,165};
		Territoires Wayland = new Territoires("Wayland",1,coordonneesUniteWayland);
		int coordonneesUniteToprawa [] = {1275,110};
		Territoires Toprawa = new Territoires("Toprawa",2,coordonneesUniteToprawa);
		int coordonneesUniteDathomir [] = {1140,170};
		Territoires Dathomir = new Territoires("Dathomir",3,coordonneesUniteDathomir);
		int coordonneesUniteYavin4 [] = {1230,230};
		Territoires Yavin4 = new Territoires("Yavin4",4,coordonneesUniteYavin4);
		int coordonneesUniteDantooine [] = {1478,175};
		Territoires Dantooine = new Territoires("Dantooine",5,coordonneesUniteDantooine);
		int coordonneesUniteOrdmantell [] = {1325,310};
		Territoires Ordmantell = new Territoires("Ord Mantell",6,coordonneesUniteOrdmantell);
		int coordonneesUniteMoncalamari [] = {1520,300};
		Territoires Moncalamari = new Territoires("Mon Calamari",7,coordonneesUniteMoncalamari);
		
		ArrayList <Territoires> BordureExterieureListe = new ArrayList<Territoires>();
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
		
		
		
		//Ensemble des territoires de la r�gion 2
		int coordonneesUniteKashyyyk [] = {1270,430};
		Territoires Kashyyyk = new Territoires("Kashyyyk",8,coordonneesUniteKashyyyk);
		int coordonneesUniteKessel [] = {1540,450};
		Territoires Kessel = new Territoires("Kessel",9,coordonneesUniteKessel);
		int coordonneesUniteDasoochrV [] = {1375,495};
		Territoires DasoochrV = new Territoires("Da Soochr V",10,coordonneesUniteDasoochrV);
		int coordonneesUniteYlesia [] = {1500,585};
		Territoires Ylesia = new Territoires("Ylesia",11,coordonneesUniteYlesia);
		int coordonneesUniteToydaria [] = {1290,560};
		Territoires Toydaria = new Territoires("Toydaria",12,coordonneesUniteToydaria);
		int coordonneesUniteNarshadda [] = {1325,675};
		Territoires Narshadda = new Territoires("Nar Shadda",13,coordonneesUniteNarshadda);
		int coordonneesUniteBothawui [] = {1170,600};
		Territoires Bothawui = new Territoires("Bothawui",14,coordonneesUniteBothawui);
		int coordonneesUniteGamorr [] = {1130,730};
		Territoires Gamorr = new Territoires("Gamorr",15,coordonneesUniteGamorr);
		int coordonneesUniteKothlis [] = {1065,645};
		Territoires Kothlis = new Territoires("Kothlis",16,coordonneesUniteKothlis);
		int coordonneesUniteRodia [] = {960,710};
		Territoires Rodia = new Territoires("Rodia",17,coordonneesUniteRodia);
		int coordonneesUniteFalleen [] = {925,610};
		Territoires Falleen = new Territoires("Falleen",18,coordonneesUniteFalleen);
		
		
		ArrayList <Territoires> BordureMedianeListe = new ArrayList<Territoires>();
		BordureMedianeListe.add(Kashyyyk);
		BordureMedianeListe.add(Kessel);
		BordureMedianeListe.add(DasoochrV);
		BordureMedianeListe.add(Ylesia);
		BordureMedianeListe.add(Toydaria);
		BordureMedianeListe.add(Narshadda);
		BordureMedianeListe.add(Bothawui);
		BordureMedianeListe.add(Gamorr);
		BordureMedianeListe.add(Kothlis);
		BordureMedianeListe.add(Rodia);
		BordureMedianeListe.add(Falleen);

		
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
		

		
		//Ensemble des territoires de la r�gion 3
				int coordonneesUniteOmwat [] = {790,745};
				Territoires Omwat = new Territoires("Omwat",19,coordonneesUniteOmwat);
				int coordonneesUniteArbra [] = {960,820};
				Territoires Arbra = new Territoires("Arbra",20,coordonneesUniteArbra);
				int coordonneesUniteExcarga [] = {1005,910};
				Territoires Excarga = new Territoires("Excarga",21,coordonneesUniteExcarga);
				int coordonneesUniteElom [] = {800,880};
				Territoires Elom = new Territoires("Elom",22,coordonneesUniteElom);
				
				
				ArrayList <Territoires> EspaceSauvageListe = new ArrayList<Territoires>();
				EspaceSauvageListe.add(Omwat);
				EspaceSauvageListe.add(Arbra);
				EspaceSauvageListe.add(Excarga);
				EspaceSauvageListe.add(Elom);
				
				
				Regions EspaceSauvage = new Regions("Espace Sauvage", EspaceSauvageListe);
				
				Omwat.setProprietaire(joueur);
				Arbra.setProprietaire(joueur);
				Excarga.setProprietaire(joueur);
				Elom.setProprietaire(joueur);
				
				
		
				//Ensemble des t�rritoires de la r�gion 4
				int coordonneesUniteEndor [] = {425,560};
				Territoires Endor = new Territoires("Endor",23,coordonneesUniteEndor);
				int coordonneesUniteBespin [] = {315,625};
				Territoires Bespin = new Territoires("Bespin",24,coordonneesUniteBespin);
				int coordonneesUniteHoth [] = {190,690};
				Territoires Hoth = new Territoires("Hoth",25,coordonneesUniteHoth);
				int coordonneesUniteBakura [] = {215,500};
				Territoires Bakura = new Territoires("Bakura",26,coordonneesUniteBakura);
				
				
				ArrayList <Territoires> CorridorDisonListe = new ArrayList<Territoires>();
				CorridorDisonListe.add(Endor);
				CorridorDisonListe.add(Bespin);
				CorridorDisonListe.add(Hoth);
				CorridorDisonListe.add(Bakura);
				
				 
				Regions CorridorDison = new Regions("Corridor Dison", CorridorDisonListe);
				
				Endor.setProprietaire(joueur);
				Bespin.setProprietaire(joueur);
				Hoth.setProprietaire(joueur);
				Bakura.setProprietaire(joueur);
				
				
				//Ensemble des territoires de la r�gion 5
				
				int coordonneesUniteSullust [] = {545,670};
				Territoires Sullust = new Territoires("Sullust",27,coordonneesUniteSullust);
				int coordonneesUniteEriadu [] = {670,655};
				Territoires Eriadu = new Territoires("Eriadu",28,coordonneesUniteEriadu);
				int coordonneesUniteSluisvan [] = {625,770};
				Territoires Sluisvan = new Territoires("Sluis Van",29,coordonneesUniteSluisvan);
				int coordonneesUniteDerilyn [] = {435,820};
				Territoires Derilyn = new Territoires("Derilyn",30,coordonneesUniteDerilyn);
				int coordonneesUniteBpfassh [] = {575,920};
				Territoires Bpfassh = new Territoires("Bpfassh",31,coordonneesUniteBpfassh);
				int coordonneesUniteDagobah [] = {230,945};
				Territoires Dagobah = new Territoires("Dagobah",32,coordonneesUniteDagobah);
				
				
				ArrayList <Territoires> SecteurElroodListe = new ArrayList<Territoires>();
				SecteurElroodListe.add(Sullust);
				SecteurElroodListe.add(Eriadu);
				SecteurElroodListe.add(Sluisvan);
				SecteurElroodListe.add(Derilyn);
				SecteurElroodListe.add(Bpfassh);
				SecteurElroodListe.add(Dagobah);
				
				
				Regions SecteurElrood = new Regions("SecteurElrood", SecteurElroodListe);
				
				Sullust.setProprietaire(joueur);
				Eriadu.setProprietaire(joueur);
				Sluisvan.setProprietaire(joueur);
				Derilyn.setProprietaire(joueur);
				Bpfassh.setProprietaire(joueur);
				Dagobah.setProprietaire(joueur);
				

				
				//Ensemble des territoires de la r�gion 6
				
				int coordonneesUniteCoruscant [] = {650,450};
				Territoires Coruscant = new Territoires("Coruscant", 33, coordonneesUniteCoruscant);
				int coordonneesUniteCorrelia [] = {530,345};
				Territoires Correlia = new Territoires("Correlia", 34, coordonneesUniteCorrelia);
				int coordonneesUniteByss [] = {570,225};
				Territoires Byss = new Territoires("Byss", 35, coordonneesUniteByss);
				int coordonneesUniteMimban [] = {730,205};
				Territoires Mimban = new Territoires("Mimban", 36, coordonneesUniteMimban);
				int coordonneesUniteAlderaan [] = {840,280};
				Territoires Alderaan = new Territoires("Alderaan", 37, coordonneesUniteAlderaan);
				int coordonneesUniteHapes [] = {1000,330};
				Territoires Hapes = new Territoires("Hapes", 38, coordonneesUniteHapes);
				int coordonneesUniteKurt [] = {860,400};
				Territoires Kurt = new Territoires("Kurt", 39, coordonneesUniteKurt);
				int coordonneesUniteBalmorra [] = {990,440};
				Territoires Balmorra = new Territoires("Balmorra", 40, coordonneesUniteBalmorra);
				int coordonneesUniteDuro [] = {690,280};
				Territoires Duro = new Territoires("Duro", 41, coordonneesUniteDuro);
				
				ArrayList <Territoires> noyauGalactiqueListe = new ArrayList<Territoires>();
				noyauGalactiqueListe.add(Coruscant);
				noyauGalactiqueListe.add(Correlia);
				noyauGalactiqueListe.add(Byss);
				noyauGalactiqueListe.add(Mimban);
				noyauGalactiqueListe.add(Alderaan);
				noyauGalactiqueListe.add(Hapes);
				noyauGalactiqueListe.add(Kurt);
				noyauGalactiqueListe.add(Balmorra);
				noyauGalactiqueListe.add(Duro);
				
				Regions NoyauGalactique = new Regions("Noyau Galactique", noyauGalactiqueListe);
				
				Coruscant.setProprietaire(joueur);
				Correlia.setProprietaire(joueur);
				Byss.setProprietaire(joueur);
				Mimban.setProprietaire(joueur);
				Alderaan.setProprietaire(joueur);
				Hapes.setProprietaire(joueur);
				Kurt.setProprietaire(joueur);
				Balmorra.setProprietaire(joueur);
				Duro.setProprietaire(joueur);
				
				
		
		
		
		ArrayList <Regions> regions  = new ArrayList<Regions>();
		regions.add(BordureExterieure);
		regions.add(BordureMediane);
		regions.add(EspaceSauvage);
		regions.add(CorridorDison);
		regions.add(SecteurElrood);
		regions.add(NoyauGalactique);
		
		//matrice pour conna�tre le positionnement des territoires les uns par rapport aux autres
		int [][] adjMatrices = {
				{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //tatooine
				{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0}, //wayland
				{1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //toprawa
				{1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //dathomir
				{0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0}, //yavin4
				{0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //dantooine
				{0,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //ord mantell
				{0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}, //mon calamari
				{0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //kashyyk
				{0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //kessel
				{0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //da soochr v
				{0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1},
				{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,1,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0}
		};
		
		//La partie commence
		Partie partie = new Partie(0,regions, adjMatrices);
		Interface2 frame = new Interface2();
		frame.setVisible(true);
		partie.parametragePartie(frame);
		partie.ajouterMissions(partie.nbreJoueursTotal);
		partie.miseEnPlace();
		frame.affichageUniteCarteDebutPartie(partie);
		for(int i=0 ; i<partie.joueurs.size() ; i++) {
			if(partie.joueurs.get(i).Humain == true) {
				partie.joueurs.get(i).attributionRenfort(partie,frame);
			}
			else {
				partie.joueurs.get(i).renfortIA(partie);
				frame.affichageUniteCarte(partie);
			}
		}
		partie.tour++;
		while(!termine) {
			for(int i = 0 ; i<partie.joueurs.size(); i++) {
				//System.out.println("Le tour " + partie.tour + " est en cours !");
				//System.out.println("La mission du joueur " + partie.joueurs.get(i).numero + " est " + partie.joueurs.get(i).mission.enonce);
				//System.out.println("Le joueur poss�de "+partie.joueurs.get(1).armees.size()+ "unites");
				boolean issueTour = partie.tourJoueur(partie.joueurs.get(i), frame);
				if(issueTour==true) {
					//System.out.println("Le joueur poss�de "+partie.joueurs.get(1).armees.size()+ "unites");
					termine=partie.joueurs.get(i).verifVictoire();
					//System.out.println("Le joueur " + partie.joueurs.get(i).Pseudo + " poss�de " + partie.joueurs.get(i).territoires.size() + " territoires");
					//System.out.println("Le joueur " + partie.joueurs.get(i).Pseudo + " poss�de " + partie.joueurs.get(i).regions.size() + " regions");
					if(termine==true) {
						System.out.println(partie.joueurs.get(i).numero);
						System.out.println(partie.joueurs.get(i).mission.enonce);
						break;
					}
				}
			}
			partie.tour++;
		}
		
		System.out.println("Vicitoire");
		frame.victoire();
		
	}

}