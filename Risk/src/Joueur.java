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

	public boolean verifVictoire() {
		if(this.territoires.size() == 42) {
			return true;
		}
		else {
			return false; //ajouter les victoires par mission
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
		int tabPuissance [] = {1,2,3,4,5,6};
		this.armees.add(new Soldat(1,tabPuissance,2,1,2,1,this.armees.get(this.armees.size()-1).numero+1));
	}
	
	public void ajouterCavalier() {
		int tabPuissance [] = {2,3,4,5,6,7};
		this.armees.add(new Cavalier(3,tabPuissance,1,3,3,1,this.armees.get(this.armees.size()-1).numero+1));
	}
	
	public void ajouterCanon() {
		int tabPuissance [] = {4,5,6,7,8,9};
		this.armees.add(new Cavalier(7,tabPuissance,3,2,1,1,this.armees.get(this.armees.size()-1).numero+1));
	}
	
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
		
		//on lui ajoute ces soldats
		for(int i = 0 ; i < totalRenfort ; i++) {
			this.ajouterSoldat();
		}
		
		//si il a recu moins de 2 soldats, on lui en donne jusqu'a ce qu'il en ait eu 2
		while(totalRenfort <2) {
			this.ajouterSoldat();
			totalRenfort++;
		}
		
		//on remet a zero le nombre de conquetes au tour precedent du joueur
		this.setDernieresConquetes(0);
	}
	
	public void choixUnitesCombat(Territoires territoire) {
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
				if (tab[i]<=tab[j]) {
					tab=permute(tab,i,j);
				}
			}
		}
	}
	
	public void bataille(ArrayList <Unite> defense, ArrayList <Unite> attaque) {
		int puissanceDefense [] = new int[defense.size()];
		int puissanceAttaque [] = new int[attaque.size()];
		int randomNum;
		int randomNum2;
		
		//on determine la puissance de chaque unité
		for(int i = 0 ; i< attaque.size();i++) {
			randomNum = ThreadLocalRandom.current().nextInt(attaque.get(i).puissance[0], attaque.get(i).puissance[attaque.get(i).puissance.length-1]);
			puissanceAttaque[i]=randomNum;
			if(i!=2) {
				randomNum2 = ThreadLocalRandom.current().nextInt(defense.get(i).puissance[0], defense.get(i).puissance[defense.get(i).puissance.length-1]);
				puissanceDefense[i]=randomNum2;
			}
		}
		
		//on les trie
		TriParSelection(puissanceAttaque);
		
		//les valeurs sont comparées pour le combat
		if(attaque.size() >= defense.size()) {
			for(int i = 0 ; i <defense.size(); i++) {
				System.out.println(attaque.get(i).numero + " attaque " + defense.get(i).numero + " : " + puissanceAttaque[i] + " vs " + puissanceDefense[i]);
				if(puissanceAttaque[i]>puissanceDefense[i]) {
					System.out.println(defense.get(i).numero + " est mort");
					//defense.remove(i);
				}
				else if(puissanceDefense[i]>puissanceAttaque[i]) {
					System.out.println(attaque.get(i).numero + " est mort");
					//attaque.remove(i);
				}
				else if(defense.get(i).defense > attaque.get(i).attaque) {
					System.out.println(defense.get(i).numero + " est mort");
					//defense.remove(i);
				}
				else if(attaque.get(i).attaque > defense.get(i).defense) {
					System.out.println(attaque.get(i).numero + " est mort");
					//attaque.remove(i);
				}
				else {
					randomNum = ThreadLocalRandom.current().nextInt(0, 2);
					if(randomNum==1) {
						System.out.println(attaque.get(i).numero + " est mort");
						//attaque.remove(i);
					}
					else {
						System.out.println(defense.get(i).numero + " est mort");
						//defense.remove(i);
					}
				}
			}
		}
		else {
			for(int i = 0 ; i <attaque.size(); i++) {
				System.out.println(attaque.get(i).numero + " attaque " + defense.get(i).numero + " : " + puissanceAttaque[i] + " vs " + puissanceDefense[i]);
				if(puissanceAttaque[i]>puissanceDefense[i]) {
					System.out.println(defense.get(i).numero + " est mort");
					//defense.remove(i);
				}
				else if(puissanceDefense[i]>puissanceAttaque[i]) {
					System.out.println(attaque.get(i).numero + " est mort");
					//attaque.remove(i);
				}
				else if(defense.get(i).defense > attaque.get(i).attaque) {
					System.out.println(defense.get(i).numero + " est mort");
					//defense.remove(i);
				}
				else if(attaque.get(i).attaque > defense.get(i).defense) {
					System.out.println(attaque.get(i).numero + " est mort");
					//attaque.remove(i);
				}
				else {
					randomNum = ThreadLocalRandom.current().nextInt(0, 2);
					if(randomNum==1) {
						System.out.println(attaque.get(i).numero + " est mort");
						//attaque.remove(i);
					}
					else {
						System.out.println(defense.get(i).numero + " est mort");
						//defense.remove(i);
					}
				}
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
				
				//choisir une des options puis lancer attaque() ou deplacement()
			}
			
			voisins.clear();
			allies.clear();
			ennemis.clear();
			fin = true;
		}
	}
	
}
