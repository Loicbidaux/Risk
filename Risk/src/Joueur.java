import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Joueur {
	int numero;
	String Pseudo;
	Missions mission;
	ArrayList <Unite> armees = new ArrayList();
	ArrayList <Territoires> territoires = new ArrayList();
	ArrayList <Regions> regions = new ArrayList();
	boolean Humain;
	int dernieresConquetes;
	String Couleur;
	String camp;
	ArrayList joueursDetruits = new ArrayList();
	ArrayList <Territoires> territoiresConquis = new ArrayList();
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
				if(this.territoires.size()==18) {
					CharSequence armee = "armée";
					if(mission.enonce.contains(armee)) {
						for(int i = 0 ; i<this.territoires.size(); i++) {
							if(this.territoires.get(i).unites.size()!=2) {
								return false;
							}
						}
						return true;
					}	
					else if(this.regions.size()==3){
						return true;
					}
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(vingt_un)) {
				if(this.territoires.size()==21) {
					return true;
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(vingt_quatre)) {
				if(this.territoires.size()==24) {
					return true;
				}
				else {
					return false;
				}
			}
			else if(mission.enonce.contains(trente)) {
				if(this.territoires.size()==30) {
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
	
	public boolean verifDefaite() {
		if(this.territoires.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Territoires selectionTerritoire() { //a faire
		/*int tab [][] = {{1,0},{0,1}};
		Territoires territoireSelec = new Territoires("test",tab,0);
		return territoireSelec;*/
		
		return this.territoires.get(0);
	}
	
	public void ajouterSoldat() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getArmees());
		attaquants2.add(new Soldat(1,"Soldat"));
		this.setArmees(attaquants2);
	}
	
	public void ajouterCavalier() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getArmees());
		attaquants2.add(new Cavalier(2,"Cavalier"));
		this.setArmees(attaquants2);
	}
	
	public void ajouterCanon() {
		ArrayList <Unite> attaquants2 = new ArrayList(this.getArmees());
		attaquants2.add(new Canon(3,"Canon"));
		this.setArmees(attaquants2);
	}
	
	public int appelRenforts() {
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
		
		/*//on lui ajoute ces soldats
		for(int i = 0 ; i < totalRenfort ; i++) {
			this.ajouterSoldat();
		}*/
		
		//si il a recu moins de 2 soldats, on lui en donne jusqu'a ce qu'il en ait eu 2
		while(totalRenfort <2) {
			//this.ajouterSoldat();
			totalRenfort++;
		}
		
		//on remet a zero le nombre de conquetes au tour precedent du joueur
		this.setDernieresConquetes(0);
		
		return totalRenfort;
	}
	
	public ArrayList <Unite> choixUnitesCombat(Territoires territoire) {
		boolean finSelecUnite = false;
		ArrayList <Unite> unitesAttaque = new ArrayList();
		while(!finSelecUnite) {
			/*if(clique sur +) {
				unitesAttaque.add(e);
			}
			else if(clique sur -) {
				unitesAttaque.remove(e);
			}
			else if(clique sur CONFIRMER) {
				for(int i = 0; i < unitesAttaque.size() ; i++) {
					unitesAttaque.get(i).bataille()
				}
			}*/
		}
	}
	
	public static int [] permute(int [] tab, int a, int b) {
		int var;
		var=tab[a];
		tab[a]=tab[b];
		tab[b]=var;
		return tab;
	}
	
	public static void TriParSelection(int [] tab) {
		for (int j=0 ; j<tab.length; j++)	{
			for (int i=j ; i<tab.length; i++)	{
				if (tab[i]>=tab[j]) {
					tab=permute(tab,i,j);
				}
			}
		}
	}
	
	public Unite [][] issueBataille(ArrayList <Unite> defense, ArrayList <Unite> attaque) {
		int puissanceDefense [] = new int[defense.size()];
		int puissanceAttaque [] = new int[attaque.size()];
		int randomNum;
		int randomNum2;
		
		//on determine la puissance de chaque unité
		for(int i = 0 ; i< attaque.size();i++) {
			randomNum = ThreadLocalRandom.current().nextInt(attaque.get(i).puissance[0], attaque.get(i).puissance[attaque.get(i).puissance.length-1]);
			puissanceAttaque[i]=randomNum;
		}
		for(int i = 0 ; i<defense.size();i++) {
			randomNum2 = ThreadLocalRandom.current().nextInt(defense.get(i).puissance[0], defense.get(i).puissance[defense.get(i).puissance.length-1]);
			puissanceDefense[i]=randomNum2;
		}
		
		//on les trie
		TriParSelection(puissanceAttaque);
		TriParSelection(puissanceDefense);
		
		
		Unite unitesMortes [][] = new Unite[2][4];
		//les valeurs sont comparées pour le combat
		if(attaque.size() >= defense.size()) {
			for(int i = 0 ; i <defense.size(); i++) {
				System.out.println(attaque.get(i).nom + " attaque " + defense.get(i).nom + " : " + puissanceAttaque[i] + " vs " + puissanceDefense[i]);
				if(puissanceAttaque[i]>puissanceDefense[i]) {
					System.out.println(defense.get(i).nom + " est mort");
					unitesMortes[0][i] = defense.get(i);
				}
				else if(puissanceDefense[i]>puissanceAttaque[i]) {
					System.out.println(attaque.get(i).nom + " est mort");
					unitesMortes[1][i] = attaque.get(i);
				}
				else if(defense.get(i).defense > attaque.get(i).attaque) {
					System.out.println(defense.get(i).nom + " est mort");
					unitesMortes[0][i] = defense.get(i);
				}
				else if(attaque.get(i).attaque > defense.get(i).defense) {
					System.out.println(attaque.get(i).nom + " est mort");
					unitesMortes[1][i] = attaque.get(i);
				}
				else {
					randomNum = ThreadLocalRandom.current().nextInt(0, 2);
					if(randomNum==1) {
						System.out.println(attaque.get(i).nom + " est mort");
						unitesMortes[1][i] = attaque.get(i);
					}
					else {
						System.out.println(defense.get(i).nom + " est mort");
						unitesMortes[0][i] = defense.get(i);
					}
				}
			}
		}
		else {
			for(int i = 0 ; i <attaque.size(); i++) {
				System.out.println(attaque.get(i).nom + " attaque " + defense.get(i).nom + " : " + puissanceAttaque[i] + " vs " + puissanceDefense[i]);
				if(puissanceAttaque[i]>puissanceDefense[i]) {
					System.out.println(defense.get(i).nom + " est mort");
					unitesMortes[0][i] = defense.get(i);
				}
				else if(puissanceDefense[i]>puissanceAttaque[i]) {
					System.out.println(attaque.get(i).nom + " est mort");
					unitesMortes[1][i] = attaque.get(i);
				}
				else if(defense.get(i).defense > attaque.get(i).attaque) {
					System.out.println(defense.get(i).nom + " est mort");
					unitesMortes[0][i] = defense.get(i);
				}
				else if(attaque.get(i).attaque > defense.get(i).defense) {
					System.out.println(attaque.get(i).nom + " est mort");
					unitesMortes[1][i] = attaque.get(i);
				}
				else {
					randomNum = ThreadLocalRandom.current().nextInt(0, 2);
					if(randomNum==1) {
						System.out.println(attaque.get(i).numero + " est mort");
						unitesMortes[1][i] = attaque.get(i);
					}
					else {
						System.out.println(defense.get(i).numero + " est mort");
						unitesMortes[0][i] = defense.get(i);
					}
				}
			}
		}
		return unitesMortes;
	}
	
	protected void reposTroupes() {
		for(int i = 0 ; i<this.territoires.size(); i++) {
			for(int j = 0 ; j<this.territoires.get(i).unites.size(); j++) {
				System.out.println(this.territoires.get(i).nom);
				System.out.println(this.territoires.get(i).unites.get(j).nom);
				this.territoires.get(i).unites.get(j).revigoree();
			}
		}
	}
	public void action(Partie partie) {
		boolean fin = false;
		Territoires  territoireSelec;
		ArrayList <Territoires> voisins = new ArrayList();
		ArrayList <Territoires> allies = new ArrayList();
		ArrayList <Territoires> ennemis = new ArrayList();
		
		while(!fin) {
			//le joueur choisit un territoire
			territoireSelec = this.selectionTerritoire();
			System.out.println("Pays sélectionné :");
			System.out.println("      " + territoireSelec.nom);
			System.out.println("");
			//on regarde les territoires voisins
			voisins = territoireSelec.voisinsTerritoire(partie);
			//on indique que le joueur ne peut pas jouer depuis ce territoire car il n'a qu'une unite
			if(territoireSelec.unites.size()==1 && this.territoires.contains(territoireSelec)) {
				System.out.println("Pas d'actions possibles depuis ce territoire");
			}
			//si ce territoire lui appartient on trie si les voisins sont allies ou ennemis
			else if(this.territoires.contains(territoireSelec)) {
				for(int i = 0 ; i < voisins.size(); i++) {
					if(this.territoires.contains(voisins.get(i))) {
						allies.add(voisins.get(i));
					}	
					else {
						ennemis.add(voisins.get(i));
					}
				}
				
				System.out.println("Deplacer des unités vers :");
				if(allies.size()!=0) {
					for(int i = 0 ; i < allies.size() ; i++) {
						System.out.println("      " + allies.get(i).nom);
					}
				}
				else {
					System.out.println("      Pas de frontière commune avec un pays allié.");
				}
				
				System.out.println("");
				if(ennemis.size()!=0) {
					System.out.println("Attaquer :");
					for(int i = 0 ; i < ennemis.size() ; i++) {
						System.out.println("      " + ennemis.get(i).nom);
					}
				}
				else {
					System.out.println("      Pas de frontière commune avec un pays ennemi.");
				}
				System.out.println("---------------------------");
				System.out.println("---------------------------");
				
				/*//choisir une des options puis lancer attaque ou deplacement sur territoireCible
					//attaque :
					//ne marche sans doute PAS
						Territoires territoireCible = ..... ;
						int indiceDefense = 0;
						int indiceAttaque = 1;
						ArrayList <Unite> attaquants = this.choixUnitesCombat(territoireSelec);
						ArrayList <Unite> defenseurs = territoireCible.unitesDef(attaquants.size());
						Unite resultat [][]= issueBataille(defenseurs, attaquants);
						for(int i = 0  ; i<resultat[0].length ; i++) {
							territoireCible.unites.remove(resultat[0][i]);
							territoireCible.proprietaire.armees.remove(resultat[0][i]);
						}
						if(territoireCible.unites.size() == 0) {
							territoireCible.proprietaire = this;
							territoireCible.unites.addAll(attaquants);
							for(int i = 0 ; i<resultat[1].length ; i++) {
								territoireCible.unites.remove(resultat[1][i]);
								territoireCible.proprietaire.armees.remove(resultat[1][i]);
							}
						}
						else {
							for(int i = 0 ; i<resultat[1].length ; i++) {
								territoireSelec.unites.remove(resultat[1][i]);
								this.armees.remove(resultat[1][i]);
							}
						}*/		
			}
			
			voisins.clear();
			allies.clear();
			ennemis.clear();
			fin = true;
		}
	}
	
	public void resultatsBataille(Unite unitesMortes [][], Territoires territoireDef, Territoires territoireAtk, ArrayList<Unite> unitesAtk) {
		for(int i = 0  ; i<unitesMortes[0].length ; i++) {
			territoireDef.unites.remove(unitesMortes[0][i]);
			territoireDef.proprietaire.armees.remove(unitesMortes[0][i]);
		}
		if(territoireDef.unites.size() == 0) {
			territoireDef.proprietaire = this;
			this.territoires.add(territoireDef);
			
			for(int i = 0 ; i<unitesAtk.size() ; i++) {
				territoireDef.unites.add(unitesAtk.get(i));
				territoireAtk.unites.remove(unitesAtk.get(i));
				unitesAtk.get(i).fatigue();
				unitesAtk.get(i).verifDisponibilite();
			}
			for(int i = 0 ; i<unitesMortes[1].length ; i++) {
				territoireDef.unites.remove(unitesMortes[1][i]);
				this.armees.remove(unitesMortes[1][i]);
			}
		}
		else {
			for(int i = 0 ; i<unitesMortes[1].length ; i++) {
				territoireAtk.unites.remove(unitesMortes[1][i]);
				this.armees.remove(unitesMortes[1][i]);
			}
		}
	}
	
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
		flagFinDePhase =0;
		frame.refreshCarte();
	}
	
	public void boucleAttributionRenfort(Partie partie ,Interface2 frame) {
		frame.refreshCarte();
		frame.affichageUniteCarte(partie);
		frame.affichageRenfortDebutPartie(this);
	}
	
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
		System.out.println("Les unites ont ete refresh");
		frame.choixAttaqueDeplacement(partie, this);
	}
	
}