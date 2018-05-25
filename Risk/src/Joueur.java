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
		
		for(int i = 0 ; i<this.territoires.size()/4; i++) {
			this.ajouterSoldat();
		}
		
		if(!this.regions.isEmpty()) {
			for(int i = 0 ; i < this.regions.size(); i++) {
				territoiresRegion = this.regions.get(i).territoires.size()/2;
				for(int j = 0 ; j < territoiresRegion ; j++) {
					armeesRegion++;
				}
			}
		}
		
		totalRenfort = this.territoires.size()/4 + armeesRegion;
		for(int i = 0 ; i<this.dernieresConquetes ; i++) {
			totalRenfort += ThreadLocalRandom.current().nextInt(0, 2);
		}
		
		for(int i = 0 ; i < totalRenfort ; i++) {
			this.ajouterSoldat();
		}
		
		while(totalRenfort <2) {
			this.ajouterSoldat();
			totalRenfort++;
		}
		
		this.setDernieresConquetes(0);
	}
	
	
	public void action(Partie partie) {
		boolean fin = false;
		Territoires  territoireSelec;
		ArrayList <Territoires> voisins = new ArrayList();
		ArrayList <Territoires> allies = new ArrayList();
		ArrayList <Territoires> ennemis = new ArrayList();
		
		while(!fin) {
			territoireSelec = this.selectionTerritoire();
			System.out.println("Pays sélectionné :");
			System.out.println("      " + territoireSelec.nom);
			System.out.println("");
			voisins = territoireSelec.voisinsTerritoire(partie);
			if(territoireSelec.unites.size()==1 && this.territoires.contains(territoireSelec)) {
				System.out.println("Pas d'actions possibles depuis ce territoire");
			}
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
