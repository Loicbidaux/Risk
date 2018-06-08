import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Joueur {
	int numero;
	String Pseudo;
	Missions mission;
	ArrayList <Unite> armees = new ArrayList<Unite>();
	ArrayList <Territoires> territoires = new ArrayList<Territoires>();
	ArrayList <Regions> regions = new ArrayList<Regions>();
	boolean Humain;
	int dernieresConquetes;
	String Couleur;
	String camp;
	ArrayList <Integer>joueursDetruits = new ArrayList<Integer>();
	ArrayList <Territoires> territoiresConquis = new ArrayList<Territoires>();
	int nbRenfort = 0;
	int flagFinDePhase =0 ;
	int flagValider =0 ;
	
	public Joueur(int numero, String pseudo, boolean humain) {
		super();
		this.numero = numero;
		this.Pseudo = pseudo;
		this.Humain = humain;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}

	public Missions getMission() {
		return mission;
	}

	public void setMission(Missions mission) {
		this.mission = mission;
	}

	public ArrayList<Unite> getArmees() {
		return armees;
	}

	public void setArmees(ArrayList<Unite> armees) {
		this.armees = armees;
	}

	public ArrayList<Territoires> getTerritoires() {
		return territoires;
	}

	public void setTerritoires(ArrayList<Territoires> territoires) {
		this.territoires = territoires;
	}
	
	public void setDernieresConquetes(int dernieresConquetes) {
		this.dernieresConquetes = dernieresConquetes;
	}
	
	public void setCamp(String camp) {
		this.camp = camp;
	}
	
	public int getNbRenfort() {
		return nbRenfort;
	}

	public void setNbRenfort(int nbRenfort) {
		this.nbRenfort = nbRenfort;
	}
	
	public void setFlagValider(int flagValider) {
		this.flagValider = flagValider;
	}
	
	public void setFlagFinDePhase(int flagFinDePhase) {
		this.flagFinDePhase = flagFinDePhase;
	}
	
	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	//on retourne "true" si le joueur a rempli la mission qui lui a été destinée
	public boolean missionRemplie(Missions mission) {
		CharSequence detruire = "Détruire";
		CharSequence territoire = "territoire";
		if(mission.enonce.contains(detruire)) {
			for(int i = 0 ; i<5 ; i++) {
				if(mission.enonce.charAt(19)==String.valueOf(i).charAt(0) && this.joueursDetruits.contains(i)) {
					return true;
				}
			}
		}
		
		else if(mission.enonce.contains(territoire)) {
			CharSequence tous = "tous";
			CharSequence dix_huit = "18";
			CharSequence vingt_un = "21";
			CharSequence vingt_quatre = "24";
			CharSequence trente = "30";
			if(mission.enonce.contains(tous)) {
				if(this.territoiresConquis.size()==42) {
					return true;
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(dix_huit)) {
				if(this.territoires.size()>=18) {
					CharSequence armee = "armée";
					int decompte = 18;
					if(mission.enonce.contains(armee)) {
						System.out.println(this.Pseudo + " possède bien les 18 territoires ...");
						for(int i = 0 ; i<this.territoires.size(); i++) {
							if(this.territoires.get(i).unites.size()>=2 && decompte >0) {
								decompte--;
							}
						}
						if(decompte==0) {
							return true;
						}
						else {
							return false;
						}
					}	
					else if(this.regions.size()>=3){
						return true;
					}
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(vingt_un)) {
				if(this.territoires.size()>=21) {
					System.out.println(this.Pseudo + " possède bien les 21 territoires ...");
					return true;
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(vingt_quatre)) {
				if(this.territoires.size()>=24) {
					System.out.println(this.Pseudo + " possède bien les 24 territoires ...");
					return true;
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(trente)) {
				if(this.territoires.size()>=30) {
					System.out.println(this.Pseudo + " possède bien les 30 territoires ...");
					return true;
				}
				else {
					return false;
				}
			}
		}
		else if(this.regions.size() >= 2){
			for(int i = 0 ; i<this.regions.size(); i++) {
				if(this.regions.get(i).territoires.size()==11) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	//on verifie si le joueur a gagne (= a tous les territoires ou mission remplie)
	public boolean verifVictoire() {
		if(this.territoires.size() == 42) {
			return true;
		}
		else if(this.missionRemplie(this.mission)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//on verifie si le joueur a perdu (= n'a plus de territoires
	public boolean verifDefaite() {
		if(this.territoires.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	//ajoute un soldat au joueur
	public void ajouterSoldat() {
		ArrayList <Unite> attaquants2 = new ArrayList<Unite>(this.getArmees());
		attaquants2.add(new Soldat(1,"Soldat"));
		this.setArmees(attaquants2);
	}
	
	//ajoute un cavalier au joueur
	public void ajouterCavalier() {
		ArrayList <Unite> attaquants2 = new ArrayList<Unite>(this.getArmees());
		attaquants2.add(new Cavalier(2,"Cavalier"));
		this.setArmees(attaquants2);
	}
	
	//ajoute un canon au joueur
	public void ajouterCanon() {
		ArrayList <Unite> attaquants2 = new ArrayList<Unite>(this.getArmees());
		attaquants2.add(new Canon(3,"Canon"));
		this.setArmees(attaquants2);
	}
	
	//calcul le nombre de renforts obtenus par les joueurs au debut de chaque tour
	public void appelRenforts() {
		int armeesRegion = 0;
		int territoiresRegion;
		int totalRenfort;
		
		//on calcule le nombre de renforts dus aux regions du joueur
		if(!this.regions.isEmpty()) {
			for(int i = 0 ; i < this.regions.size(); i++) {
				territoiresRegion = this.regions.get(i).territoires.size()/2;
				for(int j = 0 ; j < territoiresRegion ; j++) {
					armeesRegion++;
				}
			}
		}
		
		//on calcule le nombre total de renforts recus par le joueur
		
		totalRenfort = this.territoires.size()/4 + armeesRegion;
		for(int i = 0 ; i<this.dernieresConquetes ; i++) {
			totalRenfort += ThreadLocalRandom.current().nextInt(0, 2);
		}
		
		//si il a recu moins de 2 soldats, on lui en donne jusqu'a ce qu'il en ait eu 2
		while(totalRenfort <2) {
			totalRenfort++;
		}
		
		//on remet a zero le nombre de conquetes au tour precedent du joueur
		this.setDernieresConquetes(0);
		
		this.setNbRenfort(totalRenfort);
	}

	//permute 2 elements d'un tableau
	public static int [][] permute(int [][] tab, int a, int b) {
		int [] var;
		var=tab[a];
		tab[a]=tab[b];
		tab[b]=var;
		return tab;
	}
	
	//tri les elements d'un tableau dimension 2 en fonction de la première colonne, puis en fonction de la deuxieme
	public static void TriParSelection(int [][] tab) {
		for (int j=0 ; j<tab.length; j++)	{
			for (int i=j ; i<tab.length; i++)	{
				if (tab[i][0]>tab[j][0]) {
					tab=permute(tab,i,j);
				}
				else if(tab[i][0]==tab[j][0]) {
					if(tab[i][2]<=tab[j][2]) {
						tab=permute(tab,i,j);
					}
				}
			}
		}
	}
	
	
	//donne en sortie un tableau contenant les unites mortes pendant la bataille
	public Unite [][] issueBataille(ArrayList <Unite> defense, ArrayList <Unite> attaque) {
		int puissanceDefense [][] = new int[defense.size()][3];
		int puissanceAttaque [][] = new int[attaque.size()][3];
		int randomNum;
		int randomNum2;
		
		//on determine la puissance de chaque unité
		for(int i = 0 ; i< attaque.size();i++) {
			randomNum = ThreadLocalRandom.current().nextInt(attaque.get(i).puissance[0], attaque.get(i).puissance[attaque.get(i).puissance.length-1]);
			puissanceAttaque[i][0]=randomNum;
			puissanceAttaque[i][1]=i;
			puissanceAttaque[i][2]=attaque.get(i).attaque;
		}
		for(int i = 0 ; i<defense.size();i++) {
			randomNum2 = ThreadLocalRandom.current().nextInt(defense.get(i).puissance[0], defense.get(i).puissance[defense.get(i).puissance.length-1]);
			puissanceDefense[i][0]=randomNum2;
			puissanceDefense[i][1]=i;
			puissanceDefense[i][2]=defense.get(i).defense;
		}
		
		//on les trie
		TriParSelection(puissanceAttaque);
		TriParSelection(puissanceDefense);
		
		
		Unite unitesMortes [][] = new Unite[2][2];
		//les valeurs sont comparées pour le combat
		if(attaque.size() >= defense.size()) {
			for(int i = 0 ; i <defense.size(); i++) {
				System.out.println(attaque.get(puissanceAttaque[i][1]).nom + " attaque " + defense.get(puissanceDefense[i][1]).nom + " : " + puissanceAttaque[i][0] + " vs " + puissanceDefense[i][0]);
				if(puissanceAttaque[i][0]>puissanceDefense[i][0]) {
					System.out.println(defense.get(puissanceDefense[i][1]).nom + " est mort");
					unitesMortes[0][i] = defense.get(puissanceDefense[i][1]);
				}
				else if(puissanceDefense[i][0]>=puissanceAttaque[i][0]) {
					System.out.println(attaque.get(puissanceAttaque[i][1]).nom + " est mort");
					unitesMortes[1][i] = attaque.get(puissanceAttaque[i][1]);
				}
			}
		}
		else {
			for(int i = 0 ; i <attaque.size(); i++) {
				System.out.println(attaque.get(puissanceAttaque[i][1]).nom + " attaque " + defense.get(puissanceDefense[i][1]).nom + " : " + puissanceAttaque[i][0] + " vs " + puissanceDefense[i][0]);
				if(puissanceAttaque[i][0]>puissanceDefense[i][0]) {
					System.out.println(defense.get(puissanceDefense[i][1]).nom + " est mort");
					unitesMortes[0][i] = defense.get(puissanceDefense[i][1]);
				}
				else if(puissanceDefense[i][0]>=puissanceAttaque[i][0]) {
					System.out.println(attaque.get(puissanceAttaque[i][1]).nom + " est mort");
					unitesMortes[1][i] = attaque.get(puissanceAttaque[i][1]);
				}
			}
		}
		return unitesMortes;
	}
	
	//on deplace les unites d'un territoire à l'autre, et on les fatigue
	protected void deplacerUnites(Territoires territoireOrigine, Territoires territoireCible, ArrayList <Unite> unitesDeplacees) {
		if(territoireCible.proprietaire == this) {	
			for(int i = 0 ; i<unitesDeplacees.size(); i++) {
				unitesDeplacees.get(i).fatigue();
				unitesDeplacees.get(i).verifDisponibilite();
				territoireOrigine.unites.remove(unitesDeplacees.get(i));
				territoireCible.unites.add(unitesDeplacees.get(i));
			}
		}
	}	
	
	
	//toutes les unites du joueur recuperent leurs forces
	protected void reposTroupes() {
		for(int i = 0 ; i<this.territoires.size(); i++) {
			for(int j = 0 ; j<this.territoires.get(i).unites.size(); j++) {
				this.territoires.get(i).unites.get(j).revigoree();
			}
		}
	}

	//en fonction de "issueBataille" enleve les unites mortes aux joueurs et aux territoires, change les proprietaires de territoire ...
	public void resultatsBataille(Unite unitesMortes [][], Territoires territoireDef, Territoires territoireAtk, ArrayList<Unite> unitesAtk, Partie partie) {
		//on enleve les unites de defense mortes de leur territoire
		for(int i = 0  ; i<unitesMortes[0].length ; i++) {
			territoireDef.unites.remove(unitesMortes[0][i]);
			territoireDef.proprietaire.armees.remove(unitesMortes[0][i]);
		}
		//si la population du territoire attaquee est reduite à 0
		if(territoireDef.unites.size() == 0) {
			//on enleve ce territoire de la liste des territoires du joueur defenseur
			territoireDef.proprietaire.territoires.remove(territoireDef);
			Regions regionTerritoireDef = territoireDef.appartenanceRegionTerritoire(partie);
			regionTerritoireDef.appartenanceRegionJoueur(territoireDef.proprietaire);
			
			//on verifie si le joueur defenseur a completement perdu. Si oui on l'ajoute aux joueurs detruits par l'attaquant
			if(territoireDef.proprietaire.territoires.size()==0) {
				this.joueursDetruits.add(territoireDef.proprietaire.numero);
			}
			//on change le proprietaire, on deplace les attaquants dans le nouveau territoire et on regarde si le nouveau proprietaire possede la region entiere
			territoireDef.proprietaire = this;
			this.territoires.add(territoireDef);
			this.territoiresConquis.add(territoireDef);
			this.dernieresConquetes++;
			regionTerritoireDef.appartenanceRegionJoueur(this);
			
			//on fait les echanges d'unite entre les territoires
			for(int i = 0 ; i<unitesAtk.size() ; i++) {
				territoireDef.unites.add(unitesAtk.get(i));
				territoireAtk.unites.remove(unitesAtk.get(i));
				unitesAtk.get(i).fatigue();
				unitesAtk.get(i).verifDisponibilite();
			}
			//on enleve les unites attaquantes mortes
			for(int i = 0 ; i<unitesMortes[1].length ; i++) {
				territoireDef.unites.remove(unitesMortes[1][i]);
				this.armees.remove(unitesMortes[1][i]);
			}
		}
		
		
		// on enleve les unites attaquantes mortes
		else {
			for(int i = 0 ; i<unitesMortes[1].length ; i++) {
				territoireAtk.unites.remove(unitesMortes[1][i]);
				this.armees.remove(unitesMortes[1][i]);
			}
		}
	}
	
	
	//boucle pour l'attribution des unites
	public void attributionRenfort(Partie partie,Interface2 frame) {
		while(flagFinDePhase == 0) {
			this.boucleAttributionRenfort(partie,frame);
			while(flagValider ==0) {
				if(flagFinDePhase==1) {flagValider=1;}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			flagValider=0;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setFlagFinDePhase(0);
		frame.refreshCarte();
	}
	
	public void boucleAttributionRenfort(Partie partie ,Interface2 frame) {
		frame.refreshCarte();
		frame.affichageUniteCarte(partie);
		if(partie.tour == 0) {
			frame.affichageRenfortDebutPartie(this);
			if(this.nbRenfort == 0) {
				frame.affichageBtnFinDePhase(this);
				frame.repaint();
				frame.validate();
			}
		}
		else if(partie.tour>1){
			frame.affichageRenfort(this);
			if(this.nbRenfort == 0) {
				frame.affichageBtnFinDePhase(this);
				frame.repaint();
				frame.validate();
			}
		}
		else {
			this.setFlagFinDePhase(1); //garder un oeil là dessus
		}
	}
	
	
	//boucle pour les actions du joueur (hors renfort)
	public void actionJoueur(Partie partie, Interface2 frame) {
		while(flagFinDePhase == 0) {
			this.boucleTourJoueur(partie, frame);
			while(flagValider == 0) {
				if(this.flagFinDePhase==1) {
					flagValider=1;
				}
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			flagValider=0;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flagFinDePhase =0;
		frame.refreshCarte();
	}
	
	public void boucleTourJoueur(Partie partie, Interface2 frame) {
		frame.refreshCarte();
		frame.affichageUniteCarte(partie);
		frame.choixAttaqueDeplacement(partie, this);
	}
	
	
	//renforts attribués par l'ia
	public void renfortIA(Partie partie) {
		Regions regionVisee = null;
		ArrayList <Integer> territoiresParRegion = new ArrayList<Integer>();
		//on stocke le nombre de territoires alliés par region dans l'arraylist
		for(int j = 0 ; j < partie.regions.size(); j++) {
			territoiresParRegion.add(0);
			for(int i = 0 ; i < this.territoires.size(); i++) {
				if(partie.regions.get(j).territoires.contains(this.territoires.get(i))) {
					territoiresParRegion.set(j, territoiresParRegion.get(j)+1);
				}
			}
		}
		
		
		
		int max;
		int indiceMax;
		boolean flagRegionsPossedees = false;
		
		//on recupere l'indice de la region qui est le plus occupée par le joueur, ou la deuxieme si la premiere est totalement occupee, etc
		while(regionVisee == null || this.regions.contains(regionVisee)) {
			max=0;
			indiceMax = 0;
			for(int i = 0 ; i < territoiresParRegion.size() ; i++) {
				if(territoiresParRegion.get(i)>max) {
					max = territoiresParRegion.get(i);
					indiceMax = i;
				}
			}
			if(territoiresParRegion.get(indiceMax)==0) {
				System.out.println("J'ai tous les territoires");
				flagRegionsPossedees = true;
				break;
			}
			territoiresParRegion.set(indiceMax, 0);
			regionVisee = partie.regions.get(indiceMax);
		}
		
		if(flagRegionsPossedees == true) {
			regionVisee = this.regions.get(0);
		}
		
		indiceMax = partie.regions.indexOf(regionVisee);		
		int nbRenfortRestant = this.nbRenfort;
		int nbVoisinsEnnemis;
		
		//on atttribue les renforts aux territoires de la region selectionnee qui ont une frontiere avec un ennemi
		while(nbRenfortRestant != 0) {
			for(int i = 0 ; i < regionVisee.territoires.size() ; i++) {
				nbVoisinsEnnemis = 0;
				for(int j = 0 ; j < regionVisee.territoires.get(i).voisinsTerritoire(partie).size(); j++) {
					if(!this.territoires.contains(regionVisee.territoires.get(i).voisinsTerritoire(partie).get(j))) {
						nbVoisinsEnnemis ++;
					}
				}
				if(partie.regions.get(indiceMax).territoires.get(i).proprietaire == this && nbVoisinsEnnemis !=0) {
					if(nbRenfortRestant>0 && nbVoisinsEnnemis != 0){
						this.ajouterSoldat();
						partie.regions.get(indiceMax).territoires.get(i).ajouterSoldat();
						nbRenfortRestant --;
					}
				}
			}		
		}			
		this.setNbRenfort(0);
	}
	
	
	//fonction de deplacement d'unites par l'ia   NE FONCTIONNE PAS
	public void deplacementIA(Partie partie) {
		ArrayList <Unite> unitesDeplacees = new ArrayList<Unite>();
		int [] tableauNbVoisinsEnnemis = new int[this.territoires.size()];
		boolean deplacementsPossibles = true;
		
		for(int i = 0 ; i< this.territoires.size(); i++) {
			for(int j = 0 ; j < this.territoires.get(i).voisinsTerritoire(partie).size(); j++) {
				if(!this.territoires.contains(this.territoires.get(i).voisinsTerritoire(partie).get(j)) && this.territoires.get(i).unites.size()>1) {
					 tableauNbVoisinsEnnemis[i]++;
				}
			}
		}
		
		while(deplacementsPossibles) {
			Territoires territoireCible = null;
			Territoires territoireOrigine = null;
			for(int i = 0 ; i < tableauNbVoisinsEnnemis.length ; i++) {
				if(tableauNbVoisinsEnnemis[i] == 0 && this.territoires.get(i).unites.size()>1 && territoireCible == null) {
					territoireOrigine = new Territoires(this.territoires.get(i).nom, this.territoires.get(i).numero, this.territoires.get(i).unites, this.territoires.get(i).proprietaire);
				}
				else if(tableauNbVoisinsEnnemis[i] == 0 && this.territoires.get(i).unites.size()>1 && territoireCible != null && this.territoires.get(i).voisinsTerritoire(partie).contains(territoireCible)) {
					territoireOrigine = new Territoires(this.territoires.get(i).nom, this.territoires.get(i).numero, this.territoires.get(i).unites, this.territoires.get(i).proprietaire);
				}
				else if(tableauNbVoisinsEnnemis[i] != 0 && territoireOrigine != null && this.territoires.get(i).voisinsTerritoire(partie).contains(territoireOrigine) ) {
					territoireCible = new Territoires(this.territoires.get(i).nom, this.territoires.get(i).numero, this.territoires.get(i).unites, this.territoires.get(i).proprietaire);
				}
				else if(tableauNbVoisinsEnnemis[i] != 0 && territoireOrigine == null) {
					territoireCible = new Territoires(this.territoires.get(i).nom, this.territoires.get(i).numero, this.territoires.get(i).unites, this.territoires.get(i).proprietaire);
				}
				if(territoireCible != null && territoireOrigine != null) {;
					break;
				}
			}
			
			if(territoireCible != null && territoireOrigine != null) {
				for(int i = 0 ; i < territoireOrigine.unites.size()-1; i++) {
					if(territoireOrigine.unites.get(i).disponibilite!=0) {
						unitesDeplacees.add(territoireOrigine.unites.get(i));
					}
				}
				
				System.out.println("Taille origine avant : " + territoireOrigine.unites.size());
				System.out.println("Taille cible avant : " + territoireCible.unites.size());
				
				this.deplacerUnites(territoireOrigine, territoireCible, unitesDeplacees);
				
				System.out.println("Taille origine après : " + territoireOrigine.unites.size());
				System.out.println("Taille cible après : " + territoireCible.unites.size());
				
				unitesDeplacees.clear();
			}
			else {
				//System.out.println("Pas de deplacement utile");
				deplacementsPossibles = false;
			}
		}
	}
	
	
	//fonction d'attaque par l'ia
	public void attaqueIA(Partie partie) {
		ArrayList <Unite> unitesAttaque = new ArrayList<Unite>();
		ArrayList <Unite> unitesDefense = new ArrayList<Unite>();
		boolean attaqueEffectuee = false;
		boolean attaquesPossibles = true;
		
		//les territoires alliés qui sont voisins avec un ennemi attaquent leur voisin s'il a un cout total superieur ou égal
		while(attaquesPossibles) {
			attaqueEffectuee = false;
			for(int i = 0 ; i< this.territoires.size(); i++) {
				for(int j = 0 ; j < this.territoires.get(i).voisinsTerritoire(partie).size(); j++) {
					if(!this.territoires.contains(this.territoires.get(i).voisinsTerritoire(partie).get(j)) && this.territoires.get(i).coutTotal() >= this.territoires.get(i).voisinsTerritoire(partie).get(j).coutTotal()+1 && this.territoires.get(i).unites.size()>2) {
						 unitesAttaque = this.territoires.get(i).unitesAtkIA();
						 unitesDefense = this.territoires.get(i).voisinsTerritoire(partie).get(j).unitesDef(unitesAttaque.size());
						 Unite [][] unitesMortes = this.issueBataille(unitesDefense, unitesAttaque);
						 this.resultatsBataille(unitesMortes, this.territoires.get(i).voisinsTerritoire(partie).get(j), this.territoires.get(i), unitesAttaque,partie);
						 attaqueEffectuee = true;
					}
				}
			}
			if(!attaqueEffectuee) {
				attaquesPossibles=false;
			}
		}
	}
}
